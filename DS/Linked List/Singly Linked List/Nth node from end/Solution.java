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

	public void printNth(int x){
		int length = findLength();
		x = length - x +1;
		int c =1;
		Node current = head;
		//System.out.println(x+" "+current.iData);
		while(c!=x){
			c++;
			current = current.next;
		}
		System.out.println("Nth from end is "+current.iData);
	}

	public void printN(int x){
		Node main = head;
		Node current = head;
		int c =0;
		while(c!=x){
			current = current.next;
			c++;
		}

		while(current!=null){
			current=current.next;
			main = main.next; 
		}

		System.out.println(x+"th from end is "+main.iData);		

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
		ll.printNth(2);
		ll.printNth(3);

		ll.printN(2);
		ll.printN(3);
	}
}