import java.io.*;

class Solution{
	public static  void main(String [] args)throws IOException{
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the no whose fac u wanna find : ");
		long f = Integer.parseInt(bs.readLine());
		System.out.println("");
		long ans = fact(f);
		System.out.println(ans);
	}

	public static long fact(long r){
		if(r>1)
		return r*fact(r-1);
		else
			return 1;
	}	
}