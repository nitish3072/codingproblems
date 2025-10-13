package scaler.dp3;

import java.util.ArrayList;
import java.util.List;

public class UnboundedKnapsack {

    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int[] dp = new int[A + 1];
        dp[0] = 0;
        for(int i = 1; i <= A; i++) {
            dp[i] = 0;
            for(int j = 0; j < B.size(); j++) {
                if(i >= C.get(j)) {
                    dp[i] = Math.max(dp[i], B.get(j) + dp[i - C.get(j)]);
                }
            }
        }
        return dp[A];
    }

    public static void main(String[] args) {
        UnboundedKnapsack s = new UnboundedKnapsack();
        ArrayList<Integer> A = new ArrayList<>(List.of(6,7,8,5,6));
        ArrayList<Integer> B = new ArrayList<>(List.of(5,5,4,6,3));
        System.out.println(s.solve(10, A, B));
    }

}
