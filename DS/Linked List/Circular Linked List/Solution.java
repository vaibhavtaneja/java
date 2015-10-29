import java.io.*;

class Node{
	public int iData;
	public Node next;

	public Node(int id){ iData=id; }
}

class CircularList{
	private Node head;
	//private Node tail;

	public void insert(int id){
		Node newNode = new Node(id);
		Node h = head;

		newNode.next = h;

		if(head!=null){
			while(h.next!=head)
				h=h.next;
			h.next=newNode;
		}else
			newNode.next=newNode;

		head=newNode;	

	}

	public void printList(){
		Node temp = head;

		System.out.print("List is ");

		do{
			System.out.print(temp.iData+" ");
			temp=temp.next;
		}
		while(temp!=head);
	}

}

class Solution {
	public static void main(String[] args) {
		CircularList cll = new CircularList();

		cll.insert(7);
		cll.insert(6);
		cll.insert(5);
		cll.insert(4);
		cll.insert(3);
		cll.insert(2);
		cll.insert(1);

		cll.printList();

	}
}