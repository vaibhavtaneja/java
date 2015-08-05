import java.io.*;
class LargeFact{
	private int [] a;
	private int n;
	private int s;

	public LargeFact(int num){
		n = num;
		a = new int [400];
		s=1;
		a[0]=1;
	}

	public void cal(){
		for (int i=1;i<=n ;i++) {
			int carry =0;
			for (int j=0;j<s ;j++ ) {
				int p = a[j]*i+carry;
				int pos = p%10;
				carry = p/10;
				//System.out.println(pos+" "+carry);
				
				a[j]=pos;			
			}
			while(carry!=0){
				//System.out.println("carry is  "+carry);
				a[s]=carry%10;
				carry = carry/10;
				s++;
			}	
		}
	}

	public void print(){
		System.out.print("Fact of " + n + "is : ");	
		for (int i=s-1;i>=0;i--) {
			System.out.print(a[i]);
		}
	}

}

class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter no : ");
		int f = Integer.parseInt(bs.readLine());
		

		LargeFact lf = new LargeFact(f);
		lf.cal();
		lf.print();
	}
}