package org.meltwater.java.datastructures;

public class Stack<E> {

    private static final int STACK_SIZE = 10;
    private static final int EMPTY = -1;
    E[] stackArray; // Create Generic Array
    private int index;
    private E[] elements;

    public void push(E element) {
        if (index == STACK_SIZE - 1) // if stack is full
            throw new FullStackException(String.format("Stack is full", element));

        elements[++index] = element; // place pushValue on Stack
    }

    class EmptyStackException extends RuntimeException {
        public EmptyStackException() {
            this("Stack is empty");
        }

        public EmptyStackException(String exception) {
            super(exception);
        }
    }

    class FullStackException extends RuntimeException {
        public FullStackException() {
            this("Stack is full");
        }

        public FullStackException(String exception) {
            super(exception);
        }
    }
}
