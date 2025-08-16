package stack;

public class Main {
    public static void main(String[] args) {
        // var numStack = new Stack<Integer>(10);
        // numStack.push(10);
        // numStack.push(20);
        // numStack.push(30);

        // System.out.println(numStack.peek());
        // System.out.println(numStack.toString());
        // System.out.println(numStack.pop());
        // System.out.println(numStack.toString());
        
        var reverser = new StringReverser();

        System.out.println(reverser.reverse("hdeeraf"));

    }

}
