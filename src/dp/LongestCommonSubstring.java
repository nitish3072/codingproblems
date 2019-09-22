package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://practice.geeksforgeeks.org/problems/longest-common-substring/0
 */
public class LongestCommonSubstring {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.valueOf(reader.readLine());
        while (testCases-- > 0) {
            String[] lenStr = reader.readLine().split(" ");
            int len1 = Integer.valueOf(lenStr[0]);
            int len2 = Integer.valueOf(lenStr[1]);
            String[] string1 = reader.readLine().split("");
            String[] string2 = reader.readLine().split("");


            // DP Array calculation
            int[][] dpArray = new int[len1][len2];

            // First row and first column to be filled with 1 if first element of both strings are equal
            // dpArray preparation
            int max = 0;
            for(int i=0;i<len1;i++) {
                if(string1[i].equals(string2[0])) {
                    dpArray[i][0] = 1;
                    max = 1;
                }
            }
            for(int i=0;i<len2;i++) {
                if(string1[0].equals(string2[i])) {
                    dpArray[0][i] = 1;
                    max = 1;
                }
            }

            // Now check if i element and j element of strings respectively are equal.
            //          - If they are equal then add dpArray element of i-1 and j-1 with 1
            //          - If they are not equal then dpArray dp array of i,j is zero
            for(int i=1;i<len1;i++) {
                for(int j=1;j<len2;j++) {
                    if(string1[i].equals(string2[j])) {
                        dpArray[i][j] = dpArray[i-1][j-1]+1;
                        max = Math.max(max,dpArray[i][j]);
                    } else {
                        dpArray[i][j]=0;
                    }
                }
            }
            System.out.println(max);
        }

    }

}
