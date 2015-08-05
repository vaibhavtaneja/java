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
	public int peek(){
		return stackArray[top];
	}
}


class Solution{

	public static void main(String[] args) {
		int [] stock = {100,80,60,70,60,75,85};
		StackX theStack = new StackX(stock.length);
		int [] span = new int[stock.length];

		calculateSpan(theStack,stock,span);

	}

	public static void calculateSpan(StackX theStack,int [] stock,int [] span){
		theStack.push(0);
		span[0]=1;

		for (int i =1;i<stock.length ;i++ ) {
			while(!theStack.isEmpty()&& stock[theStack.peek()]<=stock[i])
				theStack.pop();

			 	span[i] = theStack.isEmpty()? i+1:i - theStack.peek();
				theStack.push(i);
		}
		for (int i = 0;i<stock.length ;i++ ) {
			System.out.println(stock[i]+"  "+span[i]);
		}
	}
}
