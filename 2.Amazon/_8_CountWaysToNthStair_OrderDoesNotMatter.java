package amazon;

public class _8_CountWaysToNthStair_OrderDoesNotMatter {
	
	public static long countWays(int n){
        // your code here
        return (long)(n/2+1);
    }

	public static void main(String[] args) {
		System.out.println(countWays(6));
	}

}
