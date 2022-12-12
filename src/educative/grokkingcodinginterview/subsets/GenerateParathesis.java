package educative.grokkingcodinginterview.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParathesis {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        bracket(result, "", 0,0, n);
        return result;
    }

    public static void bracket(List<String> result, String tempStr, int open, int close, int n) {
        if(tempStr.length()==2*n) {
            result.add(tempStr);
        } else {
            if(open < n)
                bracket(result, tempStr+"(", open+1, close, n);
            if(close < open)
                bracket(result, tempStr+")", open, close+1, n);
        }
    }

    public static void main(String[] args) {
        List<String> result;
        int[] n = {1, 2, 3, 4, 5};
        for (int i = 0; i < n.length; i++) {

            System.out.println (i+1 + ".\tn = "+ n[i]);
            System.out.println ("\tAll combinations of valid balanced parentheses:");
            result = generateParenthesis(n[i]);
            for (int j = 0; j < result.size(); j++) {
                System.out.println("\t\t" + result.get(j));
            }
        }
    }
}
