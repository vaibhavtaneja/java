import java.io.*;

class Neighbor{
	public int vertexNum;
	public Neighbor next;

	public Neighbor(int v,Neighbor nbr){
		vertexNum = v;
		next=nbr;
	}
}

class Vertex{
	String name;
	Neighbor adj;
	public Vertex(String n,Neighbor nbr){
		name = n;
		adj=nbr;
	}
}

class AdjListSol {

	Vertex [] adjLists;

	public AdjListSol(String fname) throws FileNotFoundException,IOException{
		FileInputStream fis = new FileInputStream(new File(fname));
		BufferedReader bs = new BufferedReader(new InputStreamReader(fis));

		String graphType = bs.readLine();
		boolean undirected = true;

		if(graphType.equals("directed"))
			undirected = false;

		adjLists = new Vertex[Integer.parseInt(bs.readLine())];

		for (int v =0;v<adjLists.length ;v++) {
			adjLists[v]= new Vertex(bs.readLine(),null);
		}

		String line = bs.readLine();

		while(line!=null){
			String [] l = line.split(" ");
			
			int v1 = indexForName(l[0]);
			int v2 = indexForName(l[1]);

			adjLists[v1].adj = new Neighbor(v2,adjLists[v1].adj);
			if(undirected)
				adjLists[v2].adj = new Neighbor(v1,adjLists[v2].adj);
			line=bs.readLine();
		}

	}

	public int indexForName(String s){
		for (int i =0;i<adjLists.length ;i++ ) {
			if(adjLists[i].name.equals(s))
				return i;
		}
		return -1;
	}

	public void print(){
		System.out.println();
		for (int i =0;i<adjLists.length ;i++ ) {
			System.out.print(adjLists[i].name);
			for (Neighbor nbr = adjLists[i].adj; nbr!=null ; nbr=nbr.next ) {
				System.out.print(" --> " +adjLists[nbr.vertexNum].name);
			}
			System.out.println();
		}
	}



	public static void main(String[] args) throws IOException{
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter name of the graph file ");
		String s = bs.readLine();	
		AdjListSol a = new AdjListSol(s);
		a.print();	

	}

}