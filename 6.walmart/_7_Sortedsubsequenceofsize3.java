package _6_walmart;
import java.util.*;

public class _7_Sortedsubsequenceofsize3 {
	
	static ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
        // add code here.
        int next[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr.get(st.peek())<=arr.get(i)) st.pop();
            next[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(next[i]<n && next[next[i]]<n){
                list.add(arr.get(i));
                list.add(arr.get(next[i]));
                list.add(arr.get(next[next[i]]));
                return list;
            }
        }
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int arr[] = {1,2,1,1,3};
		ArrayList<Integer> list = new ArrayList<>();
		for(int i: arr) list.add(i);
		System.out.println(find3Numbers(list, n));
	}

}
