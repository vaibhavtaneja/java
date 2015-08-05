import java.io.*;
import java.util.*;

class Queue{
	int maxSize,rear,front,nItems;
	int [] queArray;

	public Queue(int s){
		maxSize = s;
		rear = -1;
		front = 0;
		nItems = 0;
		queArray = new int[maxSize];
	}

	public void enQueue(int s){
		if(nItems!=maxSize){
			if(rear==maxSize-1)
				rear = -1;
			queArray[++rear] = s;
			nItems++;
		}
	}

	public int deQueue(){
		int x = queArray[front++];
		if(front==maxSize)
			front = 0;
		nItems--;
		return x;
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



class Solution{
	public static void main(String[] args) throws IOException{
		int [] arr = {9,8,7,6,5,4,3,2,1};
		result(arr);
	}

	public static void result(int [] arr){
		Arrays.sort(arr);
		
		Queue q1 = new Queue(arr.length); 
		Queue q2 = new Queue(arr.length);
		Queue q3 = new Queue(arr.length);
		
		int sum =0;

		for (int i =0;i<arr.length ;i++) {
			int x = arr[i]%3;
			switch(x){
				case 0:
					q1.enQueue(arr[i]);
					break;
				case 1:
					q2.enQueue(arr[i]);
					break;
				case 2:
					q3.enQueue(arr[i]);
					break;
			}		
			sum+=arr[i];
		}
		System.out.println(sum);
		if(sum%3==0){
			for (int i =arr.length-1;i>=0 ;i-- ) {
				System.out.print(arr[i]);
			}
			return ;
		}else if (sum%3==1) {
			if(q2.size()>=1){
				q2.deQueue();
			}else if (q3.size()>1) {
				q3.deQueue();
				q3.deQueue();
			}else{
				System.out.println("No can't be formed");
				return;
			}
		}else{
			if(q3.size()>=1){
				q3.deQueue();
			}else if (q2.size()>1) {
				q2.deQueue();
				q2.deQueue();
			}else{
				System.out.println("No can't be formed");
				return;
			}
		}

		int [] aux = new int [q1.size()+q2.size()+q3.size()]; 
		int j =0;
		
		while(!q1.isEmpty()){
			aux[j]= q1.deQueue();
			j++;
		}
		while(!q2.isEmpty()){
			aux[j]= q2.deQueue();
			j++;
		}
		while(!q3.isEmpty()){
			aux[j]= q3.deQueue();
			j++;
		}

		Arrays.sort(aux);
		

		for (int k =aux.length-1;k>=0 ;k-- ) 
			System.out.print(aux[k]);

		System.out.println("");


	}
}