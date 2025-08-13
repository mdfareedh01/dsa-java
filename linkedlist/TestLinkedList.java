package linkedlist;

import java.util.NoSuchElementException;

public class TestLinkedList {

    public class Node {
        private Node next;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    private int size;
    private Node first;
    private Node last;

    private boolean isEmpty() {
        return first == null;
    }

    public void addFirst(int value) {

        var node = new Node(value);

        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }

        size++;
    }

    public void addLast(int value) {
        var node = new Node(value);

        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public void removeFirst() {
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

    public void removeLast() {
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

    public int[] toArray() {
        var array = new int[size];
        var current = first;
        var count = 0;

        while (current != null) {
            array[count++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void reverse() {
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
            if (b == null)
                throw new IllegalArgumentException();
        }

        while (b != last)
            b = b.next;
        a = a.next;

        return a.value;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public int indexOf(int value) {
        int index = 0;
        var current = first;

        while (current != null) {
            if (current.value == value)
                break;
            index++;
        }

        return index;
    }

    public Node getPrevious(Node node) {

        var current = first;

        while (current != null) {
            if (current.next == node)
                break;
            current = current.next;
        }

        return current;
    }
}
