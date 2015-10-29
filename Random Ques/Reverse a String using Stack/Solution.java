import java.io.*;

class Stack{
	private int top ;
	private int size;
	private char [] stackArray;

	public Stack(int s){
		top=-1;
		size =s;
		stackArray = new char[size];
	}	

	public void push(char c){ stackArray[++top]=c;}

	public char pop(){ return stackArray[top--]; }

	public boolean isEmpty(){ return top==-1; }

	public boolean isFull(){ return top==size-1; }

}


class Solution{
	public static void main(String[] args) throws IOException{
		System.out.println("Enter string to reverse ");
		BufferedReader bs =new BufferedReader(new InputStreamReader(System.in));
		String s = bs.readLine();

		Stack stack = new Stack(s.length());

		for (int i=0;i<s.length() ;i++ ) {
			stack.push(s.charAt(i));
		}

		String rs = "";

		while(!stack.isEmpty())
			rs = rs + stack.pop();

		System.out.println("Reversed String is using stack "+rs);

		System.out.println("Reversed String is using recursion "+recursion(s));

	}


	public static String recursion(String s){
		if(s.length()<2)
			return s;
		else
			return recursion(s.substring(1))+s.charAt(0);
	}


}