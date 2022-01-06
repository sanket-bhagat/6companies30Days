package amazon;

public class _2_LongestMountainInArray {
	
	public static int longestMountain(int[] arr) {
        int n = arr.length;
        int ltor[] = new int [n];
        int rtol[] = new int[n];
        ltor[0] = 0;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]) ltor[i] = ltor[i-1]+1;
            else ltor[i] = 0;
        }
        rtol[n-1] = 0;
        for(int i=n-2;i>=0;i--){
            if(arr[i]>arr[i+1]) rtol[i] = rtol[i+1]+1;
            else rtol[i] = 0;
        }
        int max = 0;
        for(int i=0;i<n;i++){
            int len = ltor[i]>0&&rtol[i]>0?ltor[i]+rtol[i]+1:0;
            max = Math.max(max,len);
        }
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,1,4,7,3,2,5};
		System.out.println(longestMountain(arr));
	}

}
