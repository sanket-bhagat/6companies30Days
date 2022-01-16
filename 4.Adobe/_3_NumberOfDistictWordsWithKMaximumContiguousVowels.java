package _4_adobe;

public class _3_NumberOfDistictWordsWithKMaximumContiguousVowels {
	
private static int mod = 1000000007;
    
    private static int pow(int n, int k){
        long ans = 1;
        for(int i=0;i<k;i++){
            ans*=n;
            ans%=mod;
        }
        return (int)ans;
    }
    
    public static int kvowelwords(int n,int k){
        // code here
        long sum = 1;
        long dp[][] = new long[n+1][k+1];
        for(int i=1;i<=n;i++){
            sum*=21;
            sum%=mod;
            dp[i][0] = sum;
            for(int j=1;j<=k;j++){
                if(j>i) dp[i][j] = 0;
                else if(i==j) dp[i][j] = pow(5,i);
                else dp[i][j] = dp[i-1][j-1]*5;
                sum+=dp[i][j];
                sum%=mod;
                dp[i][j]%=mod;
            }
        }
        return (int)sum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=1,k=1;
		System.out.println(kvowelwords(n, k));
	}

}
