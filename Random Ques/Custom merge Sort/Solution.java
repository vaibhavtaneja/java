import java.io.*;

class Solution{
	public static void main(String[] args) throws IOException{
		String [] arr = {"1", "34", "3", "98", "9", "76", "45", "4"};
		mergeSort(arr,0,arr.length-1);

		for (String s: arr ) {
			System.out.print(s);
		}
	}
	public static void mergeSort(String [] arr,int low,int high){
		if(low<high){
		int mid = (low+high)/2;
		mergeSort(arr,low,mid);	
		mergeSort(arr,mid+1,high);
		merge(arr,low,mid,high);
		}
	}
	public static void merge(String [] arr,int low,int mid,int high){
		String [] temp = new String[high+1];
		int i = low;
		int j = mid+1;
		int k = 0;
		
		while(i<=mid&&j<=high){
			int a = Integer.parseInt(arr[i]+arr[j]);
			int b = Integer.parseInt(arr[j]+arr[i]);
			if(a<b)
				temp[k++]=arr[j++];
			else
				temp[k++]=arr[i++];
		}

		if(i>mid)
			for (int t = j;t<=high ;t++) {
				temp[k++]=arr[t];
			}
		else
			for (int t = i;t<=mid ;t++) {
				temp[k++]=arr[t];
			}
		int r=0;
		for (int l=low;l<=high;l++ ) {
			arr[l]=temp[r++];
		}
	}

}
