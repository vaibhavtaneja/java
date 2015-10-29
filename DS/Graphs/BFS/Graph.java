import java.io.*;

class Neighbour{
	public int vertexNum;
	public Neighbour next;

	public Neighbour(int v,Neighbour nbr){
		vertexNum=v;
		next = nbr;
	}
}

class Vertex{
	public String name;
	public Neighbour list;
	public Vertex(String n,Neighbour nbr){
		name = n;
		list = nbr;
	}
}

class Queue{
	private int [] queArray;
	private int rear,front,size;

	public Queue(int s){
		rear=-1;
		front=0;
		size=s;
		queArray= new int[s];
	}

	public void insert(int s){ 
		queArray[++rear] = s; 

		if (rear==size) rear =0;
	}

	public int remove() { 
		int temp = queArray[front++];
		if(front==size)
			front=0;
		return temp;	
	}

	public boolean isEmpty(){ return ((rear+1==front) || (rear==front+size-1)); }

}

class Graph {
	Vertex [] adjList;
	public Queue theQueue;

	public Graph(String file)throws IOException,FileNotFoundException{

		FileInputStream fis = new FileInputStream(new File(file));
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));

		boolean undirected = true;
		if(br.readLine().equals("directed"))
			undirected = false;

		int no = Integer.parseInt(br.readLine());

		adjList = new Vertex[no];

		theQueue = new Queue(no);

		for (int i=0;i<adjList.length ;i++ ) 
			adjList[i] = new Vertex(br.readLine(),null);

		String line = br.readLine();

		while(line!=null){
			String [] l = line.split(" ");
			int v1 = indexForName(l[0]);
			int v2 = indexForName(l[1]);

			adjList[v1].list = new Neighbour(v2,adjList[v1].list);

			if(undirected)
				adjList[v2].list = new Neighbour(v1,adjList[v2].list);

			line = br.readLine();
		}
	}

	public int indexForName(String s){
		for (int i =0;i<adjList.length ;i++ ) 
			if (adjList[i].name.equals(s)) 
				return i;
		return -1;
	}

	public void print(){
		System.out.println("Graph is ");

		for (int i =0;i<adjList.length ;i++ ) {
			System.out.print(adjList[i].name);
			for (Neighbour nbr = adjList[i].list; nbr!=null ;nbr=nbr.next ) {
				System.out.print(" -- "+adjList[nbr.vertexNum].name);
			}
			System.out.println();
		}
	}

	public void bfs(){
		boolean [] visited = new boolean[adjList.length];
		for (int i=0;i<adjList.length ;i++ ) 
			if(!visited[i])
				bfs(i,visited);
	}

	public void bfs(int v, boolean [] visited){
		
		int v1 =v;
		visited[v1]=true;
		theQueue.insert(v1);
		System.out.println(adjList[v1].name);


		while(!theQueue.isEmpty()){
			v1 = theQueue.remove();
			for (Neighbour nbr = adjList[v1].list;nbr!=null ;nbr = nbr.next ) {
				if(!visited[nbr.vertexNum]){
					int v2 = nbr.vertexNum;
					visited[v2] = true;
					theQueue.insert(v2);
					System.out.println(adjList[v2].name);				
				}	
			}
		}

	}		


	public static void main(String[] args) throws IOException{
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the file name : ");
		String file = bs.readLine();
		Graph g = new Graph(file);
		g.print();
		g.bfs();
	}

}