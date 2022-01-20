package _4_adobe;
import java.util.*;

public class _13_MinimumOperationsToConvertArrayAtoB {
	
	public static int lis(int arr[]) {
	       if (arr.length == 0) return 0;
	       int[] tail = new int[arr.length];
	       int len = 1;
	       tail[0] = arr[0];
	       
	       for (int i = 1; i < arr.length; i++) {
	           if (arr[i] > tail[len - 1]) {
	               tail[len++] = arr[i];
	           } else {
	               int id = Arrays.binarySearch(tail, 0, len-1, arr[i]);
	               if (id < 0) {
	                   id = -1*id - 1;
	               }
	               tail[id] = arr[i];
	           }
	       }
	       return len;
	    }
	    
	    static int minInsAndDel(int[] a, int[] b, int n, int m) {
	        // code here
	        Set<Integer> set = new HashSet<>();
	        for(int i: b) set.add(i);
	        ArrayList<Integer> list = new ArrayList<>();
	        for(int i: a) if(set.contains(i)) list.add(i);
	        int arr[] = new int[list.size()];
	        for(int i=0;i<list.size();i++) arr[i] = list.get(i);
	        int l = lis(arr);
	        return n+m-2*l;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5, m = 3;
		int a[] = {1, 2, 5, 3, 1};
		int b[] = {1, 3, 5};
		System.out.println(minInsAndDel(a, b, n, m));
	}

}
