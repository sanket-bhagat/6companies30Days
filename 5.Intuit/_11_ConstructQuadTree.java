package _5_intuit;

public class _11_ConstructQuadTree {
	
	static class Node {
	    public boolean val;
	    public boolean isLeaf;
	    public Node topLeft;
	    public Node topRight;
	    public Node bottomLeft;
	    public Node bottomRight;

	    
	    public Node() {
	        this.val = false;
	        this.isLeaf = false;
	        this.topLeft = null;
	        this.topRight = null;
	        this.bottomLeft = null;
	        this.bottomRight = null;
	    }
	    
	    public Node(boolean val, boolean isLeaf) {
	        this.val = val;
	        this.isLeaf = isLeaf;
	        this.topLeft = null;
	        this.topRight = null;
	        this.bottomLeft = null;
	        this.bottomRight = null;
	    }
	    
	    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
	        this.val = val;
	        this.isLeaf = isLeaf;
	        this.topLeft = topLeft;
	        this.topRight = topRight;
	        this.bottomLeft = bottomLeft;
	        this.bottomRight = bottomRight;
	    }
	}
	
	static int getStatus(int arr[][], int tr, int br, int lc, int rc){
        int sum = 0;
        int count = 0;
        for(int i=tr;i<=br;i++){
            for(int j=lc;j<=rc;j++){
                sum += arr[i][j];
                count++;
            }
        }
        if(sum==0) return 0;
        if(sum==count) return 1;
        return -1;
    }
    
    static Node solve(int arr[][], int tr, int br, int lc, int rc){
        int status = getStatus(arr,tr,br,lc,rc);
        if(status==1) return new Node(true,true);
        if(status==0) return new Node(false,true);
        int half = (br-tr)/2;
        Node topleft = solve(arr,tr,tr+half,lc,lc+half);
        Node topright = solve(arr,tr,tr+half,lc+half+1,rc);
        Node bottomleft = solve(arr,tr+half+1,br,lc,lc+half);
        Node bottomright = solve(arr,tr+half+1,br,lc+half+1,rc);
        return new Node(true,false,topleft,topright,bottomleft,bottomright);
    }
    
    public static Node construct(int[][] grid) {
        int n = grid.length;
        return solve(grid,0,n-1,0,n-1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {{0,1},
						{1,0}};
		Node root = construct(grid);
	}

}
