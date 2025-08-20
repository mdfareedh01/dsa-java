package queue;

import java.util.Arrays;

public class ArrayQueue<T> {
    private T[] items;
    private int rear;
    private int front;
    private int count;
    
    @SuppressWarnings("unchecked")
    public ArrayQueue(int size) {
        this.items = (T[]) new Object[size];
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        this.items = (T[]) new Object[10];
    }

    public void enqueue(T value) {
        if(count == items.length) {
            throw new IllegalStateException();
        }

        items[rear] = value;
        rear = (rear + 1) % items.length;
        count++;
    }

    public T dequeue() {
        var value = items[front];
        items[front] = null;
        front = (front + 1) % items.length;
        count--;
        return value;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
