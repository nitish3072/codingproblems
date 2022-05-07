package leetcode.april.easy;

/**
 * https://leetcode.com/problems/valid-perfect-square/
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        long number = 1;
        while (number * number <= num) {
            if (number * number == num) {
                return true;
            }
            number++;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
        System.out.println(validPerfectSquare.isPerfectSquare(17));
    }

}
