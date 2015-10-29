import java.io.*;

class Solution {
	public static void main(String[] args) throws IOException{
		//char ch = 'a';
		int ch =1;
		for (int i=0;i<255 ;i++ ) {
			System.out.print(ch+" ");
			char c = (char)ch;
			System.out.println(c);
			ch++;
		}
	}
}