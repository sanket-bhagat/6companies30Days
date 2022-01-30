package _6_walmart;
import java.util.*;

public class _13_FindTheKthLargestIntegerInTheArray {
	
	static class Num implements Comparable<Num>{
        String s;
        Num(String s){
            this.s = s;
        }
        public int compareTo(Num n){
            if(this.s.length()==n.s.length()) return this.s.compareTo(n.s);
            return this.s.length()-n.s.length();
        }
    }
    
    public static String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<Num> pq = new PriorityQueue<>();
        for(String s: nums){
            pq.offer(new Num(s));
            if(pq.size()>k) pq.poll();
        }
        return pq.poll().s;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nums[] = {"2","21","12","1"};
		int k = 3;
		System.out.println(kthLargestNumber(nums, k));
	}

}
