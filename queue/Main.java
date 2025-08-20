package queue;

import java.util.ArrayDeque;
import java.util.Queue;

import stack.Stack;

public class Main {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        queue.dequeue();
        // queue.dequeue();
        var first = queue.peek();
        System.out.println(first);
    }

    public static void reverse(Queue<Integer> queue) {
        Stack<Integer> stack1 = new Stack<>();

        while(!queue.isEmpty())
            stack1.push(queue.remove());
        while(!stack1.isEmpty())
            queue.add(stack1.pop());
    }
}
