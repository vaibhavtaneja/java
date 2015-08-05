class Node{
	public int iData;
	public Node next;

	public Node(int id){iData = id;}
}

class LinkedList{
	private Node head;

	public Node getHead(){return head;}

	public void setHead(Node h){head =h;}

	public void insert(int id){
		Node n = new Node(id);
		n.next=head;
		head=n;
	}

	public void displayList(){
		Node current = head;
		System.out.print("List is ");
		while (current!=null) {
			System.out.print(current.iData+" ");
			current = current.next;
		}
		System.out.println();
	}

	public void display(Node h){
		Node current = h;
		System.out.print("List is ");
		while (current!=null) {
			System.out.print(current.iData+" ");
			current = current.next;
		}
		System.out.println();
	}

	public Node mergeSort(Node h){
		if(h==null||h.next==null)
			return h;

		Node first = h;
		Node middle = findMiddle(h);
		Node second = middle.next;
		middle.next=null;

		Node a = mergeSort(first);
		Node b = mergeSort(second);

		return merge(a,b);
	}

	public Node findMiddle(Node h){
		Node slow = h;
		Node fast = h;
		while(fast!=null&&fast.next!=null&&fast.next.next!=null){
			slow= slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public Node merge(Node first,Node second){
		Node result = null;

		if(first==null)
			return second;
		else if(second==null)
			return first;
		else if(first.iData<=second.iData){
			result=new Node(first.iData);
			result.next = merge(first.next,second);
		}else{
			result= new Node(second.iData);
			result.next =merge(first,second.next);
		}

		return result;
	}

}

class Solution {
	public static void main(String[] args) {
		
	
		LinkedList ll = new LinkedList();

		ll.insert(1);
		ll.insert(7);
		ll.insert(3);
		ll.insert(5);
		ll.insert(9);
		ll.insert(2);
		ll.insert(6);

		ll.displayList();

		Node n = ll.mergeSort(ll.getHead());

		ll.display(n);
		
		ll.setHead(n);

		ll.displayList();
	}	

}