import java.io.*;

class Node{
	public int iData;
	public Node next;

	public Node(int id){iData=id;}
}

class LinkedList{
	private Node head;

	class headWrapper{
		Node headW ;
		Node lastW ;
	}

	public Node getHead(){ return head; }

	public void setHead(Node h){ head = h; }

	public Node sortedMerge(Node a,Node b){
		Node temp ;
		if(a==null&&b==null)
			return null;
		else if(b==null||a.iData<b.iData){
			temp = new Node(a.iData);
			temp.next = sortedMerge(a.next,b);
		}
		else{
			temp = new Node(b.iData);
			temp.next = sortedMerge(a,b.next);
			}
		return temp;	
	}

	/*
	public LinkedList sortedMerge(Node a,Node b){
		/*
		headWrapper hw = new headWrapper();
		headWrapper lw = new headWrapper();
	
		
		Node h = sortedMergeUtil(a,b,null,null);
		LinkedList ll = new LinkedList();
		ll.setHead(h);
		return ll;
	}
	/*
	public Node sortedMergeUtil(Node a,Node b,Node h,Node l){
		
		if(a==null&&b==null){
			l=null;
		}
			
		else if (a==null) {
			if (h==null) {
				h = new Node(b.iData);
				l=h;
			}else{
				l=new Node(b.iData);
			}
			sortedMergeUtil(a,b.next,h,l.next);
		}
		else if (b==null) {
			if (h==null) {
				h = new Node(a.iData);
				l=h;
			}else{
				l=new Node(a.iData);
			}
			sortedMergeUtil(a.next,b,h,l.next);
		}
		else if (a.iData>=b.iData) {
			if (h==null) {
				h = new Node(b.iData);
				l=h;
			}else{
				l=new Node(b.iData);
			}
			sortedMergeUtil(a,b.next,h,l.next);
		}
		else {
			if (h==null) {
				h = new Node(a.iData);
				l=h;
			}else{
				l=new Node(a.iData);
			}
			sortedMergeUtil(a.next,b,h,l.next);
		}
		return h;
	}	
	//*/
	/*
	

	public Node sortedMergeUtil(headWrapper hw,Node a,Node b,headWrapper lw){
		if(a!=null)
			System.out.print("Node a "+a.iData+" ");
		if (b!=null)
			System.out.print("Node b "+b.iData);
		System.out.println();
		if(a==null&&b==null)
			return hw.headW;
		else if (a==null) {
			System.out.println("1");
			if (hw.headW==null) {
				hw.headW = new Node(b.iData);
				lw.lastW=hw.headW;
			}else{
				lw.lastW=new Node(b.iData);
			}
			lw.lastW=lw.lastW.next;
			return sortedMergeUtil(hw,a,b.next,lw);
		}
		else if (b==null) {
			System.out.println("2");
			if (hw.headW==null) {
				hw.headW = new Node(a.iData);
				lw.lastW=hw.headW;
			}else{
				lw.lastW=new Node(a.iData);
			}
			lw.lastW=lw.lastW.next;
			Node current = hw.headW;
			while(current!=null){
				System.out.print(current.iData);
				current = current.next;
			}
			System.out.println();
			return sortedMergeUtil(hw,a.next,b,lw);
		}
		else if (a.iData>=b.iData) {
			System.out.println("3");
			if (hw.headW==null) {
				hw.headW = new Node(b.iData);
				lw.lastW=hw.headW;
			}else{
				lw.lastW=new Node(b.iData);
			}
			lw.lastW=lw.lastW.next;
			Node current = hw.headW;
			while(current!=null){
				System.out.print(current.iData);
				current = current.next;
			}
			System.out.println();
			return sortedMergeUtil(hw,a,b.next,lw);
		}else  {
			System.out.println("4");
			if (hw.headW==null) {
				hw.headW = new Node(a.iData);
				lw.lastW=hw.headW;
			}else{
				lw.lastW=new Node(a.iData);
			}
			lw.lastW=lw.lastW.next;
			Node current = hw.headW;
			while(current!=null){
				System.out.print(current.iData);
				current = current.next;
			}
			System.out.println();
			return sortedMergeUtil(hw,a.next,b,lw);
		}
	}
	//*/
	public void insert(int id){
		Node newNode = new Node(id);
		newNode.next = head;
		head = newNode;		
	}



	public void print(){	
		System.out.print("The list is : ");
		Node current = head;
		while(current!=null){
			System.out.print(current.iData);
			current = current.next;
		}
		System.out.println();
	}

}

class Solution {
	public static void main(String[] args) throws IOException{
		
		LinkedList ll = new LinkedList();

		ll.insert(9);
		ll.insert(7);
		ll.insert(3);
		ll.insert(2);
		ll.insert(1);

		ll.print();

		LinkedList ll2 = new LinkedList();

		ll2.insert(8);
		ll2.insert(6);
		ll2.insert(5);
		ll2.insert(4);

		ll2.print();

		LinkedList ll3 = new LinkedList();

		ll3.setHead(ll.sortedMerge(ll.getHead(),ll2.getHead()));
		ll3.print();
	


	}
}