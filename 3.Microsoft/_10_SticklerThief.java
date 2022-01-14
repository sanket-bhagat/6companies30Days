package _3_microsoft;
import java.util.*;

public class _10_SticklerThief {
	
	public static int solve(int arr[], int n, int dp[]){
        if(n<=0) return 0;
        if(dp[n]!=-1) return dp[n];
        return dp[n] = Math.max(arr[n-1]+solve(arr,n-2,dp),solve(arr,n-1,dp));
    }
    
    //Function to find the maximum money the thief can get.
    public static int FindMaxSum(int arr[], int n){
        // Your code here
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(arr,n,dp);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int arr[] = {5,5,10,100,10,5};
		System.out.println(FindMaxSum(arr, n));
	}

}
