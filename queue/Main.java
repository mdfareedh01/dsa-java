package queue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(5);
        queue.enqueue(10);
        queue.enqueue(30);
        queue.enqueue(50);
        System.out.println(queue);
        queue.enqueue(60);
        System.out.println(queue);
        
        queue.enqueue(40);

        System.out.println(queue);
        
        System.out.println(queue.dequeue());

    }
}
