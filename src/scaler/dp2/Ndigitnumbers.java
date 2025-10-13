package scaler.dp2;

public class Ndigitnumbers {

    public int solve(int A, int B) {
        int[][] dp = new int[A + 1][B + 1];
        for (int i = 1; i <= 9; i++) {
            if(i<=B) {
                dp[1][i] = 1;
            }
        }
        for (int i = 2; i <= A; i++) {
            for (int j = 1; j <= B; j++) {
                for (int k = 0; k <= 9; k++) {
                    if (j >= k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % (1000000007);
                    }
                }
            }
        }
        return dp[A][B] % 1000000007;
    }

    public static void main(String[] args) {
        Ndigitnumbers  n = new Ndigitnumbers();
        System.out.println(n.solve(52,1));
    }
}
