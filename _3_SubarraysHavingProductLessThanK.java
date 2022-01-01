package goldman_sachs;

public class _3_SubarraysHavingProductLessThanK {

	public static int countSubArrayProductLessThanK(long a[], long k){
		int n = a.length;
        if(k<=1) return 0;
        long prod = 1;
        int ans = 0;
        int l=0,r=0;
        while(r<n){
            prod = prod*a[r];
            while(prod>=k) prod/=a[l++];
            ans += r-l+1;
            r++;
        }
        return ans;
    }
	
	public static void main(String[] args) {
		long arr[] = {1, 9, 2, 8, 6, 4, 3};
		int count = countSubArrayProductLessThanK(arr,100);
		System.out.println(count);
	}

}
