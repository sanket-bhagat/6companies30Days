package _5_intuit;

public class _7_CapacityToShipPackagesWithinDDays {
	
	static boolean isPossible(int arr[], int mid, int days){
        int sum = 0;
        int count = 1;
        for(int i=0;i<arr.length;i++){
            if(sum+arr[i]>mid){
                if(++count>days) return false;
                sum = arr[i];
            }else sum += arr[i];
        }
        return true;
    }
    
    public static int shipWithinDays(int[] weights, int days) {
        int l=0,r=0;
        for(int i: weights){
            r += i;
            l = Math.max(l,i);
        }
        int n = weights.length;
        if(days==n) return l;
        int ans = l;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(isPossible(weights,mid,days)){
                ans = mid;
                r = mid-1;
            }else l = mid+1;
        }
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int weights[] = {1,2,3,4,5,6,7,8,9,10};
		int days = 5;
		System.out.println(shipWithinDays(weights, days));
	}

}
