import java.io.*;

class Node{
	public int iData;
	public Node next;

	public Node(int id){
		iData = id;
	}

	public void displayLink(){
		System.out.print(iData+" ");
	}

}

class LinkedList{
	private Node head;

	public void insert(int id){
		Node newNode = new Node(id);

		newNode.next = head;
		head = newNode;

		/*
		Node current = head;

		if (head==null) {
			head = newNode;
			return ;
		}

		while(current.next!=null){
			current = current.next;
		}

		current.next= newNode;
		//*/
	}

	public Node getHead(){ return head; }

	public int getCountIterative(){
		int count = 0;
		Node current = head;
		while(current!=null){
			current=current.next;
			count++;
		}
		return count;
	}

	public int getCountRecursive(Node h){
		if(h==null)
			return 0;
		else 
			return 1 + getCountRecursive(h.next);
	}

	public void displayList(){
		System.out.print("The list is : ");
		Node current = head;
		while(current!=null){
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}
}


class Solution {
	public static void main(String[] args) throws IOException{
		LinkedList ll = new LinkedList();

		ll.insert(1);
		ll.insert(2);
		ll.insert(3);
		ll.insert(4);
		ll.insert(5);
		ll.insert(6);
		ll.insert(7);

		ll.displayList();
		
		System.out.println("Size of ll iterative : "+ll.getCountIterative());
		System.out.println("Size of ll recursive : "+ll.getCountRecursive(ll.getHead()));
	
	}
}