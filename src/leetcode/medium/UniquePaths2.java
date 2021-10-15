package leetcode.medium;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] arr) {
        int[][] dp = new int[arr.length+1][arr[0].length+1];
        if(arr[0][0]==0) {
            dp[0][1]=1;
        }
        for (int i=1;i<=arr.length;i++) {
            for (int j=1;j<=arr[0].length;j++) {
                if(arr[i-1][j-1]==1){
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[arr.length][arr[0].length];
    }

    public static void main(String[] args) {
        UniquePaths2 uniquePaths = new UniquePaths2();
        int[][] path = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePaths.uniquePathsWithObstacles(path));
    }
}
