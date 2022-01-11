package _3_microsoft;
import java.util.*;

public class _2_PrerequisiteTasks {
	
	public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean visited[], boolean vstack[]){
        visited[s] = true;
        vstack[s] = true;
        for(int i: adj.get(s)){
            if(!visited[i]){
                if(dfs(adj,i,visited,vstack)) return true;
            }else if(vstack[i]) return true;
        }
        vstack[s] = false;
        return false;
    }
    
    public static boolean isPossible(int n, int[][] pre)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<pre.length;i++) adj.get(pre[i][0]).add(pre[i][1]);
        
        boolean visited[] = new boolean[n];
        boolean vstack[] = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visited[i] && dfs(adj, i, visited,vstack)) return false;
        }
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4;
		int arr[][] = {{1,0},{2,1},{3,2}};
			System.out.println(isPossible(n, arr));
	}

}
