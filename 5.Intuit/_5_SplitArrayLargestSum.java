package _5_intuit;

public class _6_SplitArrayLargestSum {
	
	public static boolean isPossible(int arr[], int mid, int m){
        int sum = 0;
        int count = 1;
        for(int i=0;i<arr.length;i++){
            if(sum+arr[i]>mid){
                if(++count>m) return false;
                sum = arr[i];
            }else sum += arr[i];
        }
        return true;
    }
    
    public static int splitArray(int[] nums, int m) {
        int l=0,r=0;
        for(int i=0;i<nums.length;i++){
            r += nums[i];
            l = Math.max(l,nums[i]);
        }
        int ans = 0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(isPossible(nums,mid,m)){
                ans = mid;
                r=mid-1;
            }else l=mid+1;
        }
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {7,2,5,10,8};
		int m = 2;
		System.out.println(splitArray(nums, m));
	}

}
