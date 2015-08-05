class Queue{
	private int rear,front,maxSize,nItems;
	private int [] queArray;

	public Queue(int s){
		maxSize = s;
		front = 0;
		rear = -1;
		nItems = 0;
		queArray = new int[maxSize]; 
	}

	public void insert(int j){
		if(nItems < maxSize){
			if(rear == maxSize-1)
				rear = -1;
			queArray[++rear] = j;
			nItems ++; 
		}
	}	

	public int delete() {
		int temp = queArray[front++];
		if (front == maxSize) 
			front = 0;
		nItems --;
		return temp;
	}

	public int peekFroont(){
		return queArray[front];
	}

	public boolean isEmpty(){
		return nItems == 0;
	}

	public boolean isFull(){
		return nItems == maxSize;
	}

	public int size(){
		return nItems;
	} 
}

class Stack{
	private Queue q1;
	private Queue q2;
	//private int top;

	public Stack(int s){
		q1 = new Queue(s);
		q2 = new Queue(s);
	}

	public void push(int s){
		if(q1.isEmpty())
			q1.insert(s);
		else{
			q2.insert(s);
			while(!q1.isEmpty()){
				q2.insert(q1.delete());
			}
			Queue temp = q1;
			q1 = q2;
			q2 = temp;
		}
	}

	public int pop(){
		if(!q1.isEmpty())
			return q1.delete();
		return 0;
	}

	public boolean isEmpty(){
		return q1.isEmpty();
	}

}

class Solution{
	public static void main(String[] args) {
		Stack s = new Stack(10);

		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.push(7);

		while(!s.isEmpty()){
			System.out.println("Popped "+ s.pop());
		}

	}
}