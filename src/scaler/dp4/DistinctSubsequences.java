package scaler.dp4;

public class DistinctSubsequences {

    public int numDistinct(String A, String B) {
        int[][] dp = new int[B.length() + 1][A.length() + 1];
        for (int j = 0; j <= A.length(); j++) dp[0][j] = 1;

        for (int i = 1; i <= B.length(); i++) {
            for (int j = 1; j <= A.length(); j++) {
                if (B.charAt(i - 1) == A.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[B.length()][A.length()];
    }

    public static void main(String[] args) {
        DistinctSubsequences ds = new DistinctSubsequences();
        System.out.println(ds.numDistinct("baabbaaabaaabaaaabbbbabaaabbbabbba", "bab"));
    }

}
