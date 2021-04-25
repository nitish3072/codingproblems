package leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

public class ScoreofParentheses {

    public int scoreOfParentheses(String S) {
        Stack<ElementIndex> stack = new Stack<>();
        int[] dp = new int[S.length()];
        for(int i=0;i<S.length();i++) {
            boolean isStackEmpty = stack.isEmpty();
            ElementIndex lastElemInStack = isStackEmpty ? null : stack.peek();
            if(!isStackEmpty && lastElemInStack.index==i-1 && lastElemInStack.c=='(' && S.charAt(i)==')') {
                dp[i] = 1;
                stack.pop();
            } else if(!isStackEmpty && lastElemInStack.c=='(' && S.charAt(i)==')') {
                int sum = 0;
                for(int j=lastElemInStack.index; j<i; j++) {
                    sum += dp[j];
                    dp[j]=0;
                }
                dp[i] = 2*sum;
                stack.pop();
            } else {
                dp[i] = 0;
                stack.add(new ElementIndex(S.charAt(i), i));
            }
        }
        return Arrays.stream(dp).sum();
    }

    public static void main(String[] args) {
        ScoreofParentheses scoreofParentheses = new ScoreofParentheses();
        System.out.println(scoreofParentheses.scoreOfParentheses("(()(()))"));
    }

}

class ElementIndex {
    Character c;
    int index;

    public ElementIndex(Character c, int index) {
        this.c = c;
        this.index = index;
    }
}
