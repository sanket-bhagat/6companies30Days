package goldman_sachs;

public class _11_FindMissingAndRepeating {
	
	static int[] findTwoElement(int arr[], int n) {
        // code here
        int xor = arr[0];
        long sum = arr[0];
        long tsum = ((long)n*(n+1))/2;
        for(int i=1;i<n;i++){
            xor ^= arr[i];
            sum += arr[i];
        }
        for(int i=1;i<=n;i++) xor ^= i;
        int setBit = xor & ~(xor-1);
        int x=0,y=0;
        for(int i=0;i<n;i++){
            if((arr[i]&setBit)!=0) x ^= arr[i];
            else y ^= arr[i];
        }
        for(int i=1;i<=n;i++){
            if((i&setBit)!=0) x ^= i;
            else y ^= i;
        }
        if(y<x){
            int temp = x;
             x = y;
             y = temp;
        }
        int ans[] = new int[2];
        if(sum>tsum){
            ans[0] = y;
            ans[1] = x;
        }else{
            ans[0] = x;
            ans[1] = y;
        }
        return ans;
    }

	public static void main(String[] args) {
		int arr[] = {1,3,3};
		int ans[] = findTwoElement(arr,3);
		System.out.println(ans[0]+" "+ans[1]);
	}

}
