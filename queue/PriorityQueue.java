package queue;

import java.util.Arrays;

public class PriorityQueue {
    private int defaultSize = 5;
    private int[] items;
    private int count;

    public PriorityQueue() {
        this.items = new int[defaultSize];
    }

    public PriorityQueue(int size) {
        this.items = new int[Math.max(size, defaultSize)];
    }

    public void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }

        int i = shiftItemsToInsert(value);
        items[i] = value;
        count++;
    }

    private int shiftItemsToInsert(int value) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] > value) {
                items[i + 1] = items[i];
            } else {
                break;
            }
        }
        return i + 1;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return items[--count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
