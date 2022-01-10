package amazon;

public class _15_DeleteNNodesAfterMNodesOfALinkedList {
	
	public static class Node{
	      int data;
	      Node next;
	      Node(int data)
	      {
	          this.data = data;
	          this.next = null;
	      }
	  }
	
	public static void linkdelete(Node head, int m, int n){
        // your code here
        Node temp = head;
        while(temp!=null){
            for(int i=1;i<m;i++){
                if(temp == null) break;
                temp = temp.next;
            }
            for(int i=0;i<n;i++){
                if(temp==null || temp.next == null) break;
                temp.next = temp.next.next;
            }
            if(temp==null) break;
            temp = temp.next;
        }
    }
	
	public static Node arrToLL(int arr[]) {
		Node head = new Node(-1);
		Node temp = head;
		for(int i=0;i<arr.length;i++) {
			temp.next = new Node(arr[i]);
			temp = temp.next;
		}
		return head.next;
	}

	public static void main(String[] args) {

		int arr[] = {9, 1, 3, 5, 9, 4, 10, 1};
		Node head = arrToLL(arr);
		
		int m=2,n=1;
		linkdelete(head, m, n);
		while(head!=null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}

}
