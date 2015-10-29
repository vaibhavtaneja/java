import java.io.*;

class Solution{
	public static void main(String[] args) {
		boolean [] visited = new boolean[6];

		System.out.print("Printing visited array : ");
		for (int i=0;i<visited.length ;i++ ) {
			System.out.print(visited[i]+" ");
		}
		System.out.println();

		int [] flag = {0};
		
		System.out.println(flag[0]);		

		fun(visited,flag);

		System.out.print("Printing visited array : ");
		for (int i=0;i<visited.length ;i++ ) {
			System.out.print(visited[i]+" ");
		}
		System.out.println(flag[0]);

		fun();

	}

	public static void fun(){
		System.out.println("Hello world!!");
	}

	public static void fun(boolean [] visited,int [] flag){
		visited[0]=true;
		visited[2]=true;
		visited[4]=true;

		flag[0]=1;

		System.out.println("In fun ");

		System.out.print("Printing visited array : ");
		for (int i=0;i<visited.length ;i++ ) {
			System.out.print(visited[i]+" ");
		}
		System.out.println(flag[0]);

		System.out.println("Out of fun ");

	}

}