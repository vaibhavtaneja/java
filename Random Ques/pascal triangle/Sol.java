import java.io.*;
import java.util.*;

class Sol {
	public static void main(String[] args) throws IOException{
		BufferedReader bs  = new BufferedReader(new InputStreamReader(System.in));
		int t =Integer.parseInt(bs.readLine());
		ArrayList<Integer> al = new ArrayList<Integer>();
		if (t==1) {
			al.add(1);
			System.out.println("1");
		}else if (t==2) {
			al.add(1);
			System.out.println("1"+"\n"+"11");
		}else{
			al.add(1);
			al.add(1);
			for (int i=3;i<=t; i++ ) {
				al.add(1);
				for (int j=i-2;j>0;--j) {
					al.set(j,al.get(j)+al.get(j-1));
				}
				Integer [] arr = {};
				arr = al.toArray(arr);

				for (int k=0;k<arr.length ;k++ ) {
					System.out.print(arr[k]+" ");
				}
				System.out.println();
				for (int val : al ) {
					System.out.print(val+" ");
				}
				System.out.println();	
			}
		}


		/*
		String s = "11";
		if (t==1) {
			System.out.println("1");
		}else if (t==2) {
			System.out.println("1"+"\n"+s);
		}
		else{
			System.out.println("1"+"\n"+s);
			for (int i=3;i<=t;i++) {
				String s1="1";	
				for (int j=0;j<s.length()-1;j++) {
					int k = Integer.parseInt(s.charAt(j)+"")+Integer.parseInt(s.charAt(j+1)+"");
					s1+=k;
				}
				s1+="1";
				s=s1;
				System.out.println(s);
			}			
		}
		//*/
	}
}