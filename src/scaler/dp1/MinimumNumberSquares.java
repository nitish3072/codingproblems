package scaler.dp1;

public class MinimumNumberSquares {

    public int countMinSquares(int A) {
        int[] dp = new int[A+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 1; i <= A; i++) {
            int min = i;
            for (int x = 1; x * x <= i; x++) {
                min = Math.min(min, 1 + dp[i - x * x]);
            }
            dp[i] = min;
        }
        return dp[A];
    }

    public static void main(String[] args) {
        MinimumNumberSquares s = new MinimumNumberSquares();
        System.out.println(s.countMinSquares(12));
    }

}
