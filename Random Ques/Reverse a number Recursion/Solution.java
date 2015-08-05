import java.io.*;


class Solution {
	public static void main(String[] args) throws IOException{
		System.out.println("Enter the number to reverse : ");
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bs.readLine());

		int r = reverse(n);

		System.out.println(r);

	}

	public static int reverse(int n){
		if(n<10){
			return n;
		}	
		String s = ""+n;
		//int l = (n%10)*(int)Math.pow(10,s.length()-1);
		return (n%10)*(int)Math.pow(10,s.length()-1) + reverse(n/10);
	}



}