class Link{
	public int iData; 
	public Link next;
	public Link previous;

	public Link(int id){ iData=id; }

	public void displayLink(){
		System.out.print(iData+" ");
	}
}

class DoublyLL{
	private Link first;
	private Link last;

	public boolean isEmpty(){ return first==null; }

	public void insertFirst(int dd){
		Link newLink = new Link(dd);
		if(isEmpty())
			last = newLink;
		else
			first.previous = newLink;
		newLink.next= first;
		first =	newLink;
	}

	public void insertLast(int dd){
		Link newLink = new Link(dd);
		if(isEmpty())
			first = newLink;
		else{ 
			last.next=newLink;
			newLink.previous=last;
		}	
		last = newLink;
	}


	public Link deleteFirst(){
		Link temp = first;
		if(first.next==null)
			last=null;
		else
			first.next.previous = null;
		first = first.next;
		return temp;
	}

	public Link deleteLast(){
		Link temp = last;
		if(first.next==null)
			first = null;
		else
			last.previous.next= null;
		last=last.previous;
		return temp;
	}	

	public boolean insertAfter(int key,int dd){
		Link current = first;
		while (current.iData!=key) {
			current = current.next;
			if(current==null)
				return false;
		}

		Link newLink = new Link(dd);

		if(current==last)
			last = newLink;
		else{
			newLink.next= current.next;
			current.next.previous= newLink;	
		}
		newLink.previous=current;
		current.next= newLink;
		return true;
	}

	public boolean deleteKey(int key){
		Link current = first;

		while(current.iData!=key){
			current=current.next;
			if(current==null)
				return false;
		}

		if(current==first)
			first=current.next;
		else
			current.previous.next= current.next;

		if(current==last)
			last=current.previous;
		else
			current.next.previous= current.previous;
		
		return true;
	}

	public void displayForward(){
		Link current= first;
		System.out.print("The list forward is ");
		while(current!=null){
			current.displayLink();
			current= current.next;
		}
		System.out.println();
	}

	public void displayBackWard(){
		Link current= last;
		System.out.print("The list backward is ");
		while(current !=null){
			current.displayLink();
			current= current.previous;
		}
		System.out.println();
	}

}	

class Solution {
	public static void main(String[] args) {
		DoublyLL dll = new DoublyLL();
		dll.insertFirst(22);
		dll.insertFirst(44);
		dll.insertFirst(66);

		dll.insertLast(11);
		dll.insertLast(33);
		dll.insertLast(55);

		dll.displayForward();
		dll.displayBackWard();


		dll.deleteFirst();
		dll.deleteKey(11);
		dll.deleteLast();

		dll.displayForward();

		dll.insertAfter(22,77);
		dll.insertAfter(33,80);

		dll.displayForward();
	}
}