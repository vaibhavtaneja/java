import java.io.*;

class Node{
	public int iData;
	public Node right,left;

	public Node(int id){
		iData = id;
		left=right=null;
	}
}
	
class BinaryTree{
	private Node root;

	public void setRoot(Node r){root = r;}

	public Node getroot(){return root;}

	public Node removeHalfNodes(Node lr){
		if(lr==null)
			return null;

		lr.left = removeHalfNodes(lr.left);
		lr.right = removeHalfNodes(lr.right);

		if(lr.left==null&&lr.right==null)
			return lr;

		if (lr.left==null) {
			return lr.right;
		}

		if (lr.right==null) {
			return lr.left;
		}

		return lr;
	}
	public void inOrder(Node lr){
		if(lr!=null){
			inOrder(lr.left);
			System.out.print(lr.iData+" ");
			inOrder(lr.right);
		}
	}
}

class Solution {
	public static void main(String[] args) {
		Node root = new Node(2);
		root.left = new Node(7);
		root.right = new Node(5);
		root.left.right = new Node(6);
		root.left.right.left = new Node(1);
		root.left.right.right = new Node(11);

		root.right.right = new Node(9);
		root.right.right.left = new Node(4);

		BinaryTree bt = new BinaryTree();
		bt.setRoot(root);
		bt.inOrder(bt.getroot());
		System.out.println();
		bt.setRoot(bt.removeHalfNodes(bt.getroot()));

		bt.inOrder(bt.getroot());


	}	
}