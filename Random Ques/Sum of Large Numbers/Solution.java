import java.io.*;

class Solution {
	public static void main(String [] args)throws IOException {
		System.out.println("Enter your two numbers ");
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));

		String a = bs.readLine();
		String b = bs.readLine();

		int l = a.length()>b.length() ? a.length() :b.length();
		int aux = a.length()-b.length();
		if(aux<0)
			aux *=-1;
		for(int i=0;i<aux;i++){
			if(a.length()<b.length())
				a = "0"+a;
			else
				b = "0"+b;
		}

		System.out.println(a+"\n"+b);

		String s = "";

		int carry = 0;

		for(int i = a.length()-1;i>=0;i--){
			int q = Integer.parseInt(a.charAt(i)+"");
			int w = Integer.parseInt(b.charAt(i)+"");

			int sum = q+w+carry;
			String sums = "" + sum;
			if(sums.length()>1){
				s = sums.charAt(1)+s;
				carry = Integer.parseInt(sums.charAt(0)+"");
			}
			else{
				s = sums+s;
				carry = 0;
			}

		}
		if(carry>0){
			s=carry+s;
		}
		System.out.println(s);
	}
}