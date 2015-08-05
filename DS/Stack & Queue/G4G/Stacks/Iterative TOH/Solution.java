import java.io.*;
import java.util.*;

class Stack{
	int top;
	int [] stackArray;
	int maxSize;

	public Stack(int s){
		maxSize = s;
		stackArray = new int[maxSize];
		top = -1;
	}

	public boolean isEmpty(){
		return top == -1;
	}

	public boolean isFull(){
		return top == maxSize-1;
	}

	public void push(int j){
		stackArray[++top]=j;
	}

	public int pop(){
		if(isEmpty())
			return -1;
		return stackArray[top--];
	}
}

class Iterative{
	private Stack src;
	private Stack dest;
	private Stack aux;
	private int n;

	public Iterative(int s){
		n=s;
		src = new Stack(n);
		dest = new Stack(n);
		aux = new Stack(n);
	}

	public void tohIterative(){
		char s = 'S' , d = 'D' , a = 'A';
		if(n % 2 ==0){
			d = 'A';
			a = 'D';
		}
		int t = (int)Math.pow(2,n)-1;

		for(int i=n;i>0;i--){
			src.push(i);
		}

		for (int i=1;i<=t;i++) {
			if(i%3==1)
				moveDiskPoles(src,dest,s,d);
			if(i%3==2)
				moveDiskPoles(src,aux,s,a);
			if(i%3==0)
				moveDiskPoles(dest,aux,d,a);	
		}

	}

	public void moveDiskPoles(Stack sr,Stack des,char s,char d){
		int p1Top = sr.pop();
		int p2Top = des.pop();

		if(p1Top == -1){
			sr.push(p2Top);
			moveDisk(d,s,p2Top);
		}else if(p2Top == -1){
			des.push(p1Top);
			moveDisk(s,d,p1Top);
		}else if (p1Top<p2Top) {
			des.push(p2Top);
			des.push(p1Top);
			moveDisk(s,d,p1Top);
		}else{
			sr.push(p1Top);
			sr.push(p2Top);
			moveDisk(d,s,p2Top);
		}

	}

	public void moveDisk(char s,char d ,int j){
		System.out.println("Move the disk "+j+" from \'"+s+"\' to \'"+d+"\'");
	}


}
class Solution{
	public static void main(String[] args)throws IOException{
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the sixe of TOH : ");
		int n = Integer.parseInt(bs.readLine());

		Iterative it = new Iterative(n);

		it.tohIterative();

	}
}