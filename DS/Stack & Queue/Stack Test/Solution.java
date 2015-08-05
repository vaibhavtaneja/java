import java.io.*;

class StackX{

	private int maxSize;
	private int top;
	private int [] stackArray;

	public StackX ( int s ){
		maxSize = s;
		top = -1;
		stackArray = new int[maxSize];
	}

	public int push (int s){
		stackArray[++top] = s;
		return stackArray[top];
	}

	public int pop(){
		return stackArray[top--];
	}
	public boolean isEmpty(){
		return top==-1;
	}

}

class Solution {
	
	public static void main(String [] args)throws IOException{
		StackX theStack = new StackX(10);

		theStack.push(60);
		theStack.push(50);
		theStack.push(40);
		theStack.push(30);
		theStack.push(20);
		theStack.push(10);

		System.out.println(theStack.isEmpty());

		for(int i =0;i<6;i++){
			int l = theStack.pop();
			System.out.println(l);
		}
	}	
}