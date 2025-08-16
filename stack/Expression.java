package stack;

import java.util.Arrays;
import java.util.List;

public class Expression {

    private final List<Character> leftBrackets = Arrays.asList('(', '{', '[', '<');
    private final List<Character> rightBrackets = Arrays.asList(')', '}', ']', '>');
    public boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<Character>();
        for(Character ch: input.toCharArray()){
            if(leftBrackets.contains(ch)){
                stack.push(ch);
            }
            if(rightBrackets.contains(ch)){
                if(stack.empty()) return false;
                var top = stack.pop();
                if(leftBrackets.indexOf(top) == rightBrackets.indexOf(ch)) return false;
            }
        }

        return stack.empty();
    }
}