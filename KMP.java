package dummypkg;

import java.util.Scanner;

public class KMP {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		String pat=s.nextLine();
		String text=s.nextLine();
		
		int LPS[]=new int[pat.length()];
		buildLPS(pat, LPS);
		printArray(LPS, pat.length());
	}
	
	public static void printArray(int[] a, int n) {
		for(int i=0; i<n; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static void buildLPS(String pat, int[] LPS) {
		LPS[0]=0;
		int j=0, len=pat.length();
		
		for(int i=1; i<len; i++) {
			if(pat.charAt(i)==pat.charAt(j)) {
				LPS[i]=++j;
			} else {
				while(j!=0 && pat.charAt(i)!=pat.charAt(j)) {
					j=LPS[j-1];
				}
				if(j==0)
					LPS[i]=0;
				else
					LPS[i]=++j;
			}
		}
	}
}
