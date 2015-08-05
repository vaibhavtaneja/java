import java.io.*;

class Solution{
	public static void main(String[] args)throws IOException {
		int a = 16;
		int b = 12;

		int c = a ^ b;

		int bc =0;

		while(c!=0){
			bc+=c&1;
			System.out.println("c & a "+bc);
			c=c>>1;
		}

		System.out.println("bc " +bc);
	}
}