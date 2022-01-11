package _3_microsoft;

public class _1_MinimumSumPartition {
	
	public static int minDifference(int arr[], int n){ 
	    // Your code goes here
	    int sum = 0;
	    for(int i: arr) sum+=i;
	    int dp[][] = new int[n+1][sum+1];
	    for(int i=0;i<=n;i++) dp[i][0] = 1;
	    for(int i=1;i<=n;i++){
	        for(int j=1;j<=sum;j++){
	            if(arr[i-1]<=j) dp[i][j] = dp[i-1][j-arr[i-1]]==1 || dp[i-1][j]==1?1:0;
	            else dp[i][j] = dp[i-1][j];
	        }
	    }
	    int idx = 0;
	    for(int i=0;i<=sum/2;i++) if(dp[n][i]==1) idx = i;
	    return sum-2*idx;
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int arr[] = {1, 6, 11, 5};
		System.out.println(minDifference(arr, n));
	}

}
