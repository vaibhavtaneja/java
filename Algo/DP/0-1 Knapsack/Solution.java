import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) {
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
		int W =6;
		int [] value = {3,2,4,4};
		int [] weight = {4,3,2,3};

		int max = maxWeight(value,weight,W);

		System.out.println("Max "+max);
	}

	public static int maxWeight(int [] value,int [] weight,int W){
		int [][] array= new int[value.length+1][W+1];

		for (int i=1;i<array.length;i++ ) {
			for (int j=0;j<array[0].length ;j++ ) {
				if(j<weight[i-1]){	
					array[i][j]	= array[i-1][j];
				}else{
					array[i][j]	= max(array[i-1][j],array[i-1][j-weight[i-1]]+value[i-1]);
				}
			}
		}
		return array[array.length-1][array[0].length-1];
	}
	public static int max(int a,int b){
		return (a>b)?a:b;
	}
}