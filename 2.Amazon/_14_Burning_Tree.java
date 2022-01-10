package amazon;
import java.util.*;

public class _14_Burning_Tree {
	
	public static class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
	}
	
	public static Node bfs(Node root, Map<Node,Node> map, int target){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Node ans = null;
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.data==target) ans = curr;
            if(curr.left!=null){
                map.put(curr.left,curr);
                q.offer(curr.left);
            }
            if(curr.right!=null){
                map.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
        return ans;
    }
    
    public static int solve(Node tar,Map<Node,Node> map){
        Set<Node> set = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(tar);
        set.add(tar);
        int time = 0;
        while(!q.isEmpty()){
            int len = q.size();
            time++;
            for(int i=0;i<len;i++){
                Node curr = q.poll();
                if(map.containsKey(curr) && set.add(map.get(curr))){
                    q.offer(map.get(curr));
                }
                if(curr.left!=null && set.add(curr.left)){
                    q.offer(curr.left);
                }
                if(curr.right!=null && set.add(curr.right)){
                    q.offer(curr.right);
                }
            }
        }
        return time-1;
    }
    
    public static int minTime(Node root, int target){
        // Your code goes here
        Map<Node,Node> map = new HashMap<>();
        Node tar = bfs(root,map,target);
        return solve(tar,map);
    }

	public static void main(String[] args) {
		
//		        1
//		      /	 \
//		    2     3
//		  /  \     \
//		 4    5     6
//		     / \     \
//		    7   8     9
//		               \
//		                10

		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(7);
		root.left.right.right = new Node(8);
		root.right = new Node(3);
		root.right.right = new Node(6);
		root.right.right.right = new Node(9);
		root.right.right.right.right = new Node(10);
		
		System.out.println(minTime(root, 8));
	}

}
