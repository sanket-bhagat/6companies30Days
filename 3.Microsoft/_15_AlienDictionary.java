package _3_microsoft;
import java.util.*;

public class _15_AlienDictionary {
	
	public static void dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean visited[], Stack<Integer> st){
        visited[s] = true;
        for(int i: adj.get(s)){
            if(!visited[i]) dfs(adj,i,visited,st);
        }
        st.push(s);
    }
    
    public static String findOrder(String [] dict, int n, int k){
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<k;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            for(int j=0;j<Math.min(s1.length(),s2.length());j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    if(s1.charAt(j)>s2.charAt(j)){
                        adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    }else{
                        adj.get(s2.charAt(j)-'a').add(s1.charAt(j)-'a');
                    }
                }
            }
        }
        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[k];
        for(int j=0;j<k;j++){
            if(!visited[j]) dfs(adj,j,visited,st);
        }
        StringBuilder sb = new StringBuilder("");
        while(!st.isEmpty()){
            sb.append((char)(st.pop()+'a'));
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dict[] = {"baa","abcd","abca","cab","cad"};
		int n=5,k=4;
		System.out.println(findOrder(dict, n, k));
	}

}
