/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package Helix.interpreter.controller.librepilot.uavtalk.device;


import Helix.interpreter.controller.librepilot.uavtalk.Utils;
import Helix.interpreter.controller.librepilot.uavtalk.UAVTalkMessage;
import Helix.interpreter.controller.librepilot.uavtalk.UAVTalkObject;
import Helix.interpreter.controller.librepilot.uavtalk.UAVTalkObjectInstance;

import javax.usb.UsbEndpoint;
import javax.usb.UsbException;
import javax.usb.UsbPipe;
import java.util.ArrayDeque;
import java.util.Queue;

class FcUsbWaiterThread extends FcWaiterThread {

    private final UsbEndpoint mEndpointIn;
    private boolean mStop;
    private Queue<Byte> queue;

    public FcUsbWaiterThread(FcDevice device, UsbEndpoint endpointIn) {
        super(device);
        this.mEndpointIn = endpointIn;
        this.setName("LP2GoDeviceUsbWaiterThread");
    }

    @Override
    protected void stopThread() {
        this.mStop = true;
    }

    private byte[] bufferRead(int len) {
        byte[] retval = new byte[len];
        for (int i = 0; i < len; i++) {
            if (!queue.isEmpty()) {
                retval[i] = queue.remove();
            }
        }
        return retval;
    }

    public void run() {

        queue = new ArrayDeque<>();

        byte[] syncbuffer = new byte[1];
        byte[] msgtypebuffer = new byte[1];
        byte[] lenbuffer = new byte[2];
        byte[] oidbuffer = new byte[4];
        byte[] iidbuffer = new byte[2];
        byte[] timestampbuffer = new byte[2];
        byte[] databuffer;
        byte[] crcbuffer = new byte[1];

        //mDevice.mActivity.setRxObjectsGood(0);
        //mDevice.mActivity.setRxObjectsBad(0);
        //mDevice.mActivity.setTxObjects(0);

        while (true) {

            if (mStop) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    //Thread wakes up
                }
                continue;
            }

            byte[] buffer = new byte[64];
            //System.out.println("Loop in " + queue.size() + " " + mEndpointIn.getUsbEndpointDescriptor().wMaxPacketSize());

            while (queue.size() < 350) {


                //mUsbDeviceConnection.bulkTransfer(mEndpointIn, buffer, buffer.length, 1000);
                UsbPipe pipe = mEndpointIn.getUsbPipe();

                try {
                    pipe.open();
                    int received = pipe.syncSubmit(buffer);
                    //System.out.println(received + " bytes received");
                } catch (UsbException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        pipe.close();
                    } catch (UsbException e) {
                        e.printStackTrace();
                    }
                }


                try {
                    for (int i = 2; i < (buffer[1] & 0xff) + 2; i++) {
                        queue.add(buffer[i]);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("FcUsbWaiterThread: " + "AIOOBE in Usb Queue filler");
                }
            }

            syncbuffer[0] = 0x00;
            while (syncbuffer[0] != 0x3c) {
                syncbuffer = bufferRead(1);
            }

            msgtypebuffer = bufferRead(msgtypebuffer.length);

            lenbuffer = bufferRead(lenbuffer.length);

            int lb1 = lenbuffer[1] & 0x000000ff;
            int lb2 = lenbuffer[0] & 0x000000ff;
            int len = lb1 << 8 | lb2;

            if (len > 266 || len < 10) {
                //mDevice.mActivity.incRxObjectsBad();
                continue; // maximum possible packet size
            }

            oidbuffer = bufferRead(oidbuffer.length);
            iidbuffer = bufferRead(iidbuffer.length);

            int tsoffset = 0;
            if ((MASK_TIMESTAMP & msgtypebuffer[0]) == MASK_TIMESTAMP) {
                timestampbuffer = bufferRead(timestampbuffer.length);
                tsoffset = 2;
            }

            databuffer = bufferRead(len - (10 + tsoffset));
            crcbuffer = bufferRead(crcbuffer.length);

            byte[] bmsg = Utils.concatArray(syncbuffer, msgtypebuffer);
            bmsg = Utils.concatArray(bmsg, lenbuffer);
            bmsg = Utils.concatArray(bmsg, oidbuffer);
            bmsg = Utils.concatArray(bmsg, iidbuffer);
            if ((MASK_TIMESTAMP & msgtypebuffer[0]) == MASK_TIMESTAMP) {
                bmsg = Utils.concatArray(bmsg, timestampbuffer);
            }
            bmsg = Utils.concatArray(bmsg, databuffer);
            int crc = Utils.crc8(bmsg, 0, bmsg.length);
            bmsg = Utils.concatArray(bmsg, crcbuffer);

            if ((((int) crcbuffer[0] & 0xff) == (crc & 0xff))) {
                //mDevice.mActivity.incRxObjectsGood();
            } else {
                //mDevice.mActivity.incRxObjectsBad();
                System.out.println("USB: " + "Bad CRC");
                continue;
            }

            try {
                UAVTalkMessage msg = new UAVTalkMessage(bmsg, 0);
                UAVTalkObject myObj = mDevice.mObjectTree.getObjectFromID(Utils.intToHex(msg.getObjectId()));
                if(myObj == null) {
                    continue;
                }

                UAVTalkObjectInstance myIns;
                try {
                    myIns = myObj.getInstance(msg.getInstanceId());
                    myIns.setData(msg.getData());
                    myObj.setInstance(myIns);
                } catch (Exception e) {
                    myIns = new UAVTalkObjectInstance(msg.getInstanceId(), msg.getData());
                    myObj.setInstance(myIns);
                }

                if (handleMessageType(msgtypebuffer[0], myObj)) {
                    mDevice.mObjectTree.updateObject(myObj);
                    if (mDevice.isLogging()) {
                        mDevice.log(msg);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}