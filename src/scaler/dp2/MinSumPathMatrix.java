package scaler.dp2;

import java.util.ArrayList;
import java.util.List;

public class MinSumPathMatrix {

    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        int[][] dp = new int[A.size()][A.get(0).size()];
        dp[0][0] = A.get(0).get(0);
        for (int i = 1; i < A.size(); i++) {
            dp[i][0] = dp[i - 1][0] + A.get(i).get(0);
        }
        for (int j = 1; j < A.get(0).size(); j++) {
            dp[0][j] = dp[0][j - 1] + A.get(0).get(j);
        }
        for (int i = 1; i < A.size(); i++) {
            for (int j = 1; j < A.get(0).size(); j++) {
                dp[i][j] = A.get(i).get(j) + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[A.size() - 1][A.get(0).size() - 1];
    }

    public static void main(String[] args) {
        MinSumPathMatrix m = new MinSumPathMatrix();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(List.of(1, 3, 2)));
        A.add(new ArrayList<>(List.of(4, 3, 1)));
        A.add(new ArrayList<>(List.of(5, 6, 1)));
        System.out.println(m.minPathSum(A));
    }

}
