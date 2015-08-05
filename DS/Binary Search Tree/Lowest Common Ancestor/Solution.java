import java.io.*;

class Node{
	public int iData;
	public Node leftChild;
	public Node rightChild;

	public Node(int id){
		iData = id;
	}
}

class Tree {
	private Node root;

	public Tree(){
		root = null;
	}

	public void insert(int id){
		Node newNode = new Node(id);
		
		if(root == null){
			root = newNode;
		}
		else{
			Node current = root;
			Node parent;
			while(true){
				parent = current;
				if(current.iData>id){
					current = current.leftChild;

					if(current == null){
						parent.leftChild = newNode;
						return;
					}	
				}else{
					current = current.rightChild;

					if (current==null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public void inorder(Node lr){
		if(lr != null){
			inorder(lr.leftChild);
			System.out.println(lr.iData+" ");
			inorder(lr.rightChild);
		}
	}

	public Node getRoot(){ return root; }

	public Node lca(Node lr,int n1,int n2){
		if(lr == null)
			return null;
		System.out.println("1 lr "+lr.iData+" "+n1+" "+n2);
		if (lr.iData>n1&&lr.iData>n2) {
			return lca(lr.leftChild,n1,n2);
		}
		System.out.println("2 lr "+lr.iData+" "+n1+" "+n2);
		if (lr.iData<n1&&lr.iData<n2) {
			return lca(lr.rightChild,n1,n2);
		}
		System.out.println("3 lr "+lr.iData+" "+n1+" "+n2);
		return lr;
	}

}

class Solution {
	public static void main(String[] args) {
		Tree t = new Tree();

		t.insert(20);
		t.insert(8);		
		t.insert(22);
		t.insert(4);
		t.insert(12);
		t.insert(10);
		t.insert(14);

		t.inorder(t.getRoot());

		int n1=10;
		int n2=14;
		Node l = t.lca(t.getRoot(),n1,n2); 
		System.out.println("Lca of "+n1+" "+n2+" is "+l.iData);

		n1 = 14; n2 = 8;
		l = t.lca(t.getRoot(),n1,n2); 
		System.out.println("Lca of "+n1+" "+n2+" is "+l.iData);

		n1 = 10; n2 = 22;
		l = t.lca(t.getRoot(),n1,n2); 
		System.out.println("Lca of "+n1+" "+n2+" is "+l.iData);
	}
}