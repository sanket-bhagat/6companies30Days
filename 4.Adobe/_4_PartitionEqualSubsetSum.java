package _4_adobe;

public class _4_PartitionEqualSubsetSum {
	
	public static int equalPartition(int n, int arr[]){
        // code here
        int sum = 0;
        for(int i: arr) sum+=i;
        if(sum%2!=0) return 0;
        sum/=2;
        int dp[][] = new int[n+1][sum+1];
        for(int i=0;i<=n;i++) dp[i][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = (dp[i-1][j-arr[i-1]]==1 || dp[i-1][j]==1)?1:0;
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int arr[] = {1,5,11,5};
		System.out.println(equalPartition(n, arr));
	}

}
