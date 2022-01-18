package _4_adobe;
import java.util.*;

public class _7_PotsOfGoldGame {
	
	public static int solve(int arr[], int l, int r, int dp[][]){
        if(l>r) return 0;
        if(dp[l][r]!=-1) return dp[l][r];
        int ans1 = arr[l] + Math.min(solve(arr,l+2,r,dp),solve(arr,l+1,r-1,dp));
        int ans2 = arr[r] + Math.min(solve(arr,l+1,r-1,dp),solve(arr,l,r-2,dp));
        return dp[l][r] = Math.max(ans1,ans2);
    }
    
	public static int maxCoins(int arr[],int n){
      //add code here.
      int dp[][] = new int[n][n];
      for(int ar[]: dp) Arrays.fill(ar,-1);
      return solve(arr,0,n-1,dp);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int arr[] = {8,15,3,7};
		System.out.println(maxCoins(arr, n));
	}

}
