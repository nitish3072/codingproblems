package scaler.dp3;

public class WaysSendSignal {

    public int solve(int A) {
        int[][] dp = new int[2][A + 1];
        dp[0][1] = 1;
        dp[1][1] = 1;
        for (int i = 2; i <= A; i++) {
            dp[0][i] = (dp[0][i-1] + dp[1][i-1]) % 1000000007;
            dp[1][i] = dp[0][i-1] % 1000000007;
        }
        return (dp[1][A] + dp[0][A]) % 1000000007;
    }

    public static void main(String[] args) {
        WaysSendSignal ws = new WaysSendSignal();
        System.out.println(ws.solve(224));
    }

}
