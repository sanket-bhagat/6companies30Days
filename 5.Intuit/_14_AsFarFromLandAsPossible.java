package _5_intuit;
import java.util.*;

public class _14_AsFarFromLandAsPossible {
	
	static class Pair{
        int i,j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    
    static int directions[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    
    static void add(int arr[][], int i, int j, Queue<Pair> q){
        int n = arr.length;
        if(i<0 || i>=n || j<0 || j>=n || arr[i][j]==1) return;
        arr[i][j] = 1;
        q.offer(new Pair(i,j));
    }
    
    public static int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) q.offer(new Pair(i,j));
            }
        }
        if(q.size()==n*n) return -1;
        int ans = 0;
        while(!q.isEmpty()){
            int len = q.size();
            ans++;
            for(int i=0;i<len;i++){
                Pair curr = q.poll();
                for(int dir[]: directions) add(grid,curr.i+dir[0],curr.j+dir[1],q);
            }
        }
        return ans-1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {{1,0,1},
						{0,0,0},
						{1,0,1}};
		
		System.out.println(maxDistance(grid));
	}

}
