package he;

import java.util.Scanner;

public class JUSTADD {

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
	public static long calc(long n, long k) {
		long ans=0;
		for(long i=1; i<=n; i++) {
			ans= (ans+sqr(i, i))%MOD;
		}
		return ans%MOD;
	}
	public static long calc1(long n, long k) {
		long ans=0;
		for(long i=1; i<=n; i++) {
			ans= (ans+sqr(i, k))%MOD;
		}
		return ans%MOD;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		//System.out.prlongln(sqr(2,10));
		while(true) {
			long n=s.nextLong();
			long k=s.nextLong();
			if(n==0 && k==0) break;
			long ans1=(calc1(n,k)+calc(n,k))%MOD;
			long ans2=ans1-(sqr(n,k)+sqr(n,n))%MOD;
			long ans3=ans2-(sqr(n-1,k)+sqr(n-1, n-1))%MOD;
			long ans= (ans1+ans2-ans3)%MOD;
			
			
			System.out.println(ans);
		}
		
		
	}

}
