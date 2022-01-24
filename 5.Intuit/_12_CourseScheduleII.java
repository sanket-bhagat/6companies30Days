package _5_intuit;
import java.util.*;

public class _12_CourseScheduleII {
	
	public static boolean isCycle(ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> topo) {
		int v = adj.size();
		int in[] = new int[v];
		for(int i=0;i<v;i++) {
			for(int j:adj.get(i)) in[j]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<v;i++) if(in[i]==0) q.offer((i));
		while(!q.isEmpty()) {
			int curr = q.poll();
			topo.add(curr);
			for(int i: adj.get(curr)) {
				in[i]--;
				if(in[i]==0) q.offer(i);
			}
		}
		return topo.size()!=v;
	}
    
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        for(int ar[]: prerequisites) adj.get(ar[1]).add(ar[0]);
        
        ArrayList<Integer> topo = new ArrayList<>();
        if(isCycle(adj,topo)) return new int[0];
        int ans[] = new int[topo.size()];
        for(int i=0;i<topo.size();i++) ans[i] = topo.get(i);
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCourses = 4;
		int prerequisites[][] = {{1,0},
								 {2,0},
								 {3,1},
								 {3,2}};
		int ans[] = findOrder(numCourses, prerequisites);
		for( int i: ans) System.out.print(i+" ");
	}

}
