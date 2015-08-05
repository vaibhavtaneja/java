import java.io.*;

class Node{
	public Node leftChild;
	public Node rightChild;
	public int iData;

	public Node(int id){
		iData = id;
	}
}

class Tree{
	private Node root;

	public Tree(){root = null;}

	public Node getRoot(){return root;}

	public Node ArrayToBST(int [] arr,int start,int end){
		if(start>end)
			return null;
		

		int mid = ((end - start)/2);;
		/*
		if(end-start+1 == arr.length) 
		mid = (int)Math.ceil((start+end)/2) + 1;
		else
		mid = (int)Math.ceil((start+end)/2);
		//*/
		/*
		if((end-start)%2==0)

		mid = start + (end-start)/2;

		else

		mid = start + (end-start)/2+1;
		//*/	
		/*
		if((end-start)%2==1)
			mid++;
		//*/
		
		Node lr = new Node(arr[mid]);	

		if (root==null) 
			root=lr;

		lr.leftChild = ArrayToBST(arr,start,mid-1);

		lr.rightChild = ArrayToBST(arr,mid+1,end);

		return lr;
	}

	public void inOrder(Node lr){
		if(lr!=null){
			inOrder(lr.leftChild);
			System.out.print(lr.iData+" ");
			inOrder(lr.rightChild);
		}
	}

	public void preOrder(Node lr){
		if(lr!=null){
			System.out.print(lr.iData+" ");
			//System.out.println(" LeftChild ");
			preOrder(lr.leftChild);
			//System.out.println(" RightChild ");
			preOrder(lr.rightChild);
		}	
	}

}

class Solution{
	public static void main(String[] args) {
		Tree theTree = new Tree();
		int [] arr = {1,2,3,4,};

		theTree.ArrayToBST(arr,0,arr.length-1);


		theTree.inOrder(theTree.getRoot());

		System.out.println();

		theTree.preOrder(theTree.getRoot());


	}
}
