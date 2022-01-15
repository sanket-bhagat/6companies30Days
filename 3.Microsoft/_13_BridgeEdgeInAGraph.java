package _3_microsoft;
import java.util.*;

public class _13_BridgeEdgeInAGraph {
	
	public static void dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean visited[]){
        visited[s] = true;
        for(int i: adj.get(s)){
            if(!visited[i]) dfs(adj,i,visited);
        }
    }
    
    //Function to find if the given edge is a bridge in graph.
	public static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d){
        // code here
        for(int i=0;i<adj.size();i++) {
        	if(adj.get(c).get(i)==d) {
        		adj.get(c).remove(i);
        		break;
        	}
        }
        for(int i=0;i<adj.size();i++) {
        	if(adj.get(d).get(i)==c) {
        		adj.get(d).remove(i);
        		break;
        	}
        }
        int n = adj.size();
        boolean visited[] = new boolean[n];
        dfs(adj,c,visited);
        return visited[d]?0:1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int e = 5,v=3;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i=0;i<e;i++) adj.add(new ArrayList<>());
		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(1).add(2);
		adj.get(2).add(1);
		adj.get(2).add(3);
		adj.get(3).add(2);
		
		int c=1,d=2;
		System.out.println(isBridge(v, adj, c, d));
	}

}
