package dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://practice.geeksforgeeks.org/problems/longest-common-subsequence/0
 * https://1drv.ms/u/s!AsdF3i1OvApTvGDZOZtjgwh71BPT
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.valueOf(reader.readLine());
        while (testCases-- > 0) {
            String[] lenStr = reader.readLine().split(" ");
            int len1 = Integer.valueOf(lenStr[0]);
            int len2 = Integer.valueOf(lenStr[1]);
            String[] string1 = reader.readLine().split("");
            String[] string2 = reader.readLine().split("");


            //dpArray compute
            // Take dp array to be one size larger on both sides from original len1 and len2
            // Now for strings at i and j are equal that means we increase the diagonally opposite element from dpArray and increase it by one
            // If not equal then we take max of upper element and left side element from dpArray
            int[][] dpArray = new int[len1+1][len2+1];
            for(int i=1;i<=len1;i++) {
                for(int j=1;j<=len2;j++) {
                    if(string1[i-1].equals(string2[j-1])) {
                        dpArray[i][j]=dpArray[i-1][j-1]+1;
                    } else {
                        dpArray[i][j]=Math.max(dpArray[i-1][j], dpArray[i][j-1]);
                    }
                }
            }
            System.out.println(dpArray[len1][len2]);
        }
    }

}
