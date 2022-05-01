package leetcode.april.easy;

/**
 * https://leetcode.com/problems/palindrome-number/submissions/
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        String number = convertIntToString(x);
        int leftPtr = 0;
        int rightPtr = number.length()-1;
        while (leftPtr<rightPtr) {
            if(number.charAt(leftPtr)!=number.charAt(rightPtr)) {
                return false;
            }
            leftPtr++;rightPtr--;
        }
        return true;
    }

    public String convertIntToString(int number) {
        int remainder = number%10;
        int quotient = number/10;
        StringBuilder str = new StringBuilder(String.valueOf(remainder));
        while (quotient!=0) {
            remainder = quotient%10;
            quotient = quotient/10;
            str.append(remainder);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(121));
    }
}
