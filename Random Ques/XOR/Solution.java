import java.io.*;

class Solution{
	public static void main(String[] args) throws IOException{
		int [] arr = {1,1,2,2,3,3,4,4,5,5,6};

		int sol =0;

		for (int i=0;i<arr.length ;i++ ) {
			sol = sol ^ arr[i];
		}

		System.out.println(sol);

	}
}