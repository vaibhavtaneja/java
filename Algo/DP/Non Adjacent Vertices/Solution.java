import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bs.readLine());
		Scanner sc = new Scanner(System.in);
		while(t-->0){
			int n = Integer.parseInt(bs.readLine());
			int [] a = new int[n];
			for (int i=0;i<n ;i++)
				a[i] =sc.nextInt();
			int sum = WIS(a);
			System.out.println(sum);
		}
	}

	public static int WIS(int [] a){
		int [] s = new int [a.length+1];
		s[0]=0;	
		s[1]=a[0];
		for (int i=2;i<s.length;i++ ) {
			s[i] = max(s[i-1],s[i-2]+a[i-1]);

		}
		String result = "";

		for (int i=s.length-1;i>1 ;i-- ) {
			if(s[i-1]<s[i-2]+a[i-1]){
				result=result+a[i-1]+" ";
				i--;
			}

		}
		System.out.println(result);

		return s[s.length-1];
	}
	

	public static int max(int a,int b){
		return (a>b)?a:b;
	}
}