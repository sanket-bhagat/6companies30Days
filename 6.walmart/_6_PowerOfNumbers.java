package _6_walmart;

public class _6_PowerOfNumbers {
	
	static int mod = (int)1e9+7;
    
    static long power(int n,int r){
        //Your code here
        if(r==1) return n;
        long ans = power(n,r/2);
        if(r%2==0) return (ans*ans)%mod;
        return (((ans*ans)%mod)*n)%mod;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(power(12, 21));
	}

}
