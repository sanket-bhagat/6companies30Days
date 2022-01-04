package goldman_sachs;
import java.util.*;

public class _10_Max10Numbers {

	public static void main(String[] args) {
		int arr[] = {23,11,34,5,34,24,57,85,4,53,47,38,95,47,63,59,04,14,55,77,35,75};
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<arr.length;i++) {
			pq.offer(arr[i]);
			if(pq.size()>10) pq.poll();
		}
		while(!pq.isEmpty()) System.out.print(pq.poll()+" ");
		System.out.println();
	}

}
