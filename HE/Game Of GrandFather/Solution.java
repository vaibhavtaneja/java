import java.io.*;

class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bs.readLine());
		StringBuilder sb = new StringBuilder();
		while(t-->0){
			String [] s = bs.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			String [][] arr = new String[n][m];
			for (int i=0;i<n;i++) {
				String [] s1 = bs.readLine().split(" ");
				for (int j=0;j<m ;j++ ) {
					arr[i][j]=s1[j];
				}
			}
			int test = Integer.parseInt(bs.readLine());
			while(test-->0){
				String [] a = bs.readLine().split(" ");
				int x1 = Integer.parseInt(a[0])-1;
				int x2 = Integer.parseInt(a[2])-1;	
				int y1 = Integer.parseInt(a[1])-1;
				int y2 = Integer.parseInt(a[3])-1;
				int kuku=0,ani=0,lisa=0;
				for (int i=x1;i<=x2 ;i++ ) {
					for (int j=y1;j<=y2;j++) {
						if(arr[i][j].equals("r"))
							kuku++;
						else if(arr[i][j].equals("b"))
							ani++;
						else
							lisa++;
					}
				}
				if(ani==lisa&&lisa==kuku){
						sb.append("LISA"+"\n");
				}		
				else if(kuku>ani&&kuku>lisa){
					sb.append("KUKU"+"\n");
				
				}else if(ani>kuku&&ani>lisa){
					sb.append("ANI"+"\n");
						
				}else if (lisa>kuku&&lisa>ani) {
					sb.append("LISA"+"\n");	
				}
				else if(kuku==ani&&kuku>lisa){
					sb.append("ANI"+"\n");
				}else if(ani>kuku&&ani==lisa){
					sb.append("LISA"+"\n");
				}else if (lisa==kuku&&lisa>ani) {
					sb.append("LISA"+"\n");
				}
		}
	}
		System.out.print(sb);
	}		
}