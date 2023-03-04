package he;

import java.util.Scanner;

public class GCDARRAY {
	private static Scanner s;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner(System.in);
		int n=s.nextInt();
		int a[]=new int[n];
		for(int i=0; i<n; i++) a[i]=s.nextInt();
		
		for(int i=0; i<n; i++) {
			if(i==0)
				System.out.print(-1+" ");
			else if(checkPrime(a[i]))
				System.out.print(i+" ");
			else {
				int maxi=0, max=0;
				for(int j=i-1; j>=0; j--) {
					int cur=gcd(a[i], a[j]);
					if(max<cur) {
						max=cur;
						maxi=j;
					}
				}
				System.out.print(maxi+1+" ");
			}
		}
		System.out.println();
		
	}
	public static boolean checkPrime(int a) {
		for(int i=2; i<=Math.sqrt(a); i++) {
			if(a%i==0) return false;
		}
		return true;
	}
	public static int gcd(int a, int b) {
		if(b==0) return a;
		return gcd(b, a%b);
	}

}
