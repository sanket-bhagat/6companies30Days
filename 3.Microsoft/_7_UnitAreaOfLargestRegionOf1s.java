package _3_microsoft;

public class _7_UnitAreaOfLargestRegionOf1s {
	
	public static int dfs(int grid[][], int i, int j, boolean visited[][]){
        int n = grid.length;
        int m = grid[0].length;
        if(i<0 || i>=n || j<0 || j>=m || visited[i][j] || grid[i][j]==0) return 0;
        visited[i][j] = true;
        return 1+dfs(grid,i-1,j,visited)
                +dfs(grid,i-1,j+1,visited)
                +dfs(grid,i,j+1,visited)
                +dfs(grid,i+1,j+1,visited)
                +dfs(grid,i+1,j,visited)
                +dfs(grid,i+1,j-1,visited)
                +dfs(grid,i,j-1,visited)
                +dfs(grid,i-1,j-1,visited);
    }
    
    //Function to find unit area of the largest region of 1s.
    public static int findMaxArea(int[][] grid){
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    max = Math.max(max,dfs(grid,i,j,visited));
                }
            }
        }
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {{1,1,1,0},
						{0,0,1,0},
						{0,0,0,1}};
		System.out.println(findMaxArea(grid));
	}

}
