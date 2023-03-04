package he;

import java.util.Scanner;

/**
 * @author g1
 *
 */
public class Petrol {
	
	private static Scanner  s;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner(System.in);
		int t=s.nextInt();
		
		while(t--!=0) {
			int n=s.nextInt();
			int c[]= new int[n];
			int l[]= new int[n];
			for(int i=0; i<n; ++i) c[i]=s.nextInt();
			for(int i=0; i<n; ++i) l[i]=s.nextInt();
			int min=Integer.MAX_VALUE;
			Long cost=(long) 0;
			for(int i=0; i<n; ++i) {
				if(c[i]<min) {
					min=c[i];
				}
				cost+= Long.valueOf(min)* Long.valueOf(l[i]);
			}
			System.out.println(cost);
		}
	}

}
