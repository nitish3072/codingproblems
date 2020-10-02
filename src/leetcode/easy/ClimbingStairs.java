package leetcode.easy;

import java.math.BigInteger;

/**
 * https://leetcode.com/problems/climbing-stairs/submissions/
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        int totalWays = 0;
        for(int i=0 ;i<=n/2; i++) {
            int numberOfTwos = i;
            int numberOfOnes = n - 2*numberOfTwos;
            totalWays = totalWays + factorial(numberOfOnes+numberOfTwos).divide (factorial(numberOfOnes).multiply(factorial(numberOfTwos))).intValue();
        }
        return totalWays;
    }

    public BigInteger factorial(int number) {
        BigInteger result = new BigInteger("1");
        while (number>1) {
            result = result.multiply(new BigInteger(String.valueOf(number)));
            number -- ;
        }
        return result;
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.factorial(35));
        System.out.println(climbingStairs.climbStairs(35));
    }
}


//n = 2*x + 1*z
