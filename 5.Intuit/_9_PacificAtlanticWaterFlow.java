package _5_intuit;
import java.util.*;

public class _9_PacificAtlanticWaterFlow {
	
static int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    
    static void dfs(int arr[][], int i, int j, int prev, boolean ocean[][]){
        int n = arr.length;
        int m = arr[0].length;
        if(i<0 || i>=n || j<0 || j>=m || arr[i][j]<prev || ocean[i][j]) return;
        ocean[i][j] = true;
        for(int d[]: dir) dfs(arr,i+d[0],j+d[1],arr[i][j],ocean);
    }
    
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean pac[][] = new boolean[n][m];
        boolean atl[][] = new boolean[n][m];
        for(int i=0;i<m;i++){
            dfs(heights,0,i,0,pac);
            dfs(heights,n-1,i,0,atl);
        }
        for(int i=0;i<n;i++){
            dfs(heights,i,0,0,pac);
            dfs(heights,i,m-1,0,atl);
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(atl[i][j] && pac[i][j]) list.add(Arrays.asList(i,j));
            }
        }
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int heights[][] = {{1,2,2,3,5},
						   {3,2,3,4,4},
						   {2,4,5,3,1},
						   {6,7,1,4,5},
						   {5,1,1,2,4}};
		System.out.println(pacificAtlantic(heights));
	}

}
