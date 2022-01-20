package _4_adobe;
import java.util.*;

public class _5_ExpressAsSumOfPowerOfNaturalNumbers {
	
	static long mod = 1000000007;
    static long[][] dp = new long[1005][1005];
    static long solve(int n,int x,int m){
        int d = n-(int)Math.pow(m,x);
        if(d < 0){
            return 0;
        }
        if(d == 0){
            return 1l;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        return dp[n][m] = (solve(d, x, m + 1) % mod + solve(n, x, m + 1) % mod) % mod;
    }
    public static int numOfWays(int n, int x){
        for(long[] r:dp){
            Arrays.fill(r,-1);
        }
        long res = solve(n, x, 1);
        return (int)(res % mod);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=100,x=2;
		System.out.println(numOfWays(n, x));
	}

}
