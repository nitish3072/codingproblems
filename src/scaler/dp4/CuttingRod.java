package scaler.dp4;

import java.util.ArrayList;
import java.util.List;

public class CuttingRod {

    public int solve(ArrayList<Integer> A) {
        int[] dp = new int[A.size() + 1];
        dp[0] = 0;
        for (int i = 1; i <= A.size(); i++) {
            dp[i] = 0;
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], A.get(j - 1) + dp[i - j]);
            }
        }
        return dp[A.size()];
    }

    public static void main(String[] args) {
        CuttingRod rod = new CuttingRod();
        ArrayList<Integer> A = new ArrayList<>(List.of(3, 4, 1, 6, 2));
        System.out.println(rod.solve(A));
    }
}
