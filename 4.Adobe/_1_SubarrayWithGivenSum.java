package _4_adobe;
import java.util.*;

public class _1_SubarrayWithGivenSum {
	
	public static ArrayList<Integer> subarraySum(int[] arr, int n, int s){
        // Your code here
        int i=0,j=0,sum=0;
        while(i<=n){
            while(j<n && sum>s) sum-=arr[j++];
            if(sum==s){
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(j+1);
                ans.add(i);
                return ans;
            }
            if(i<n) sum+=arr[i++];
            else break;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(-1);
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5, s = 12;
		int arr[] = {1,2,3,7,5};
		System.out.println(subarraySum(arr, n, s));
	}

}
