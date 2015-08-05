import java.io.*;

class PriorityQ
{
	private int maxsize;
	private int [] queArray;
	private int nItems;

	public PriorityQ(int s){
		maxsize = s;
		queArray = new int[maxsize];
		nItems = 0;
	}

	public void insert(int j){
		if(nItems==0) // No item in queArray
			queArray[nItems++]=j;
		else{
			int i;
			for(i=nItems-1;i>=0;i--){
				if(j>queArray[i])
					queArray[i+1]=queArray[i];
				else
					break;
			}
			queArray[i+1]=j;
			nItems++;
		}
	} 

	public int remove(){
		return queArray[--nItems];
	}

	public int peekMin(){
		return queArray[nItems-1];
	}

	public boolean isEmpty(){
		return (nItems==0);
	}

	public boolean isFull(){
		return (nItems==maxsize);
	}

}

class PriorityQueue{

	public static void main(String [] args)throws IOException
	{
		PriorityQ thePQ = new PriorityQ(5);

		thePQ.insert(30);
		thePQ.insert(10);
		thePQ.insert(50);
		thePQ.insert(20);	 
		thePQ.insert(40);	


		while(!thePQ.isEmpty()){
			int l = thePQ.remove();
			System.out.print(l+" ");
		}

		System.out.println("");
	}	

}