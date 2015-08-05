import java.io.*;

class StacxkX{
	private int top;
	private int [] stackArray;
	private int maxSize;

	public StacxkX(int s){
		maxSize = s;
		stackArray = new int[maxSize];
		top = -1;
	}

	public void push(int j){
		stackArray[++top] = j;
	}

	public int pop(){
		return stackArray[top--];
	}

	public boolean isEmpty(){
		return top == -1;
	}
}

class NGE {
	private int [] array;
	private StacxkX theStack;

	public NGE(int [] a){
		array = a;
		theStack = new StacxkX(array.length);
		theStack.push(array[0]);
	} 

	public void printNGE(){
		for (int i =1;i<array.length ;i++ ) {
			int next = array[i];

			if(!theStack.isEmpty()){
				int element = theStack.pop();
				while(element<next){
					System.out.println(element+" -- > "+next);
					if(theStack.isEmpty())
						break;
					element = theStack.pop();
				}

				if(element>next){
					theStack.push(element);
				}
			}
			theStack.push(next);
		}
		while(!theStack.isEmpty()){
			System.out.println(theStack.pop()+" -- > "+"-1");
		}
	}

}

class Solution{
	public static void main(String[] args) throws IOException{
		int [] a = {11,13,21,3};
		NGE nge = new NGE(a);
		nge.printNGE();

	}
}