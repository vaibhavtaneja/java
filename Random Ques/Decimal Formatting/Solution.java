import java.io.*;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bs.readLine());
		while(t-->0){
			double n = Double.parseDouble(bs.readLine());
			double l = 1/n;
			System.out.println("l "+l);
			double g = 1.10 % l; 	
			System.out.println("g "+g);
			//String s = "%1.10f" % l;
			//System.out.println(s);
			System.out.println( String.format( "%.10f", l ) );
		}
	}
}