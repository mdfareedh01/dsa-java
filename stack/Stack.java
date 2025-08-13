package stack;
import java.util.Arrays;

public class Stack {
    private int[] items;
    private int count;

    public Stack(int size) {
        this.items = new int[size];
    }

    public void push(int value) {
        if (count == items.length) {
            throw new StackOverflowError();
        }
        items[count] = value;
        count++;
    }

    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();
        count--;
        return items[count];
    }

    private boolean isEmpty() {
        return count == 0;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        return items[count - 1];
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(content);
    }
}
