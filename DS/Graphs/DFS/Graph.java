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

class Graph {
	Vertex [] adjList;

	public Graph(String file)throws IOException,FileNotFoundException{

		FileInputStream fis = new FileInputStream(new File(file));
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));

		boolean undirected = true;
		if(br.readLine().equals("directed"))
			undirected = false;

		adjList = new Vertex[Integer.parseInt(br.readLine())];

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

	public void DFS(){
		boolean [] visited =new boolean[adjList.length];
		for (int i =0;i<adjList.length ;i++ ) {
		 	if(!visited[i]){
		 		System.out.println("Starting at "+adjList[i].name);
		 		DFS(i,visited);
		 	} 
		 }
	}

	public void DFS(int v,boolean [] visited){
		visited[v]=true;
		System.out.println("Visiting "+adjList[v].name);
		for (Neighbour nbr = adjList[v].list;nbr!=null ; nbr=nbr.next ) {
			if (!visited[nbr.vertexNum]) {
				System.out.println(adjList[v].name+" -- "+adjList[nbr.vertexNum].name+" ");
				DFS(nbr.vertexNum,visited);
			}
		}
	}	


	public static void main(String[] args) throws IOException{
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the file name : ");
		String file = bs.readLine();
		Graph g = new Graph(file);
		g.print();
		g.DFS();
	}

}