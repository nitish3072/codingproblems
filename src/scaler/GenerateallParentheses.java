package scaler;

import java.util.ArrayList;

public class GenerateallParentheses {

    public ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> list = new ArrayList<>();
        generateParenthesisInternal("", 0, 0, A, list);
        return list;
    }

    private void generateParenthesisInternal(String s, int opening, int closing, int A, ArrayList<String> list) {
        if(s.length()==2*A) {
            list.add(s);
        }
        if(opening+1<=A) {
            generateParenthesisInternal(s+"(", opening+1, closing, A, list);
        }
        if(closing+1<=opening) {
            generateParenthesisInternal(s+")", opening, closing+1, A, list);
        }
    }

    public static void main(String[] args) {
        GenerateallParentheses generateallParentheses = new GenerateallParentheses();
        ArrayList list = generateallParentheses.generateParenthesis(3);
        System.out.println("Hello");
    }
}
