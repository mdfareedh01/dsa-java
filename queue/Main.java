package queue;

import java.util.ArrayDeque;
import java.util.Queue;

import stack.Stack;

public class Main {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue<Integer>(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        var front = queue.dequeue();
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);
        queue.enqueue(80);
        System.out.println(front);
        System.out.println(queue);


    }

    public static void reverse(Queue<Integer> queue) {
        Stack<Integer> stack1 = new Stack<>();

        while(!queue.isEmpty())
            stack1.push(queue.remove());
        while(!stack1.isEmpty())
            queue.add(stack1.pop());
    }
}
