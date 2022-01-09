package amazon;
import java.util.*;

public class _6_MaximumOfAllSubarraysOfSizeK {
	
	static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k){
        // Your code here
        Deque<Integer> dq = new LinkedList<>();
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i]) dq.removeLast();
            dq.addLast(i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=k;i<n;i++){
            list.add(arr[dq.peekFirst()]);
            while(!dq.isEmpty() && dq.peekFirst()<=i-k) dq.removeFirst();
            while(!dq.isEmpty() && arr[dq.peekLast()]<arr[i]) dq.removeLast();
            dq.addLast(i);
        }
        list.add(arr[dq.peekFirst()]);
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 9;
		int k = 3;
		int arr[] = {1,2,3,1,4,5,2,3,6};
		System.out.println(max_of_subarrays(arr, n, k));
	}

}
