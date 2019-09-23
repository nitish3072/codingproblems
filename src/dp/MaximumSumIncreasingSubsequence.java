package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.valueOf(reader.readLine());
        while (testCases-- > 0) {
            int size = Integer.valueOf(reader.readLine());
            String[] str = reader.readLine().split(" ");
            int[] array = new int[size];
            for(int i =0;i<size;i++) {
                array[i] = Integer.valueOf(str[i]);
            }



            // dpArray logic starts with I and J index
            // build dpArray such that
            //      1) elements I whjich are smaller than element at J
            //      2) Have the max sum as computed in dpArray
            // Once the maxSum is found now we add the number itself to this sum and get final dpArray element for j element.
            // Reswitch at I==J-1
            int[] dpArray = new int[size];
            dpArray[0]=array[0];
            int i=0,j=1;
            int maxSum = 0;
            while (j<size) {
                if(array[i]<array[j]) {
                    maxSum = Math.max(maxSum, dpArray[i]);
                }
                if(i==j-1) {
                    dpArray[j] = maxSum+array[j];
                    maxSum = 0;
                    i=0;
                    j++;
                } else i++;
            }
            System.out.println(Arrays.stream(dpArray).max().getAsInt());
        }
    }
}
