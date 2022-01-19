package _4_adobe;
import java.util.*;

public class _12_LeadersInAnArray {
	
	public static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            if(arr[i]>=max){
                max = arr[i];
                list.add(max);
            }
        }
        n = list.size();
        for(int i=0;i<list.size()/2;i++){
            int temp = list.get(i);
            list.set(i,list.get(n-i-1));
            list.set(n-i-1,temp);
        }
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int arr[] = {16,17,4,3,5,2};
		System.out.println(leaders(arr, n));
	}

}
