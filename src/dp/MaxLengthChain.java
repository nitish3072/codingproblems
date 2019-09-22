package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * https://practice.geeksforgeeks.org/problems/max-length-chain/1
 */
public class MaxLengthChain {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.valueOf(reader.readLine());
        while (testCases-- > 0) {
            int number = Integer.valueOf(reader.readLine());
            String[] str = reader.readLine().split(" ");
            int[][] array = new int[number][2];
            for(int i=0;i<str.length;i=i+2) {
                array[i/2][0] = Integer.valueOf(str[i]);
                array[i/2][1] = Integer.valueOf(str[i+1]);
            }
            array = Arrays.stream(array).sorted(Comparator.comparing(ints -> ints[1])).toArray(int[][]::new);
            int[] dpArray = new int[number];
            dpArray[0]=1;

            // Making a 1d array and finding if pointer element 0th element is greater than 1st element of already passed through elements
            // If yes then take max of all these values and add 1 to the max value.
            // Logic is to arrange the array according to second element of chain and find if x value is greater than any of the y value for the elements before it.
            // Once this is found we need to take max possible outcome to get maximum length
            for(int i=1;i<number;i++) {
                int max = 0;
                for(int j=i-1;j>=0;j--) {
                    if(array[i][0]>array[j][1]) {
                        max = Math.max(max, dpArray[j]);
                    }
                }
                dpArray[i] = max + 1;
            }
            System.out.println(Arrays.stream(dpArray).max().getAsInt());
        }
    }
}