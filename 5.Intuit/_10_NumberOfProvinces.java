package _5_intuit;

public class _10_NumberOfProvinces {
	
	static void dfs(int arr[][], int i, int j, boolean visited[][]){
        int n = arr.length;
        visited[i][j] = true;
        for(int nj=0;nj<n;nj++){
            if(!visited[j][nj] && arr[j][nj]==1) dfs(arr,j,nj,visited);
        }
    }
    
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean visited[][] = new boolean[n][n];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && isConnected[i][j]==1){
                    dfs(isConnected, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int isConnected[][] = {{1,1,0},
							   {1,1,0},
							   {0,0,1}};
		System.out.println(findCircleNum(isConnected));
	}

}
