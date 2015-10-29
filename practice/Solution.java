import java.io.*;

class Solution {
	public static void main(String[] args)throws IOException {
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bs.readLine());
		while(t-->0){
			///System.out.println("bef read");
			String [] s = bs.readLine().split(" ");
			int [] a = new int [4];
			a[0] = Integer.parseInt(s[0]);
			a[1] = Integer.parseInt(s[1]);
			a[2] = Integer.parseInt(s[2]);
			a[3] = Integer.parseInt(s[3]);
			int n = Integer.parseInt(s[4]);
			//System.out.println("bef n");
			while(n-->0){
				//System.out.println("in n");
				int sum = Integer.parseInt(bs.readLine());
				if(check(a,sum))
					System.out.println("1");
				else
					System.out.println("0");
			}
		}
	}

	public static boolean check(int [] arr,int sum){
		//System.out.println("in chk");
		for (int i=0;i<=arr[0]; i++) {
			for (int j=0;j<=arr[1]; j++) {
				for (int k=0;k<=arr[2]; k++) {
					for (int l=0;l<=arr[3]; l++) {
						int s = i*3+j*7+k*11+l*16;
						//System.out.println("s "+s);
						if (s==sum) {
							//System.out.println("out chk ");
							return true;
						}
					}
				}		
			}		
		}
		//System.out.println("out chk ");
		return false;
	}
}