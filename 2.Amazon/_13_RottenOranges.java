package amazon;
import java.util.*;

public class _13_RottenOranges {
	
	public static class Pair{
        int i,j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    
    public static void add(int grid[][], int i, int j, Queue<Pair> q){
        if(i>=0 && i<grid.length && j>=0 && j<grid[0].length){
            if(grid[i][j]==1){
                q.offer(new Pair(i,j));
                grid[i][j] = 2;
            }
        }
    }
    
    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2) q.offer(new Pair(i,j));
                else if(grid[i][j]==1) fresh++;
            }
        }
        if(fresh==0) return 0;
        else if(fresh>0 && q.size()==0) return -1;
        int time = 0;
        while(!q.isEmpty()){
            int len = q.size();
            time++;
            for(int i=0;i<len;i++){
                Pair curr = q.poll();
                add(grid,curr.i-1,curr.j,q);
                add(grid,curr.i,curr.j+1,q);
                add(grid,curr.i+1,curr.j,q);
                add(grid,curr.i,curr.j-1,q);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return time-1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {{2,1,1},
						{1,1,0},
						{0,1,1}};
		System.out.println(orangesRotting(grid));
	}

}
