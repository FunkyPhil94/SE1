package org.hbrs.se1.ws24.exercises.uebung10;

import java.util.Stack;

public class LimitedStack<E> extends Stack<E> {

    private int maxSize;

    public LimitedStack(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public E push(E item) {
        if (this.size() >= maxSize) {
            throw new IllegalStateException("Stack is full!");
        }
        return super.push(item);
    }
}
