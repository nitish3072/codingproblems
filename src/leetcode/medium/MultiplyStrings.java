package leetcode.medium;

import java.math.BigInteger;

/**
 * https://leetcode.com/problems/multiply-strings/
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        BigInteger bigInteger1 = new BigInteger(num1);
        BigInteger bigInteger2 = new BigInteger(num2);
        return  bigInteger1.multiply(bigInteger2).toString();
    }

    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply("123", "456"));
    }

}
