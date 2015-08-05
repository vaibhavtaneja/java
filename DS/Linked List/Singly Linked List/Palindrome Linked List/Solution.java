import java.io.*;
class Node{
	public int iData;
	public Node next;

	public Node(int id){iData=id;}
}

class LinkedList{
	private Node head;
	//*
	class headWrapper{
		Node headW = head;
	}

	public boolean isPalindrome(){
		headWrapper hw = new headWrapper();
		return isPalindromeUtil(hw,head);

	}

	public boolean isPalindromeUtil(headWrapper hw1,Node right){
		if(right==null)
			return true;
		//System.out.println("Right idata "+right.iData);	
		boolean isp = isPalindromeUtil(hw1,right.next);
		//System.out.println(isp);
		if(isp==false)
			return false;

		boolean ispl = (right.iData==hw1.headW.iData);

		hw1.headW = hw1.headW.next;

		return ispl;
	}
	//*
	public boolean isPUtil(){
		Node current = head;
		return isP(current);
	}

	public boolean isP(Node current){
		if(current==null)
			return true;
		boolean isp = isP(current.next);
		if(isp==false)
			return false;
		boolean ispl = (head.iData==current.iData);
		head = head.next;
		return ispl;


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

		ll.insert(1);
		ll.insert(2);
		ll.insert(3);
		ll.insert(2);
		ll.insert(1);

		ll.print();

		System.out.println(ll.isPalindrome());
		System.out.println(ll.isPUtil());
		ll.print();
		LinkedList ll2 = new LinkedList();

		ll2.insert(1);
		ll2.insert(2);
		ll2.insert(3);
		ll2.insert(2);
		ll2.insert(1);
		ll2.insert(4);

		ll2.print();

		System.out.println(ll2.isPalindrome());		
		System.out.println(ll2.isPUtil());
	}
}

