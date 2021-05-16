package leetcode.medium;

import java.util.Stack;

/**
 * https://leetcode.com/problems/validate-stack-sequences/
 */

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i=0, j=0;
        while (true) {
            if(!stack.empty() && stack.peek()==popped[j]) {
                stack.pop();
                j++;
            } else if(i<pushed.length){
               stack.add(pushed[i++]);
            } else {
                break;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        ValidateStackSequences validateStackSequences = new ValidateStackSequences();
        int[] push = {1,2,3,4,5};
        int[] pop = {4,5,3,2,1};
        System.out.println(validateStackSequences.validateStackSequences(push, pop));
    }

}
