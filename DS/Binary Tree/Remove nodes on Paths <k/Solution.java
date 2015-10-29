import java.io.*;

class Node{
	public int iData;
	public Node left;
	public Node right;

	public Node(int id){iData = id;}
}

class BinaryTree{
	private Node root;

	public Node getRoot(){ return root; }

	public void setRoot(Node r) { root =r; }

	public Node removeShortPathNodes(Node r,int k){
		return removeShortPathNodesUtil(r,1,k);
	}

	public Node removeShortPathNodesUtil(Node r,int level,int k){
		
		if(r==null)
			return null;

		r.left = removeShortPathNodesUtil(r.left,level+1,k);
		r.right = removeShortPathNodesUtil(r.right,level+1,k);

		if(r.left==null && r.right==null && level<k)
			return null;

		return r;
	}
	
	public void inorder(Node r){
		if (r!=null) {
			inorder(r.left);
			System.out.print(r.iData+" ");
			inorder(r.right);
		}
	}

}

class Solution {
	public static void main(String[] args) throws IOException{
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.left = new Node(7);
		
		root.right = new Node(3);
		root.right.right = new Node(6);
		root.right.right.left = new Node(8);

		BinaryTree bt = new BinaryTree();
		bt.setRoot(root);	

		bt.inorder(bt.getRoot());

		System.out.println("\nChecking and removing all paths of length less than 3");

		bt.setRoot(bt.removeShortPathNodes(bt.getRoot(),3));

		bt.inorder(bt.getRoot());
		

	}
}