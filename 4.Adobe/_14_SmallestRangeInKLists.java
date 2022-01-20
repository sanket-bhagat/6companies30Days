package _4_adobe;
import java.util.*;

public class _14_SmallestRangeInKLists {
	
	public static class Triplet implements Comparable<Triplet>{
        int val,i,j;
        Triplet(int val, int i, int j){
            this.val = val;
            this.i = i;
            this.j = j;
        }
        public int compareTo(Triplet t){
            return this.val-t.val;
        }
    }
    
	public static int[] findSmallestRange(int[][] arr,int n,int k){
	    //add your code here
	    PriorityQueue<Triplet> pq = new PriorityQueue<>();
	    int fmin = Integer.MAX_VALUE;
	    int fmax = Integer.MIN_VALUE;
	    for(int i=0;i<k;i++){
	        pq.offer(new Triplet(arr[i][0],i,0));
	        fmin = Math.min(fmin,arr[i][0]);
	        fmax = Math.max(fmax,arr[i][0]);
	    }
	    int range = fmax-fmin;
	    int min=fmin,max=fmax;
	    while(pq.peek().j<n-1){
	        Triplet curr = pq.poll();
	        pq.offer(new Triplet(arr[curr.i][curr.j+1],curr.i,curr.j+1));
	        min = pq.peek().val;
	        max = Math.max(max,arr[curr.i][curr.j+1]);
	        if(max-min<range){
	            range = max-min;
	            fmin = min;
	            fmax = max;
	        }
	    }
	    int ans[] = new int[2];
	    ans[0] = fmin;
	    ans[1] = fmax;
	    return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5, k = 3;
		int arr[][] = {{1, 3, 5, 7, 9},
	                   {0, 2, 4, 6, 8},
	                   {2, 3, 5, 7, 11}};
		int ans[] = findSmallestRange(arr, n, k);
		System.out.println(ans[0]+" "+ans[1]);
	}

}
