import java.io.*;

class Node{
	public int iData;
	public double dData;
	public Node rightChild;
	public Node leftChild;

	public Node(int id,double dd){
		iData = id;
		dData = dd;
		rightChild = null;
		leftChild = null;
	}

	public void displayNode(){
		System.out.print("{ "+iData+", "+dData+" } ");
	}
}

class Tree{
	private Node root;

	public Tree()
	{ root = null; }

	public Node find(int key){
		Node current = root;

		while(current.iData != key){
			if(key<current.iData)
				current = current.leftChild;
			else
				current = current.rightChild;
			if(current == null)
				return null;
		}

		return current;
	}

	public void insert(int id,double dd){
		Node newNode = new Node(id,dd);
		if(root==null)
			root = newNode;
		else{
			Node current = root;
			Node parent;
			while(true){
				parent = current;
				if(id < current.iData){
					current = current.leftChild;
					if(current==null){
						parent.leftChild=newNode;
						return;
					}
				}
				else{
					current = current.rightChild;
					if(current==null){
						parent.rightChild=newNode;
						return;
					}
				}
			}
		}
	}


	public boolean delete(int key){
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;

		if(root == null){
			return false;
		}

		while(current.iData!=key){
			parent = current;
			if(key<current.iData){
				isLeftChild = true;
				current = current.leftChild;
			}
			else{
				isLeftChild = false;
				current = current.rightChild;
			}
			if(current==null)
				return false;
		}

		if(current.leftChild==null && current.rightChild==null){
			if(current==root)
				root = null;
			else if(isLeftChild)
				parent.leftChild=null;
			else
				parent.rightChild=null;
		}
		else if(current.rightChild==null){
			if(current==root)
				root=current.leftChild;
			else if(isLeftChild)
				parent.leftChild=current.leftChild;
			else
				parent.rightChild=current.leftChild;
		}
		else if(current.leftChild==null){
			if(current==root)
				root=current.rightChild;
			else if(isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;
		}
		else{
			Node successor = getSuccessor(current);

			if(current==root)
				root = successor;
			else if(isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;

			successor.leftChild=current.leftChild;

		}
		return true;
	}

	private Node getSuccessor(Node delNode){
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;

		while(current!=null){
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}

		if(successor != delNode.rightChild){
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}

		return successor;
	}

	public void traverse(int traverseType){
		switch (traverseType) {
			case 1:
					System.out.print("\nPreorder traversal : ");
					preOrder(root);
					break;
			case 2:
					System.out.print("\nInorder traversal : ");
					inOrder(root);
					break;

			case 3:
					System.out.print("\nPostorder traversal : ");
					postOrder(root);
					break;
		}
		System.out.println();
	}

	private void preOrder(Node localRoot){
		if (localRoot!=null) {
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	private void inOrder(Node localRoot){
		if(localRoot!=null){
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.iData+" ");
			inOrder(localRoot.rightChild);
		}
	}

	private void postOrder(Node localRoot){
		if (localRoot != null) {
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.iData+" ");
		}
	}
}

class TreeApp{
	public static void main(String[] args) throws IOException{
		int value;
		Tree theTree = new Tree();
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));

		theTree.insert(50,1.5);
		theTree.insert(25,1.2);
		theTree.insert(75,1.7);
		theTree.insert(12,1.5);
		theTree.insert(37,1.2);
		theTree.insert(43,1.2);
		theTree.insert(30,1.4);
		theTree.insert(33,1.1);
		theTree.insert(87,1.9);
		theTree.insert(93,1.5);
		theTree.insert(97,1.5);

		while(true){
			System.out.print("Enter the first letter of insert, find, delete, or traverse : ");
			char choice = bs.readLine().charAt(0);

			switch(choice)
			{
				case 'i':
				System.out.print("Enter the value to insert : ");
				value = Integer.parseInt(bs.readLine());
				theTree.insert(value,value+0.9);
				break;
				case 'f':
				System.out.print("Enter the value to find : ");
				value = Integer.parseInt(bs.readLine());
				Node found = theTree.find(value);
				if(found!=null){
					System.out.print("Found ");
					found.displayNode();
					System.out.println();
				}
				else
					System.out.println("Could not find  "+value);
				break;
				case 'd':
				System.out.print("Enter the value to delete : ");
				value = Integer.parseInt(bs.readLine());
				boolean didDelete = theTree.delete(value);
				if(didDelete)
					System.out.println("deleted "+value);
				else
					System.out.println("Could not delete "+value);
				break;
				case 't':
				System.out.print("Enter the type 1 ,2 or 3 : ");
				value = Integer.parseInt(bs.readLine());
				theTree.traverse(value);
				break;
				default:
				System.out.println("Invalid entry");
			}

		}

	}
}