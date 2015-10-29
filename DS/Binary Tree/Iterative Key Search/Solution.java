import java.io.*;

class Node{
	public int iData;
	public Node left;
	public Node right;

	public Node(int id){iData = id;}
}

class Queue{
	private int front,rear,size;
	private Node [] queArray;

	public Queue(int s){
		size = s;
		front = 0;
		rear = -1;
		queArray = new Node[size];
	}

	public void insert(Node n){
		if (rear==size-1) 
			rear = -1;
		queArray[++rear] = n;
		
	}

	public Node remove(){
		Node temp = queArray[front++];
		if (front==size)
			front=0;
		return temp; 
	}

	public boolean isEmpty(){
		return (front==rear+1||front+size-1==rear);
	}

	public Node peekFront(){
		return queArray[front];
	}

}

class BinaryTree{
	private Node root;

	public Node getRoot(){ return root; }

	public void setRoot(Node r) { root =r; }

	public boolean iterativeSearch(Node r,int x){
		if(r==null)
			return false;

		Queue theQue = new Queue(50);

		theQue.insert(root);

		while(!theQue.isEmpty()){
			if(theQue.peekFront().iData==x)
				return true;
			Node n = theQue.remove();
			
			if(n.left!=null)
				theQue.insert(n.left);
			if(n.right!=null)
				theQue.insert(n.right);
		}
		return false; 
	}
}

class Solution {
	public static void main(String[] args) throws IOException{
		Node root = new Node(2);
		root.left = new Node(7);
		root.left.right = new Node(6);
		root.left.right.left = new Node(1);
		root.left.right.right = new Node(11);
		
		root.right = new Node(5);
		root.right.right = new Node(9);
		root.right.right.left = new Node(4);

		BinaryTree bt = new BinaryTree();
		bt.setRoot(root);

		System.out.println("Key 6 was found "+bt.iterativeSearch(bt.getRoot(),6));
		System.out.println("Key 12 was found "+bt.iterativeSearch(bt.getRoot(),12));
		System.out.println("Key 11 was found "+bt.iterativeSearch(bt.getRoot(),11));

	}
}