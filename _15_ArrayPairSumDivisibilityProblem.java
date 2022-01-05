package goldman_sachs;
import java.util.*;

public class _15_ArrayPairSumDivisibilityProblem {
	
	public static boolean canPair(int[] nums, int k) {
        // Code here
        if(nums.length%2!=0) return false;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int rem = nums[i]%k;
            if(map.containsKey((k-rem)%k) && map.get((k-rem)%k)>0){
                map.put((k-rem)%k,map.get((k-rem)%k)-1);
            }else map.put(rem,map.getOrDefault(rem,0)+1);
        }
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            if(e.getValue()>0) return false;
        }
        return true;
    }

	public static void main(String[] args) {

		int arr[] = {9,5,7,3};
		int k = 6;
		System.out.println(canPair(arr,k));
	}

}
