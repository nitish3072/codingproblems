package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://practice.geeksforgeeks.org/problems/find-optimum-operation/0
 */
public class MinimumOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.valueOf(reader.readLine());
        while (testCases-- > 0) {
            int number = Integer.valueOf(reader.readLine());
            int operations = 0;
            while (number!=0) {
                if(number%2==0) {
                    number = number/2;
                } else {
                    number = number - 1;
                }
                operations++;
            }
            System.out.println(operations);
        }
    }
}