package _6_walmart;

public class _9_GuessNumberHigherOrLowerII {

	static int getMoneyAmount(int n) {
        int dp[][] = new int[n + 1][n + 1];
        for (int c = 1; c <= n; c++) {
            for (int i = 1, j = c + 1; i <= n && j <= n; j++, i++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(i >= k - 1 ? 0 : dp[i][k - 1], k + 1 >= j ? 0 : dp[k + 1][j]) + k);
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(getMoneyAmount(n));
    }

}
