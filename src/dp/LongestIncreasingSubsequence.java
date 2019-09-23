package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence/0
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.valueOf(reader.readLine());
        while (testCases-- > 0) {
            int size = Integer.valueOf(reader.readLine());
            String[] str = reader.readLine().split(" ");
            // Number Array from 1-n
            int[] numbers = new int[size];
            for(int i =0;i<size;i++) {
                numbers[i] = Integer.valueOf(str[i]);
            }

            // Problem starts
            int[] dpArray = new int[size];
            dpArray[0]=1;
            int i =0,j=1;
            // take 2 indexes and move these indexes such that number at i is less than number at j and add 1 to the dpArray at i to create dpArray at j
            while (j<size) {
                if(numbers[i]<numbers[j]) {
                    dpArray[j] = Math.max(dpArray[j], dpArray[i]+1);
                } else {
                    dpArray[j] = Math.max(dpArray[j], 1);
                }
                i++;
                if(i==j) {
                    i=0;
                    j++;
                }
            }
            System.out.println(Arrays.stream(dpArray).max().getAsInt());
        }
    }
}
