package scaler.dp1;

import java.util.Scanner;

public class FibonacciNumber {

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scanner = new Scanner(System.in);
        int A = Integer.valueOf(scanner.nextLine());
        int[] dp = new int[A + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= A; i++) {
            if (dp[i] == 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        System.out.println(dp[A]);
    }



}
