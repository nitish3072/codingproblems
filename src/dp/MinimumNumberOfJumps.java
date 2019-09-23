package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps/0
 * https://1drv.ms/u/s!AsdF3i1OvApTvF_1rqiHADJhWk-D
 */
public class MinimumNumberOfJumps {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.valueOf(reader.readLine());
        while (testCases-- > 0) {
            int size = Integer.valueOf(reader.readLine());
            String[] str = reader.readLine().split(" ");
            // Number Array from 1-n
            int[] numbers = new int[size];
            for (int i = 0; i < size; i++) {
                numbers[i] = Integer.valueOf(str[i]);
            }

            //dpArray construct
            int[][] dpArray = new int[size][size];
            int[] minArray = new int[size];
            for(int i =0;i<size;i++) {
                dpArray[i][i] = minArray[i];
                for(int j=i+1;j<=Math.min(i+numbers[i], size-1);j++) {
                    dpArray[i][j] = dpArray[i][i]+1;
                    minArray[j] = minArray[j]==0 ? dpArray[i][j] : Math.min(minArray[j], dpArray[i][j]);
                }
            }
            boolean printNegative = false;
            for(int i=1;i<size;i++) {
                if(dpArray[i][i]==0) {
                    printNegative=true;
                }
            }
            System.out.println(printNegative?"-1":dpArray[size-1][size-1]);
        }
    }
}
