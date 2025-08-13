package linkedlist;

import java.util.NoSuchElementException;

public class LinkedList {

    public class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node first;
    public Node last;
    private int size = 0;

    /*
     * Add Last
     * 1. if not empty
     * f l
     * [10 -> 20 -> 30 -> 40 -> 50]
     * 
     * n
     * [60]
     * 
     * f l n
     * [10 -> 20 -> 30 -> 40 -> 50 -> 60]
     * 
     * f l
     * [10 -> 20 -> 30 -> 40 -> 50 -> 60]
     * 
     * 2. if Empty
     * 
     * f,l
     * []
     * 
     * f,l
     * [10]
     * 
     * 
     */

    public void addLast(int item) {
        Node node = new Node(item);

        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }

        size++;
    }
    /*
     * Add first
     * 1. if not empty
     * f l
     * [10 -> 20 -> 30 -> 40 -> 50]
     * 
     * n
     * [60]
     * 
     * n f l
     * [ 60 -> 10 -> 20 -> 30 -> 40 -> 50]
     * 
     * f l
     * [ 60 -> 10 -> 20 -> 30 -> 40 -> 50]
     * 
     * 2. if Empty
     * 
     * f,l
     * []
     * 
     * f,l
     * [10]
     */

    public void addFirst(int item) {
        Node node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }

        size++;
    }

    /*
     * Remove First
     * 1. Only one
     * 
     * f,l
     * [10]
     * 
     * f,l
     * []
     * 
     * 2. If more than one
     * f l
     * [10 -> 20 -> 30 -> 40 -> 50 -> 60]
     * 
     * f s l
     * [10 -> 20 -> 30 -> 40 -> 50 -> 60]
     *
     * f
     * [10 -> ]
     * 
     * f,s l
     * [10 20 -> 30 -> 40 -> 50 -> 60]
     * 
     * 
     * [10] - garbage collector will clean
     * 
     * f l
     * [20 -> 30 -> 40 -> 50 -> 60]
     * 
     * 
     */

    public void deleteFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
        } else {
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    /*
     * Remove Last
     * 
     * 1. Only one
     * 
     * f,l
     * [10]
     * 
     * f,l
     * []
     * 
     * 2. More than one
     * 
     * f l
     * [10 -> 20 -> 30 -> 40 -> 50 -> 60]
     * 
     * f p l
     * [10 -> 20 -> 30 -> 40 -> 50 -> 60]
     * 
     * f p l
     * [10 -> 20 -> 30 -> 40 -> 50 60]
     * 
     * 
     * [60] - garebage collector will clean
     * 
     * f l
     * [10 -> 20 -> 30 -> 40 -> 50]
     * 
     */

    public void deleteLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
        } else {
            var previous = getPrevious(last);
            previous.next = null;
            last = previous;
        }
        size--;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;

    }

    public int indexOf(int value) {
        int index = 0;
        var current = first;

        while (current != null) {
            if (current.value == value)
                return index;
            current = current.next;
            index++;
        }

        return -1;
    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node)
                break;
            current = current.next;
        }
        return current;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public int[] toArray() {
        int[] array = new int[size];
        Node current = first;
        var index = 0;

        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    // [10 -> 20 -> 30 -> 40]
    // p c n

    /*
     * Reversing a linked list
     * 
     * f l
     * [10 -> 20 -> 30 -> 40 -> 50 -> 60]
     * 
     * p c n
     * [10 -> 20 -> 30 -> 40 -> 50 -> 60]
     *
     * p c n
     * [10 20 -> 30 -> 40 -> 50 -> 60]
     *
     * p c n
     * [10 <- 20 30 -> 40 -> 50 -> 60]
     *
     * p c n
     * [10 <- 20 30 -> 40 -> 50 -> 60]
     *
     * p c n
     * [10 <- 20 <- 30 40 -> 50 -> 60]
     *
     * p c n
     * [10 <- 20 <- 30 40 -> 50 -> 60]
     *
     * p c n
     * [10 <- 20 <- 30 <- 40 50 -> 60]
     *
     * p c n
     * [10 <- 20 <- 30 <- 40 50 -> 60]
     *
     * p c n
     * [10 <- 20 <- 30 <- 40 <- 50 60]
     *
     * p c n
     * [10 <- 20 <- 30 <- 40 <- 50 60]
     *
     * p c n
     * [10 <- 20 <- 30 <- 40 <- 50 <- 60]
     *
     * p c n
     * [10 <- 20 <- 30 <- 40 <- 50 <- 60]
     *
     * l p,f
     * [10 <- 20 <- 30 <- 40 <- 50 <- 60]
     *
     * l f
     * [10 <- 20 <- 30 <- 40 <- 50 <- 60]
     *
     * f l
     * [60 -> 50 -> 40 -> 30 -> 20 -> 10]
     * 
     */

    public void reverse() {
        if (isEmpty())
            return;

        var previous = first;
        var current = first.next;

        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthNode(int k) {
        if (isEmpty())
            throw new IllegalStateException();

        var a = first;
        var b = first;

        for (int i = 0; i < k - 1; i++) {
            b = b.next;

            // making sure the number k does not exceed the number of
            if (b == null)
                throw new IllegalArgumentException();
        }
        while (b != last) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

}
