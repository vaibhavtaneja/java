import java.io.*;

class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bs.readLine());
		while(t-->0){
			int n = Integer.parseInt(bs.readLine());
			String [] s = bs.readLine().split(" ");
			if(n<1){
				sb.append("DANGER"+"\n");
			}
			else{
				long [] arr = new long[s.length];
				for (int i=0;i<arr.length ;i++ ) {
					arr[i] = Long.parseLong(s[i]);
				}
				long max = findMax(arr,arr[0],0);
				sb.append(max+"\n");
			}


		}
		System.out.print(sb);
	}
	public static long findMax(long [] arr,long i,long e){
		long e_n;
		for (int k=1;k<arr.length ;k++ ) {
			if(i>e){
				e_n=i;
			}else{
				e_n=e;
			}

			i=e+arr[k];
			e=e_n;
		}
		return ((i>e)?i:e);
	}
}