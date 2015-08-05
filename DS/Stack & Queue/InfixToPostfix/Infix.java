import java.io.*;

class StackX{
	private int maxsize;
	private int top;
	private char [] stackArray;

	public StackX(int s){
		maxsize = s;
		top = -1;
		stackArray = new char[maxsize];
	}

	public void push(char j){
		stackArray[++top]=j;
	}

	public char pop(){
		return stackArray[top--];
	}

	public boolean isEmpty(){
		return top == -1;
	}

	public int size(){
		return top+1;
	}

	public char peekN(int n){
		return stackArray[n];
	}

	public void displayStack(String s){
		System.out.print(s);
		System.out.print("Stack (bottom-->top): ");
		for(int j =0;j<size();j++){
			System.out.print(peekN(j)+" ");
		}
		System.out.println("");
	}
}

class InToPost{
	private StackX theStack;
	private String input;
	private String output="";

	public InToPost(String in){
		input = in;
		theStack = new StackX(input.length());
	}

	public String doTrans(){
		for (int i = 0;i<input.length() ;i++ ) {
			char ch = input.charAt(i);
			theStack.displayStack("For " +ch+" ");

			switch(ch){
				case '+':
				case '-':
					gotOper(ch,1);
					break;
				case '*':
				case '/':
					gotOper(ch,2);
					break;
				case '(':
					theStack.push(ch);
					break;
				case ')':
					gotParen(ch);
					break;
				default:
					output += ch;
					break;
			}
		}
		while(!theStack.isEmpty()){
			output+=theStack.pop();
		}
		return output;
	}

	public void gotOper(char opThis,int prec1){
		while(!theStack.isEmpty()){
			char OpTop = theStack.pop();

			if(OpTop=='('){
				theStack.push(OpTop);
				break;
			}
			else{
				int prec2;

				if(OpTop=='+'||OpTop=='-')
					prec2=1;
				else
					prec2=2;
				
				if(prec2 < prec1){
					theStack.push(OpTop);
					break;
				}
				else
					output+=OpTop;
				break;
			}
		}
		theStack.push(opThis);
	}

	public void gotParen(char ch){
		while( !theStack.isEmpty())
		{
			char chx = theStack.pop();
			if(chx == '(')
				break;
			else
				output +=chx;
		}
	}
}

class Infix{
	public static void main (String [] args)throws IOException{
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
		String input,output;

		while(true){
			 input = bs.readLine();
			 if(input.equals(""))
			 	break;
			 InToPost theTrans = new InToPost(input);
			 output = theTrans.doTrans();
			 System.out.println(output); 	
		}	
	}
}












