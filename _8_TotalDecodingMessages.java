package goldman_sachs;

public class _8_TotalDecodingMessages {
	
	public static int CountWays(String s){
        // code here
        int mod = (int)(1e9+7);
        if(s.charAt(0)=='0') return 0;
        int dp[] = new int[s.length()];
        dp[0] = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)=='0' && s.charAt(i)=='0'){
                dp[i] = 0;
            }else if(s.charAt(i-1)=='0'){
                dp[i] = dp[i-1];
            }else if(s.charAt(i)=='0'){
                if(s.charAt(i-1)=='1' || s.charAt(i-1)=='2') dp[i] = i-2>=0?dp[i-2]:1;
            }else{
                dp[i] = dp[i-1];
                if(Integer.parseInt(s.substring(i-1,i+1))<=26) dp[i] += i-2>=0?dp[i-2]:1;
                dp[i]%=mod;
            }
        }
        return dp[s.length()-1];
    }

	public static void main(String[] args) {
		System.out.println(CountWays("123"));
	}

}
