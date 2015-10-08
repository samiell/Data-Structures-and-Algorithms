package org.meltwater.java.datastructures;

public class BinarySearchTree<Value> {
    public Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    /*add(E element) -> Adds element to the tree.*/
    public void add(int element) {
        this.root = add(root, element);
    }

    private Node add(Node node, int element) {
        if (node == null) {
            node = new Node(element);
            node.N++;
        } else {
            if (contains(node, element)) {
                System.out.println("Duplicate value! -> " + element);
                return (node);
            }
            if (node.value > element) {
                node.left = add(node.left, element);
                node.N++;
            }
            if (node.value < element) {
                node.right = add(node.right, element);
                node.N++;
            }
        }
        return (node);
    }

    /*remove(E element) -> Removes element from the tree.*/
//    size() -> Returns the total number of nodes in the tree.
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.N;
    }

    //    contains(E element) -> Returns true if element is in tree, false otherwise.
    public boolean contains(int element) {
        return contains(root, element);
    }

    private boolean contains(Node node, int element) {
        if (node == null) return false;
        if (node.value == element) {
            return true;
        } else {
            if (node.value > element) {
                return contains(node.right, element);
            } else {
                return contains(node.left, element);
            }
        }
    }

    //    smallest() -> Returns the node that has the smallest value.
    public int smallest() {
        return smallest(root);
    }

    private int smallest(Node node) {
        if (node.left == null) return node.value;
        return smallest(node.left);
    }

    //    largest() -> Returns the node that has the largest value.
    public int largest() {
        return largest(root);
    }

    private int largest(Node node) {
        if (node.right == null) return node.value;
        return largest(node.right);
    }

    //    toString() -> Returns String representation of the node values, sorted in ascending order.
    public void toString(Node node) {
        if (node != null) {
            toString(node.left);
            System.out.print(node.value + " - ");
            toString(node.right);
        }
    }

    private class Node {
        public int value;
        public int N; // Number of trees in subtree
        Node left, right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}