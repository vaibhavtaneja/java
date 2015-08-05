import java.io.*;

class StackX {
	private int maxSize;
	private int[] stackArray;
	private int top;

	public StackX(int s){
		maxSize = s;
		stackArray = new int[maxSize];
		top = -1;
	}

	public void push(int j){
		stackArray[++top]=j;
	}

	public int pop(){
		return stackArray[top--];
	}

	public int peek(){
		return stackArray[top];
	}

	public boolean isEmpty(){
		return top ==-1;
	}

	public int size(){
		return top+1;
	}

	public boolean isFull(){
		return top ==maxSize-1;
	}

	public int peekN(int n){
		return stackArray[n];
	}

	public void displayStack(String s){
		System.out.print(s);
		System.out.print("Stack (bottom-->top): ");
		for (int j =0;j<size() ;j++ ) {
			System.out.print(peekN(j));
			System.out.print(' ');
		}
		System.out.println("");
	}

}


class parsePost{
	private StackX theStack;
	private String input;

	public parsePost(String in){
		input = in;
	}

	public int doParse(){
		theStack = new StackX(20);
		int j,num1,num2,interAns;
		char ch;

		for (j=0;j<input.length() ;j++ ) {
			ch = input.charAt(j);
			theStack.displayStack(""+ch+" ");
			if (ch>='0'&&ch<='9') 
				theStack.push((int)(ch-'0'));
			else
			{
				num2 = theStack.pop();
				num1 = theStack.pop();
				switch(ch){
					case '+':
						interAns = num1+num2;
						break;
					case '-':
						interAns = num1-num2;
						break;
					case '*':
						interAns = num1*num2;
						break;
					case '/':
						interAns = num1/num2;
						break;
					default:
						interAns = 0;
				}
				//System.out.println(interAns);
				theStack.push(interAns);
			}
		}
		interAns = theStack.pop();
		return interAns;
	}
}

class postfix{
	public static void main(String[] args) throws IOException{
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
		String input,output;
		while(true){
			System.out.print("Enter postfiX: ");
			input = bs.readLine();
			if(input.equals(""))
				break;

			parsePost eParser = new parsePost(input);
			output =""+ eParser.doParse();
			System.out.println(output);
		}
	}
}