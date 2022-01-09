package amazon;
import java.util.*;

public class _11_SerializeAndDeserializeABinaryTree {
	
	public static class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data = data;
			left = right = null;
		}
	}
	
	public static class Tree 
	{
	    //Function to serialize a tree and return a list containing nodes of tree.
		public void serialize(Node root, ArrayList<Integer> a) 
		{
		    //code here
		    if(root==null){
		        a.add(-1);
		        return;
		    }
		    a.add(root.data);
		    serialize(root.left,a);
		    serialize(root.right,a);
		}
		
		int idx = 0;
		
		//Function to deserialize a list and construct the tree.
	    public Node deSerialize(ArrayList<Integer> a)
	    {
	        //code here
	        if(a.get(idx)==-1) return null;
	        Node root = new Node(a.get(idx));
	        idx++;
	        root.left = deSerialize(a);
	        idx++;
	        root.right = deSerialize(a);
	        return root;
	    }
	};
	
	public static void inorder(Node root) {
		if(root==null) return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);     //    1
		root.left = new Node(2);     //   / \
		root.right = new Node(3);    //  2   3
		
		Tree tree = new Tree();
		
		ArrayList<Integer> list = new ArrayList<>();
		tree.serialize(root,list);
		Node newNode = tree.deSerialize(list);
		inorder(newNode);
	}

}
