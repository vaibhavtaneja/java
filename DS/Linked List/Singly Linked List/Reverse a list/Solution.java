class Node{
	public int iData;
	public Node next;

	public Node(int id){
		iData = id;
	}
}

class LinkedList{
	private Node head;

	public void insert(int x){
		Node newNode = new Node(x);
		newNode.next = head;
		head = newNode;
	}

	public void displayList(){
		Node current = head;
		System.out.println("List is");
		while(current!=null){
			System.out.print(current.iData+" ");
			current = current.next;
		}
		System.out.println();
	}

	public void reverse(){
		System.out.println("Reversing the list");
		reverseUtil(head,null);
	}

	public void reverseUtil(Node curr,Node prev){
		if (curr.next==null) {
			curr.next=prev;
			head=curr;
			return;
		}
		Node temp = curr.next;
		curr.next = prev;

		reverseUtil(temp,curr);
	}

	public int findLength(){
		Node current = head;
		int count =0;
		while(current!=null){
			count++;
			current=current.next;
		}
		return count;
	}
}

class Solution {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insert(1);
		ll.insert(2);
		ll.insert(3);
		ll.insert(4);
		ll.insert(5);

		ll.displayList();
		ll.reverse();
		ll.displayList();
		ll.reverse();
		ll.displayList();
		ll.reverse();
	}
}