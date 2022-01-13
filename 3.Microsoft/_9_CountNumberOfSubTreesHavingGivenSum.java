package _3_microsoft;

public class _9_CountNumberOfSubTreesHavingGivenSum {
	
	public static class Node{
	    int data;
	    Node left,right;
	    Node(int d){
	        data=d;
	        left=right=null;
	    }
	}
	
	public static class Pair{
        int sum, count;
        Pair(int sum, int count){
            this.sum = sum;
            this.count = count;
        }
    }
    
    public static Pair solve(Node root, int x){
        if(root==null) return new Pair(0,0);
        Pair left = solve(root.left,x);
        Pair right = solve(root.right,x);
        int sum = root.data + left.sum + right.sum;
        int count = left.count + right.count;
        if(sum==x) count++;
        return new Pair(sum,count);
    }
    
    //Function to count number of subtrees having sum equal to given sum.
    public static int countSubtreesWithSumX(Node root, int x){
	    //Add your code here.
	    return solve(root,x).count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//				  5
//		       /    \
//		    -10      3
//		    /  \    /  \
//		   9    8 -4    7
		
		Node root = new Node(5);
		root.left = new Node(-10);
		root.left.left = new Node(9);
		root.left.right = new Node(8);
		root.right = new Node(3);
		root.right.left = new Node(-4);
		root.right.right = new Node(7);
		
		int x = 7;
		System.out.println(countSubtreesWithSumX(root, x));
	}

}
