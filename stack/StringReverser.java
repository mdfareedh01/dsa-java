package stack;

public class StringReverser {
    public String reverse(String input) {

        Stack<Character> stack = new Stack<Character>(2);

        for(char ch: input.toCharArray()){
            stack.push(ch);
        }

        StringBuffer reversed = new StringBuffer();

        while(!stack.empty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }
}
