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

	}

	public Node getHead(){ return head; }

	public void setHead(Node a){  head=a; }

	public void displayList(){
		System.out.print("The list is : ");
		Node current = head;
		while(current!=null){
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}

	public Node sortedIntersect(Node a,Node b){
		if(a!=null&&b!=null)
		System.out.println(" Before null check a iData " +a.iData+" b iData "+b.iData);
		if(a==null||b==null){
			System.out.println("Null check  ");	
			return null;
		}
		if(a!=null&&b!=null)
		System.out.println("Less check a iData " +a.iData+" b iData "+b.iData);
		if(a.iData<b.iData){
			System.out.println("less check  ");	
			return sortedIntersect(a.next,b);
		}
		if(a!=null&&b!=null)
		System.out.println("more check a iData " +a.iData+" b iData "+b.iData);

		if(a.iData>b.iData){
			System.out.println("More check  ");	
			return sortedIntersect(a,b.next);
		}

		Node temp = new Node(a.iData);
		if(temp!=null)
		System.out.println("a iData " +a.iData+" b iData "+b.iData+"tem .iData "+temp.iData );
		temp.next = sortedIntersect(a.next,b.next);

		return temp;

	}


}


class Solution {
	public static void main(String[] args) throws IOException{
		LinkedList ll = new LinkedList();

		ll.insert(6);
		ll.insert(4);
		ll.insert(3);
		ll.insert(2);
		ll.insert(1);

		ll.displayList();

		LinkedList ll2 = new LinkedList();

		ll2.insert(6);
		ll2.insert(4);
		ll2.insert(2);

		ll2.displayList();
		
		LinkedList ll3 = new LinkedList();

		ll3.setHead(ll2.sortedIntersect(ll.getHead(),ll2.getHead()));

		ll3.displayList();

	
	}
}