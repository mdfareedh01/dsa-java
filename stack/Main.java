package stack;

public class Main {
    public static void main(String[] args) {
        var stack = new Stack(10);
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.peek());
        System.out.println(stack.toString());
        System.out.println(stack.pop());
        System.out.println(stack.toString());

    }

}
