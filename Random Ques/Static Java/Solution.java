import java.io.*;

class app{
	int a1;
	
	public static int count(){
		final int c = 0;	

		if(c==0){
			System.out.println("c val"+c);
			c++;
			count();
		}
		else if(c==1){
			System.out.println("2c val"+c);
			c++;
			count();	
		}	
		else if(c==2){
			System.out.println("3c val"+c);
			c++;
			count();	
		}	
		else if(c==3){
			System.out.println("3c val"+c);
			c++;	
		}
		return c;	
	}
}

class Solution{
	public static void main(String[] args) {
		app a1 = new app();
		a1.count();
	}
}