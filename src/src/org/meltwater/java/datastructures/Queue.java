package org.meltwater.java.datastructures;

import java.util.Arrays;

public class Queue<E> {
    int size;
    int length;
    private E[] elements;


    public Queue(int n) {
        length = n;
        elements = (E[]) (new Object[n]);
        size = 0;
    }

    public void add(E e) throws StackOverflowError {
        if (isFull()) {
            //throw error
        }
        elements[size] = e;
        size++;
    }

    public E peek() {
        return elements[0];
    }

    public E poll() {
        E temp = elements[0];
        for (int i = 0; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size] = null;
        size--;
        return temp;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i <= size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    public boolean isFull() {
        if (size == length)
            return true;
        else
            return false;
    }

    public E[] toArray() {
        return elements;
    }

    public String toString() {
        return Arrays.toString(elements);
    }

}
