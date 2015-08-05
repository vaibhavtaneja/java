import java.io.*;

class StackX{
	private int top;
	private int [] stackArray;
	private int maxsize;

	public StackX(int s){
		maxsize = s;
		stackArray = new int [maxsize];
		top = -1;
	}
	public void push(int s){
		stackArray[++top]=s;
	}
	public int pop(){
		return stackArray[top--];
	}
	public boolean isEmpty(){
		return top == -1;
	}
	public void print(){
		System.out.print("Stack is : ");
		for (int i=top;i>=0 ;i-- ) {
			System.out.print(stackArray[i]+" ");
		}
		System.out.println("");
	}
}

class Solution{
	public static void main(String[] args) {
		StackX theStack = new StackX(5);
		theStack.push(1);
		theStack.push(2);
		theStack.push(3);
		theStack.push(4);
		theStack.push(5);

		theStack.print();

		reverse(theStack);

		theStack.print();
	}

	public static void reverse(StackX theStack){
		if(!theStack.isEmpty()){
			int temp = theStack.pop();
			reverse(theStack);
			//System.out.println("Value is "+temp);
			insertAtBottom(theStack,temp);
		}
	}

	public static void insertAtBottom(StackX theStack,int temp){
		System.out.println("Insert Value is "+temp);
		if(theStack.isEmpty()){
			theStack.push(temp);
		}else{
			int t = theStack.pop();
			insertAtBottom(theStack,temp);

			theStack.push(t);
		}	
	}

}