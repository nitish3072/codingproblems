package leetcode.medium;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/discuss/383670/JavaC%2B%2BPython-Tenet-O(N)-Solution
 */
public class ReverseSubstringsBetweenEachPairParentheses {

    public String reverseParentheses(String s) {
        Stack<Integer> brackets = new Stack<>();
        for(int i=0;i<s.length();i++) {
            if(!brackets.empty() && s.charAt(brackets.peek()) == '(' && s.charAt(i)==')') {
                int startIndex = brackets.pop() + 1;
                int endIndex = i;
                String stringInsideBracket = s.substring(startIndex, endIndex);
                String reverseString = reverseString(stringInsideBracket);
                s = s.substring(0, startIndex) + reverseString + s.substring(endIndex, s.length());
            }
            if(s.charAt(i)=='(') {
                brackets.push(i);
            }
        }
        return s.replace("(", "").replace(")", "");
    }

    public String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        ReverseSubstringsBetweenEachPairParentheses reverseSubstringsBetweenEachPairParentheses = new ReverseSubstringsBetweenEachPairParentheses();
        System.out.println(reverseSubstringsBetweenEachPairParentheses.reverseParentheses("(ed(et(oc))el)"));
    }

}
