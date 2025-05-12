package scaler;

public class CheckPalindromeRecursion {

    public int solve(String A) {
        return palindrome(A, 0);
    }

    public int palindrome(String A, int i) {
        if(i >= A.length()/2) return 1;
        if(A.charAt(i) != A.charAt(A.length() - i - 1)) return 0;
        return palindrome(A, i+1);
    }

    public static void main(String[] args) {
        CheckPalindromeRecursion f = new CheckPalindromeRecursion();
        System.out.println(f.solve("anagram"));
    }
}
