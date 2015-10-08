package org.meltwater.java.datastructures;

public class SinglyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;

    public void push(E element) {

        Node<E> nd = new Node<>();
        nd.setValue(element);
        System.out.println("Adding: " + element);

        if (head == null) {

            head = nd;
            tail = nd;
        } else {

            tail.setNextRef(nd);

            tail = nd;
        }
    }

    public void addAfter(E element, E after) {

        Node<E> tmp = head;
        Node<E> refNode = null;
        System.out.println('\n' + "Add after a Node");

        while (true) {
            if (tmp == null) {
                break;
            }
            if (tmp.compareTo(after) == 0) {

                refNode = tmp;
                break;
            }
            tmp = tmp.getNextRef();
        }
        if (refNode != null) {

            Node<E> nd = new Node<E>();
            nd.setValue(element);
            nd.setNextRef(tmp.getNextRef());
            if (tmp == tail) {
                tail = nd;
            }
            tmp.setNextRef(nd);

        } else {
            System.out.println("Element not found...");
        }
    }

    public void deleteFront() {

        if (head == null) {
            System.out.println("Underflow...");
        }
        Node<E> tmp = head;
        head = tmp.getNextRef();
        if (head == null) {
            tail = null;
        }
        System.out.println("Deleted: " + tmp.getValue());
    }

    public void deleteAfter(E after) {

        Node<E> tmp = head;
        Node<E> refNode = null;
        System.out.println('\n' + "Delete after a node");

        while (true) {
            if (tmp == null) {
                break;
            }
            if (tmp.compareTo(after) == 0) {

                refNode = tmp;
                break;
            }
            tmp = tmp.getNextRef();
        }
        if (refNode != null) {
            tmp = refNode.getNextRef();
            refNode.setNextRef(tmp.getNextRef());
            if (refNode.getNextRef() == null) {
                tail = refNode;
            }
            System.out.println("Deleted: " + tmp.getValue());
        } else {
            System.out.println("Element not found...");
        }
    }

    public void display() {
        System.out.print("LinkedList:");
        Node<E> tmp = head;
        while (true) {
            if (tmp == null) {
                break;
            }
            System.out.print(" " + tmp.getValue());
            tmp = tmp.getNextRef();

        }
        System.out.println();

    }

    public void peek() {
        Node<E> tmp = head;
        E n = tmp.getValue();
        System.out.println('\n' + "" + n);
    }
}

class Node<E> implements Comparable<E> {

    private E value;
    private Node<E> nextRef;

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getNextRef() {
        return nextRef;
    }

    public void setNextRef(Node<E> ref) {
        this.nextRef = ref;
    }

    public int compareTo(E arg) {
        if (arg == this.value) {
            return 0;
        } else {
            return 1;
        }
    }
}
