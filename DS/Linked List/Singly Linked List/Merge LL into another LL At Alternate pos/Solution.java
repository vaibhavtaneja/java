class Node{
	public int iData;
	public Node next;

	public Node(int id){
		iData = id;
	}

	public void setNode(Node n){
		next=n;
	}

}

class LinkedList{
	private Node head;

	public Node getHead(){ return head; }

	public void setHead(Node h){ head = h; }

	public void insert(int id){
		Node newNode = new Node(id);
		newNode.next = head;
		head = newNode;
	}

	public void printList(){
		Node curr = head;
		System.out.print("List is : ");
		while(curr!=null){
			System.out.print(curr.iData+" ");
			curr=curr.next;
		}
		System.out.println();
	}

	//public void merge(Node p,Node q){
	public void merge(LinkedList p,LinkedList q){
	//public Node merge(Node p,Node q){
		//Node p_curr = p,q_curr = q,p_next,q_next;
		Node p_curr = p.getHead(),q_curr = q.getHead(),p_next,q_next;

		while(p_curr!=null&&q_curr!=null){
			p_next=p_curr.next;
			q_next=q_curr.next;

			q_curr.next=p_next;
			p_curr.next=q_curr;
			

			p_curr=p_next;
			q_curr=q_next;
		}

		//System.out.println(q_curr.iData);
		q.setHead(q_curr);
		//q.setNode( q_curr);
		//return q_curr;

	}

}

class Solution {
	public static void main(String[] args) {
		LinkedList a = new LinkedList();
		LinkedList b = new LinkedList();

		a.insert(9);
		a.insert(7);
		a.insert(5);
		a.insert(3);
		a.insert(1);

		b.insert(8);
		b.insert(6);
		b.insert(4);
		b.insert(2);

		a.printList();
		b.printList();

		//a.merge(a.getHead(),b.getHead());
		
		a.merge(a,b);

		//b.setHead(a.merge(a.getHead(),b.getHead()));

		a.printList();
		b.printList();




	}
}