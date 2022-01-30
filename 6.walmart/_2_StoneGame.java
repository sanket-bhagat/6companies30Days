package _6_walmart;
import java.util.*;

public class _2_StoneGame {
	
	static int solve(int arr[], int l, int r,Map<String,Integer> dp){
        if(l>r) return 0;
        if(l==r) return arr[l];
        if(dp.containsKey(l+" "+r)) return dp.get(l+" "+r);
        int ans1 = arr[l]+Math.min(solve(arr,l+1,r-1,dp),solve(arr,l+1,r,dp));
        int ans2 = arr[r]+Math.min(solve(arr,l,r-2,dp),solve(arr,l+1,r-1,dp));
        int ans = Math.max(ans1,ans2);
        dp.put(l+" "+r,ans);
        return ans;
    }
    
    public static boolean stoneGame(int[] piles) {
        int total = 0;
        for(int i: piles) total += i;
        Map<String,Integer> dp = new HashMap<>();
        int alice = solve(piles,0,piles.length-1,dp);
        int bob = total - alice;
        return alice>bob;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int piles[] = {5,3,4,5};
		System.out.println(stoneGame(piles));
	}

}
