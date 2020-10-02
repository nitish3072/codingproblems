package leetcode.easy;

import java.math.BigDecimal;

/**
 * https://leetcode.com/problems/add-strings/
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        int p1 = num1.length()-1;
        int p2 = num2.length()-1;
        int carry = 0;
        StringBuilder finalAnswer = new StringBuilder();
        while (p1>=0 || p2>=0) {
            int char1 = p1>=0 ? num1.charAt(p1) - '0' : 0;
            int char2 = p2>=0 ? num2.charAt(p2) - '0' : 0;
            int sum = char1 + char2 + carry;
            finalAnswer = new StringBuilder((sum) % 10  + finalAnswer.toString());
            if(sum>=10) {
                carry = 1;
            } else {
                carry = 0;
            }
            p1--;p2--;
        }
        if(carry == 1) {
            finalAnswer = new StringBuilder(carry + finalAnswer.toString());
        }
        return finalAnswer.toString();
    }

    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        System.out.println(addStrings.addStrings("584", "18"));
    }
}
