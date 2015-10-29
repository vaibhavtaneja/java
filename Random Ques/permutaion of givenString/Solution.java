import java.io.*;

class Solution {
	public static void main(String[] args) {
		String str = "ABC";
		char [] s = str.toCharArray();
		permute(s,0,str.length()-1);

	}

	public static void permute(char [] str,int l,int r){
		if(l==r)
			System.out.println(new String(str));
		else{
			for (int i=l;i<=r;i++) {
				System.out.println("1. i "+i+" l "+l+" str[i] "+str[i]+" str[l] "+str[l]);
				char temp = str[i];
				str[i]=str[l];
				str[l]=temp;
				permute(str,l+1,r);
				System.out.println("2. i "+i+" l "+l+" str[i] "+str[i]+" str[l] "+str[l]);
				temp = str[i];
				str[i]=str[l];
				str[l]=temp;			
				/*char temp = str.charAt(i);
				str.charAt(i)=str.charAt(l);
				str.charAt(l)=temp;
				permute(str,l+1,r);
				temp = str.charAt(i);
				str.charAt(i)=str.charAt(l);
				str.charAt(l)=temp;			
				//*/
			}
		}	
	}

}