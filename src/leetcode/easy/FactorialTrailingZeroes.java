package leetcode.easy;

/**
 * https://leetcode.com/problems/factorial-trailing-zeroes/submissions/
 */
public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        int dividor = 5;
        int zeroes = 0;
        while(dividor<=n) {
            zeroes = zeroes + n/dividor;
            dividor = dividor*5;
        }
        return zeroes;
    }

}
