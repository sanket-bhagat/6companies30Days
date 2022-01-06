package amazon;

public class _1_MaximumProfit {
	
	static int maxProfit(int k, int n, int arr[]) {
        // code here
        int dp[][] = new int[k+1][n];
        for(int i=1;i<=k;i++){
            int max = Integer.MIN_VALUE;
            for(int j=1;j<n;j++){
                max = Math.max(dp[i-1][j-1]-arr[j-1],max);
                dp[i][j] = Math.max(dp[i][j-1],max+arr[j]);
            }
        }
        return dp[k][n-1];
    }

	public static void main(String[] args) {

		int k = 2;
		int n = 6;
		int arr[] = {10, 22, 5, 75, 65, 80};
		System.out.println(maxProfit(k,n,arr));
	}

}
