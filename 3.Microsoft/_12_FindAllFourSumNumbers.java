package _3_microsoft;
import java.util.*;

public class _12_FindAllFourSumNumbers {
	
	public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<n-3;i++){
            if(i>0 && arr[i]==arr[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && arr[j]==arr[j-1]) continue;
                int l=j+1,r=n-1;
                int rem = k-arr[i]-arr[j];
                while(l<r){
                    while(l>j+1 && l<r && arr[l]==arr[l-1]) l++;
                    while(r<n-1 && l<r && arr[r]==arr[r+1]) r--;
                    if(l>=r) break;
                    if(arr[l]+arr[r]==rem){
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[l]);
                        temp.add(arr[r]);
                        list.add(temp);
                        l++;
                        r--;
                    }else if(arr[l]+arr[r]<rem) l++;
                    else r--;
                }
            }
        }
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 23;
		int arr[] = {10,2,3,4,5,7,8};
		for(ArrayList<Integer> list: fourSum(arr, k)) System.out.println(list);
	}

}
