package scaler.dp3;

import java.util.ArrayList;
import java.util.List;

public class ZeroOneKnapsack {

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int[][] dp = new int[A.size()][C + 1];
        dp[0][0] = 0;
        for(int i = 0; i <= C; i++) {
            if(B.get(0) <= i) dp[0][i] = A.get(0);
        }
        for(int i = 1; i < A.size(); i++) {
            for (int j = 0; j <= C; j++) {
                if (j >= B.get(i)) dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - B.get(i)] + A.get(i));
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[A.size() -1][C];
    }

    public static void main(String[] args) {
        ZeroOneKnapsack zero = new ZeroOneKnapsack();
        ArrayList<Integer> A = new ArrayList<>(List.of(60, 100, 120));
        ArrayList<Integer> B = new ArrayList<>(List.of(10, 20, 30));
        System.out.println(zero.solve(A, B, 50));
    }

}
