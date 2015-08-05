import java.io.*;

class Node{
	public int iData;
	public Node leftChild;
	public Node rightChild;

	public Node(int id){
		iData = id;
	}

	public void displayNode(){
		System.out.print("{ "+iData+" } ");
	}

}

class Tree {
	private Node root;

	public Tree(){
		root = null;
	}

	/*
	public void insert(int id){
		Node newNode = new Node(id);

		if(root == null){
			root = newNode;
		}else {
			Node current = root;
			Node parent;
			while(true){
				parent = current;
				if(id<current.iData){
					current = current.leftChild;
					if(current==null){
						parent.leftChild=newNode;
						return;
					}
				}else{
					current = current.rightChild;
					if(current==null){
						parent.rightChild=newNode;
						return;
					}
				}
			}	
		}
	}
	//*/

	//*
	public Node insert(Node localRoot,int id){
		if(localRoot==null){
			if(root==null){
				root = new Node(id);
			}
			return new Node(id);
		}
		else{
			if(id<localRoot.iData)
				localRoot.leftChild=insert(localRoot.leftChild,id);
			else
				localRoot.rightChild=insert(localRoot.rightChild,id);
			return localRoot;
		}
	}
	//*/	
	
	/*Not Working
	public void insert(Node lr,int key){
		if(lr==null){
			if(root==null){
				System.out.println("in this");
				this.root= new Node(key);
			}
			lr = new Node(key);
			System.out.println("in first "+lr.iData+" "+key);
			return ;
		}
		else{
			if(key<lr.iData){
				System.out.println("less "+lr.iData+" "+key);		
				insert(lr.leftChild,key);
				return ;
			}

			else{
				System.out.println("More "+lr.iData+" "+key);
				insert(lr.rightChild,key);
				return ;
			}
		}
	}
	//*/

	public Node getRoot(){
		return root;
	}

	public void inOrder(Node local){
		if(local!=null){
			inOrder(local.leftChild);
			System.out.print(local.iData+" ");
			inOrder(local.rightChild);
		}
	}

	public int minValue(){
		if(root ==null)
			return -1;

		Node current = root;
		while(current.leftChild!=null){
			current = current.leftChild;
		}
		return current.iData;
	}
}

class Solution{
	public static void main(String[] args) {
		
		Tree theTree = new Tree();
		System.out.println("Min value "+theTree.minValue());
		theTree.insert(theTree.getRoot(),3);
		theTree.insert(theTree.getRoot(),2);
		theTree.insert(theTree.getRoot(),1);
		theTree.insert(theTree.getRoot(),4);
		theTree.insert(theTree.getRoot(),5);
		theTree.insert(theTree.getRoot(),6);
		theTree.inOrder(theTree.getRoot());
		System.out.println();
		System.out.println("Min value "+theTree.minValue());

	}
}