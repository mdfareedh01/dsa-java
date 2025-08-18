package queue;

import java.util.ArrayDeque;
import java.util.Queue;

import stack.Stack;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue);
        reverse(queue);
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
