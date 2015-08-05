import java.io.*;

class twoStacks{
	private int maxSize;
	private int [] stackArray;
	private int top1,top2;

	public twoStacks(int s){
		maxSize = s;
		stackArray = new int [maxSize];
		top1 = -1;
		top2 = maxSize;
	}

	public void push1(int n){
		if(top1<top2-1){
			stackArray[++top1]=n;
		}else{
			System.out.println("Stack1 overflow");
		}
	}

	public void push2(int n){
		if(top1<top2-1){
			stackArray[--top2]=n;
		}else{
			System.out.println("Stack2 overflow");
		}	
	}

	public int pop1(){
		if(top1!=-1){
			return stackArray[top1--];
		}
		else{
			System.out.println("Stack1 underflow");
			return 0;
		}
	}

	public int pop2(){
		if(top2!=maxSize){
			return stackArray[top2++];
		}
		else{
			System.out.println("Stack2 underflow");
			return 0;
		}
	}

	public void displayStack(){
		System.out.print("Stack1 is : ");
		for (int i =0;i<=top1 ;i++ ) {
			System.out.print(stackArray[i]);
		}
		System.out.println();
		System.out.print("Stack2 is : ");
		for (int i =maxSize-1;i>=top2 ;i-- ) {
			System.out.print(stackArray[i]);
		}
		System.out.println();
	}	
}

class Solution{
	public static void main(String[] args) throws IOException{
		twoStacks theStack = new twoStacks(10);
		theStack.pop1();
		theStack.pop2();

		theStack.push1(1);
		theStack.push1(2);
		theStack.push1(3);
		theStack.push1(4);
		theStack.push1(5);

		theStack.push2(1);
		theStack.push2(2);
		theStack.push2(3);

		theStack.displayStack();
		
		theStack.pop1();
		theStack.pop2();
		theStack.pop1();
		theStack.pop2();

		theStack.displayStack();
	}
}