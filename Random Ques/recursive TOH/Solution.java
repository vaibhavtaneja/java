import java.io.*;

class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bs.readLine());
		towerOfHanoi(n, 'A', 'C', 'B'); 

	}

	public static void towerOfHanoi(int n,char f,char t,char a){
		if(n==1){
			System.out.println("Move rod 1 from "+f+" to "+t);
			return ;
		}
		towerOfHanoi(n-1,f,a,t);
		System.out.println("Move rod "+n+" from "+f+" to "+t);
		towerOfHanoi(n-1,a,t,f);
	}
}