package _6_walmart;
import java.util.*;

public class _4_NumberOfUniquePaths {
	
	static int solve(int i, int j, int a, int b, Map<String,Integer> dp){
        if(i<0 || i>=a || j<0 || j>=b) return 0;
        if(i==a-1 && j==b-1) return 1;
        if(dp.containsKey(i+" "+j)) return dp.get(i+" "+j);
        int ans = solve(i,j+1,a,b,dp) + solve(i+1,j,a,b,dp);
        dp.put(i+" "+j,ans);
        return ans;
    }
    
    public static int NumberOfPath(int a, int b) {
        //Your code here
        Map<String,Integer> dp = new HashMap<>();
        return solve(0,0,a,b,dp);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=3,b=4;
		System.out.println(NumberOfPath(a, b));
	}

}
