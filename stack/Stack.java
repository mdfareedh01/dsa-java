package stack;
import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> {
    private T[] items;
    private int count;
    private final int minCapacity = 10;

    @SuppressWarnings("unchecked")
    public Stack() {
        this.items = (T[]) new Object[minCapacity];
    }

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        if(size < 0) throw new IllegalArgumentException();
        this.items = (T[]) new Object[size == 0 ? minCapacity : size];
    }

    public void push(T value) {
        expand();
        items[count++] = value;
    }

    @SuppressWarnings("unchecked")
    private void expand() {
        if(items.length  == count){

            //manual method

            // T[] newElements = (T[]) new Object[count *2];
            // for(int i = 0; i < count; i++) {
            //     newElements[i] = items[i];
            // }
            // items = newElements;

            //native way (c code optimized)

            items = Arrays.copyOf(items, count * 2);
        }
    }
    
    @SuppressWarnings("unchecked")
    private void shrink() {
        if((items.length/4) > count && (items.length / 2) >= minCapacity){

            //manual method
            // T[] newElements = (T[]) new Object[items.length/2];
            // for(int i = 0; i < count; i++) {
            //     newElements[i] = items[i];
            // }
            // items = newElements;

            //native (c code optimized)
            items = Arrays.copyOf(items, items.length/2);
        }
    }

    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();
        T value = items[--count];
        items[count] = null; // prevent loitering
        shrink();
        return value;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return items[count - 1];
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(content);
    }
}