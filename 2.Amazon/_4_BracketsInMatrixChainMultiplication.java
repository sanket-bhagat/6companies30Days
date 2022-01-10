package amazon;
import java.util.*;

public class _4_BracketsInMatrixChainMultiplication {
	
	public static String str = "";
    public static char ch = 'A';
    
    public static void printParanthesis(int i, int j, int bracket[][]){
        if(i==j){
            str += ch++;
            return;
        }
        str += "(";
        printParanthesis(i,bracket[i][j],bracket);
        printParanthesis(bracket[i][j]+1,j,bracket);
        str += ")";
    }
    
    public static int solve(int arr[], int i, int j, int dp[][], int bracket[][]){
        if(i>=j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int left = dp[i][k]!=-1?dp[i][k]:solve(arr,i,k,dp,bracket);
            int right = dp[k+1][j]!=-1?dp[k+1][j]:solve(arr,k+1,j,dp,bracket);
            int temp = left+right+arr[i-1]*arr[k]*arr[j];
            if(temp<ans){
                ans = temp;
                bracket[i][j] = k;
            }
        }
        return dp[i][j] = ans;
    }
    
    public static String matrixChainOrder(int p[], int n){
        // code here
        str = "";
        ch = 'A';
        int dp[][] = new int[n+1][n+1];
        for(int ar[]: dp) Arrays.fill(ar,-1);
        int bracket[][] = new int[n+1][n+1];
        for(int ar[]: bracket) Arrays.fill(ar,-1);
        solve(p,1,n-1,dp,bracket);
        printParanthesis(1,n-1,bracket);
        return str;
    }

	public static void main(String[] args) {

		int n = 5;
		int arr[] = {1,2,3,4,5};
		System.out.println(matrixChainOrder(arr, n));
	}

}
