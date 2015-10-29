
public class Solution {

	public static double sqrt(int number) {
		double t,l;
	 
		double squareRoot = number / 2;
	 	System.out.println("sqrt= "+squareRoot);
		do {
			t = squareRoot;
			l = number / t;
			squareRoot = (t + l) / 2;
			System.out.println("t= "+t+" l "+l+" sqrt= "+squareRoot);
		} while ((t - squareRoot) != 0);
	 
		return squareRoot;
	}	

	public static void main(String[] args) {
		System.out.println(sqrt(9));
		System.out.println(sqrt(13));
	}
}