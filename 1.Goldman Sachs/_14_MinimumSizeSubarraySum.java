package goldman_sachs;

public class _14_MinimumSizeSubarraySum {
	
	public static int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while(j<nums.length){
            sum += nums[j];
            while(sum>=target){
                sum -= nums[i];
                ans = Math.min(ans,j-i+1);
                i++;
            }
            j++;
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }

	public static void main(String[] args) {
		int target = 7;
		int nums[] = {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(target, nums));
	}

}
