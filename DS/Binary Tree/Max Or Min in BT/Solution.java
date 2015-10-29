import java.io.*;

class Node{
	public int iData;
	public Node leftChild;
	public Node rightChild;

	public Node(int id){
		iData = id;
		leftChild = null;
		rightChild = null;
	}

	public void displayNode(){
		System.out.print(iData+" ");
	}
}	

class BinaryTree{
	private Node root;

	public BinaryTree(){
		root = null;
	}

	public void setRoot(Node r){
		root = r;
	}

	public Node getRoot(){ return root; }

	public int findMax(Node lr){
		if(lr==null)
			return Integer.MIN_VALUE;

		int res = lr.iData;
		int lres = findMax(lr.leftChild);
		int rres = findMax(lr.rightChild);

		res = (lres>res)?lres:res;
		res = (rres>res)?rres:res;

		return res;
	}

	public int findMin(Node lr){
		if(lr==null)
			return Integer.MAX_VALUE;

		int res = lr.iData;
		int lres = findMin(lr.leftChild);
		int rres = findMin(lr.rightChild);

		res = (lres<res)?lres:res;
		res = (rres<res)?rres:res;

		return res;
	}

}	

class Solution {
	public static void main(String[] args) throws IOException{
		Node root = new Node(2);
		root.leftChild = new Node(7);
		root.leftChild.rightChild = new Node(6);
		root.leftChild.rightChild.leftChild = new Node(1);
		root.leftChild.rightChild.rightChild = new Node(11);
		root.rightChild = new Node(5);
		root.rightChild.rightChild = new Node(9);
		root.rightChild.rightChild.leftChild = new Node(4);

		BinaryTree bt = new BinaryTree();
		bt.setRoot(root);

		System.out.println("Max is "+bt.findMax(bt.getRoot()));
		System.out.println("Min is "+bt.findMin(bt.getRoot()));


	}
}