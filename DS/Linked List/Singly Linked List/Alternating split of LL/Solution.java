import java.io.*;

class Node {
	public int iData;
	public Node next;

	public Node(int id){ iData = id; }
}

class LinkedList{
	private Node head;

	public Node getHead(){ return head; }

	public void setHead(Node a){ head = a; }

	public void insert(int i){
		Node newNode = new Node(i);
		newNode.next = head;
		head = newNode;
	}

	public void displayList(){
		Node current = head;
		System.out.println("List is : ");
		while(current!=null){
			System.out.print(current.iData+" ");
			current = current.next;
		}
		System.out.println();
	}

	/*
	class HeadWrapper{
		Node h1;
		Node h2;
	}
	
	public void alternateNodes(LinkedList l1,LinkedList l2){
		//HeadWrapper h = new HeadWrapper();

		Node h1;
		Node h2;

		alternateNodesUtil(h1,h2);
		l1.setHead(h1);
		l2.setHead(h2);
	}
	//*/

	public void alternateNodes(LinkedList ll1,LinkedList ll2){
		Node current = head;
		Node l1 = null;
		Node l2 = null;
		//*
		Node h1 = null;
		Node h2 = null;
		//*/
		while(current!=null){
			//System.out.println("c "+current.iData);
			Node n = new Node(current.iData);
			if(h1==null)
				h1=n;
			else
				l1.next=n;
			l1=n;
			/*
			Node c = h1;
			System.out.println("List ");
			while(c!=null){
				System.out.print(c.iData+" ");
				c=c.next;
			}
			System.out.println();
			//*/

			current=current.next;
			n= new Node(current.iData);
			if(current==null)
				break;
			if(h2==null)
				h2=n;
			else
				l2.next=n;
			l2=n;	
			current=current.next;		
		}

		ll1.setHead(h1);
		ll2.setHead(h2);

	}

}

class Solution {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();

		ll.insert(6);
		ll.insert(5);
		ll.insert(4);
		ll.insert(3);
		ll.insert(2);
		ll.insert(1);

		ll.displayList();

		LinkedList l1 =new LinkedList(),l2= new LinkedList();

		//Node h1=null,h2=null; 
		ll.alternateNodes(l1,l2);

		/*
		l1.setHead(h1);
		l2.setHead(h2);
		//*/
		l1.displayList();
		l2.displayList();


	}
}

