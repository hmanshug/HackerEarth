package dummy;

import java.util.Scanner;

public class ZSUM {

	private static final long MOD=10000007;
	
	public static long sqr(long n, long k) {
		long ans=1;
		while(k!=0) {
			if(k%2==1)
				ans=(ans%MOD*n%MOD)%MOD;
			n=(n*n)%MOD;
			k=k/2;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		//System.out.prlongln(sqr(2,10));
		while(true) {
			long n=s.nextLong();
			long k=s.nextLong();
			if(n==0 && k==0) break;
			long ans= (((sqr(n,n) + sqr(n,k))%MOD + (2*sqr(n-1, n-1))%MOD)%MOD + (2*sqr(n-1, k))%MOD)%MOD;
			System.out.println(ans);
			
		}
		s.close();
		
	}

}
