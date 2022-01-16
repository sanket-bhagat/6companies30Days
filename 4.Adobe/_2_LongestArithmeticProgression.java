package _4_adobe;
import java.util.*;

public class _2_LongestArithmeticProgression {
	
	public static int lengthOfLongestAP(int[] arr, int n) {
        // code here
        if(n<=2) return n;
        Map<Integer,Integer> dp[] = new HashMap[n];
        int max = 1;
        for(int i=0;i<n;i++){
            dp[i] = new HashMap<>();
            for(int j=0;j<i;j++){
                int diff = arr[j]-arr[i];
                dp[i].put(diff,dp[j].getOrDefault(diff,0)+1);
                max = Math.max(max,dp[i].get(diff));
            }
        }
        return max+1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int arr[] = {1, 7, 10, 13, 14, 19};
		System.out.println(lengthOfLongestAP(arr, n));
	}

}
