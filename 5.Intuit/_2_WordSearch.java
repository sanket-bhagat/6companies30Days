package _5_intuit;

public class _2_WordSearch {
	
	public static boolean dfs(char board[][], String s,int i, int j, int idx,boolean visited[][]){
        if(idx==s.length()) return true;
        int n = board.length;
        int m = board[0].length;
        if(i<0 || i>=n || j<0 || j>=m || board[i][j]!=s.charAt(idx) || visited[i][j]) return false;
        visited[i][j] = true;
        boolean ans = dfs(board,s,i-1,j,idx+1,visited) ||
                      dfs(board,s,i,j+1,idx+1,visited) ||
                      dfs(board,s,i+1,j,idx+1,visited) ||
                      dfs(board,s,i,j-1,idx+1,visited);
        visited[i][j] = false;
        return ans;
    }
    
    public static boolean isWordExist(char[][] board, String word){
        // Code here
        int n = board.length;
        int m = board[0].length;
        boolean visited[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0) && dfs(board,word,i,j,0,visited)) return true;
            }
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char board[][] = {{'a','g','b','c'},
						 {'q','e','e','l'},
						 {'g','b','k','s'}};
		String word = "geeks";
		System.out.println(isWordExist(board, word));
	}

}
