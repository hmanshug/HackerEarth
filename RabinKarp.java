/**
 * 
 */
package he;

import java.util.Scanner;

/**
 * @author hgarg007
 *
 */
public class RabinKarp {

	private static Scanner sc;
	private static final int MOD = 101;
	private static final int CHARS = 256;
	
	private static int power(int an, int k) {
		long ans=1;
		long a=(long) an;
		while(k!=0) {
			if(k%2==1)
				ans=(ans*a)%MOD;
			
			k/=2;
			a=(a*a)%MOD;
		}
		return (int)ans;
	}
	public static void doPrint(String pat, String text) {
		int m=pat.length(), n=text.length();
		int hm=0, ht=0;
		int powm= power(CHARS, m-1);
		
		for(int i=m-1, j=0; i>=0; i--, j++) {
			hm= (hm+power(CHARS, i)*(pat.charAt(j)))%MOD;
			ht= (ht+power(CHARS, i)*(text.charAt(j)))%MOD;
		}
		for(int i=0; i<=n-m; i++) {
			if(hm==ht) {
				for(int j=i; j<i+m; j++) {
					if(pat.charAt(j-i)!=text.charAt(j))
						break;
					if(j==i+m-1) {
						System.out.println(i);
					}
				}
			}
			
			if(i<n-m) {
				ht = (((ht - (powm * ((int) text.charAt(i) )))*CHARS) + (int ) text.charAt(i+m)) % MOD;
				if(ht<0) ht+=MOD;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc= new Scanner(System.in);
		
		while(sc.hasNextLine()) {
			sc.nextLine();
			String p=sc.nextLine(), t=sc.nextLine();
			if(p.length()<=t.length())
				doPrint(p,t);
			System.out.println(); 
		}
	}

}
