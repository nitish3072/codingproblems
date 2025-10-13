package scaler.dp3;

import java.util.ArrayList;
import java.util.List;

public class TusharBirthdayParty {

    public int solve(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int maxA = 0;
        for (int i = 0; i < A.size(); i++) {
            maxA = Math.max(maxA, A.get(i));
        }
        int[] dp = new int[maxA + 1];
        dp[0] = 0;
        for (int i = 1; i <= maxA; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < C.size(); j++) {
                if (i >= B.get(j)) {
                    dp[i] = Math.min(dp[i], C.get(j) + dp[i - B.get(j)]);
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < A.size(); i++) {
            sum += dp[A.get(i)];
        }
        return sum;
    }

    public static void main(String[] args) {
        TusharBirthdayParty birthdayParty = new TusharBirthdayParty();
        ArrayList<Integer> A = new ArrayList<>(List.of(2, 4, 6));
        ArrayList<Integer> B = new ArrayList<>(List.of(2, 1, 3));
        ArrayList<Integer> C = new ArrayList<>(List.of(2, 5, 3));
        System.out.println(birthdayParty.solve(A, B, C));
    }
}
