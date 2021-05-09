package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String currentString, int open, int close, int n) {
        if(currentString.length()==n*2) {
            list.add(currentString);
            return;
        }
        if(open < n)
            backtrack(list, currentString+"(", open+1, close, n);
        if(close < open)
            backtrack(list, currentString+")", open, close+1, n);
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        generateParentheses.generateParenthesis(5);
    }
}
