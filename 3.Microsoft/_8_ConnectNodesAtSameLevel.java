package _3_microsoft;
import java.util.*;

public class _8_ConnectNodesAtSameLevel {
	
	public static class Node{
        int data;
        Node left;
        Node right;
        Node nextRight;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
            nextRight = null;
        }
    }
	
	public static void connect(Node root){
        // Your code goes here.
        if(root==null) return;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0;i<len;i++){
                Node curr = q.poll();
                if(i==len-1) curr.nextRight = null;
                else curr.nextRight = q.peek();
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
        }
    }

	public static void main(String[] args) {
		
//		   10                  10 ------> NULL
//	      /  \                /  \
//	     3    5       =>     3 -> 5 --------> NULL
//	    / \    \            / \    \
//	   4   1    2          4 ->1 -> 2 -------> NULL
		
		Node root = new Node(10);
		root.left = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(1);
		root.right = new Node(5);
		root.right.right = new Node(2);
		
		connect(root);
	}

}
