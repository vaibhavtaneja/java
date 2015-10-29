import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws IOException{
		System.out.println("Enter the 2 strings");
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();

		System.out.println("Strings are "+s1+" "+s2);
		
		s1=s1.toLowerCase();
		s2=s2.toLowerCase();

		System.out.println("Strings are "+s1+" "+s2);

		int [] arr = new int[26];

		for (int i=0;i<s2.length();i++ ) {
			arr[s2.charAt(i)-'a']++;
		}

		for (int i=0;i<s1.length() ;i++ ) {
			arr[s1.charAt(i)-'a']--;
		}

		boolean flag =false;
		for (int i=0;i<26 ;i++ ) {
			if(arr[i]>0){
				flag = true;
			}
		}

		if(flag)
			System.out.println("Not anagram");
		else
			System.out.println("Anagram");
	}
}