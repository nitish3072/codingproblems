package leetcode.medium;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum/
 */
public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length+1][matrix.length+1];
        int finalMinSum = 101;
        for (int i = 0; i <= matrix.length; i++) {
            for (int j = 0; j <= matrix.length; j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 101;
                }
            }
        }
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix.length; j++) {
                int minSumAbove = 0;
                if(j+1>matrix.length) {
                    minSumAbove = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                } else {
                    minSumAbove = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]));
                }
                dp[i][j] = minSumAbove + matrix[i - 1][j - 1];
                if (i == matrix.length-1) {
                    finalMinSum = Math.min(finalMinSum, dp[i][j]);
                }
            }
        }
        return finalMinSum;
    }

    public static void main(String[] args) {
        MinimumFallingPathSum minimumFallingPathSum = new MinimumFallingPathSum();
        int[][] arr = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minimumFallingPathSum.minFallingPathSum(arr));
    }

}
