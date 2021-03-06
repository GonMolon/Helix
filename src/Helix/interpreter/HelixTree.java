package Helix.interpreter;

import Helix.parser.HelixLexer;
import org.antlr.runtime.tree.*;
import org.antlr.runtime.Token;

import java.util.Iterator;


public class HelixTree extends CommonTree implements Iterable<HelixTree>{

    private double numValue;

    public HelixTree(Token t) {
        super(t);
        setNodeValue();
    }

    public HelixTree getChild(int i) {
        return (HelixTree) super.getChild(i);
    }

    private void setNodeValue() {
        switch(this.getType()) {
            case HelixLexer.NUM:
                numValue = Double.parseDouble(getText());
                break;
            case HelixLexer.BOOLEAN:
                numValue = getText().equals("true") ? 1 : 0;
                break;
        }
    }

    public double getNumValue() {
        return numValue;
    }


    public boolean getBoolValue() {
        return !(numValue == 0);
    }


    public Iterator<HelixTree> iterator() {
        return new Iterator<HelixTree>() {
            private int next_child = 0;

            @Override
            public boolean hasNext() {
                return next_child < getChildCount();
            }

            @Override
            public HelixTree next() {
                return getChild(next_child++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("nope");
            }
        };
    }

}
