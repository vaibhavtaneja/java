import java.io.*;
import java.util.*;

class Node{
	public int iData;
	public Node left,right;

	public Node(int i){iData = i;}
}

class BinaryTree{
	private Node root;

	public Node getRoot(){ return root; }

	public void setRoot(Node r){ root = r; }

	public void printLevelOrder(){
		if(root==null)
			return;

		Queue<Node> que = new LinkedList<Node>();
		//Stack<Node> que = new Stack<Node>();
		que.add(root);

		while(!que.isEmpty()){
			Node n = que.remove();
			System.out.print(n.iData+" ");
			if(n.left!=null){
				que.add(n.left);
			}
			if (n.right!=null) {
				que.add(n.right);
			}
		}
	}

}

class Solution {
	public static void main(String[] args) {	
		Node r = new Node(5);
		r.left = new Node(4);
		r.right = new Node(6);
		r.right.left = new Node(7);
		r.right.right = new Node(8);
		r.right.left.left = new Node(9);
		r.right.left.right = new Node(10);
		
		BinaryTree bt = new BinaryTree();
		bt.setRoot(r);

		bt.printLevelOrder();
	}	
}