package leetcode.april;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(stack.isEmpty()) {
                stack.add(ch);
                continue;
            }
            char lastInStack = stack.peek();
            if((lastInStack=='{' && ch=='}') || (lastInStack=='(' && ch==')') || (lastInStack=='[' && ch==']')) {
                stack.pop();
            } else {
                stack.add(ch);
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String str = "[()]}";
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid(str));
    }

}
