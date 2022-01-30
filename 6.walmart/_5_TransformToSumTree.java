package _6_walmart;

public class _5_TransformToSumTree {
	
	static class Node{
	    int data;
	    Node left,right;
	    Node(int d){
	    	data=d;
	    	left=null;
	    	right=null;
	    }
	}
	
	static int solve(Node root){
        if(root==null) return 0;
        int lans = solve(root.left);
        int rans = solve(root.right);
        int temp = root.data;
        root.data = lans+rans;
        return lans+rans+temp;
    }
    
    public static void toSumTree(Node root){
         //add code here.
         solve(root);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//			        10
//			     /      \
//			   -2        6
//			  /   \     /  \
//			 8    -4   7    5
		Node root = new Node(10);
		root.left = new Node(-2);
		root.left.left = new Node(8);
		root.left.right = new Node(-4);
		root.right =  new Node(6);
		root.right.left = new Node(7);
		root.right.right = new Node(5);
		
		toSumTree(root);
	}

}
