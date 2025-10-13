package scaler.dp1;

import java.util.ArrayList;
import java.util.List;

public class MaximumSumValue {

    public int solve(ArrayList<Integer> A, int B, int C, int D) {
        int[][] dp = new int[A.size()][3];
        dp[0][0] = B * A.get(0);
        for (int i = 1; i < A.size(); i++) {
            dp[i][0] = Math.max(dp[i - 1][0], B * A.get(i));
        }
        dp[0][1] = dp[0][0] + C * A.get(0);
        for (int i = 1; i < A.size(); i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] + C * A.get(i));
        }
        dp[0][2] = dp[0][1] + D * A.get(0);
        for (int i = 1; i < A.size(); i++) {
            dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] + D * A.get(i));
        }
        return dp[A.size() - 1][2];
    }

    public static void main(String[] args) {
        MaximumSumValue ms = new MaximumSumValue();
        System.out.println(ms.solve(new ArrayList<>(List.of(1, 5, -3, 4, -2)), 2,1,-1));
    }
}
