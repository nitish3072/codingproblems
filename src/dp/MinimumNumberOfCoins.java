package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://practice.geeksforgeeks.org/problems/-minimum-number-of-coins/0
 */
public class MinimumNumberOfCoins {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.valueOf(reader.readLine());
        while (testCases-- > 0) {
            int number = Integer.valueOf(reader.readLine());
            int[] denominations = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };

            // Number Array from 1-n
            int[] numbers = new int[number+1];
            for(int i =1;i<number+1;i++) {
                numbers[i] = i;
            }

            // Computing dpArray here
            // If number/denomination > 0 then go left denomination number of times, get dpArray at that place and add one to it
            // Or else take from above
            int[][] dpArray = new int[denominations.length][numbers.length];
            for(int i=0;i<denominations.length;i++) {
                for(int j=1;j<numbers.length;j++) {
                    if(numbers[j]/denominations[i]>0) {
                        dpArray[i][j] = dpArray[i][j-denominations[i]] +1;
                    } else {
                        dpArray[i][j] = dpArray[i-1][j];
                    }
                }
            }
            printCoins(dpArray, numbers, denominations);
        }
    }

    public static void printCoins(int[][] dpArray, int[] numbers, int[] denominations) {
        int x=numbers.length-1;
        int y=denominations.length-1;
        while (x>0&&y>=0) {
            if(y==0 || dpArray[y][x]!=dpArray[y-1][x]) {
                x=x-denominations[y];
                System.out.print(denominations[y]+" ");
            } else {
                y--;
            }
        }
        System.out.println();
    }

}
