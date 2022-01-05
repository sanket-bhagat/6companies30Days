package goldman_sachs;

public class _5_UglyNumbers {
	
	public static long getNthUglyNo(int n) {
        // code here
        long dp[] = new long[n];
        dp[0] = 1;
        int two=0,three=0,five=0;
        for(int i=1;i<n;i++){
            dp[i] = Math.min(2*dp[two],Math.min(3*dp[three],5*dp[five]));
            if(dp[i]==2*dp[two]) two++;
            if(dp[i]==3*dp[three]) three++;
            if(dp[i]==5*dp[five]) five++;
        }
        return dp[n-1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getNthUglyNo(10));
	}

}
