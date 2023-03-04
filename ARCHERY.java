package he;

import java.util.Scanner;

public class ARCHERY {
	private static Scanner  s;
	public static Long gcd(Long a, Long b)
	{
	    if (b==0)
	        return a;	
	    return gcd(b, a%b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		s=new Scanner(System.in);
		Long t=s.nextLong();
		while(t!=0) {
			t--;
			Long n=s.nextLong();
			
			Long ans=s.nextLong();
			for(Long i=(long) 1; i<n; ++i) {
				Long temp=s.nextLong();
				ans= (ans*temp)/gcd(temp,ans);
			}
			System.out.println(ans);
			
		}
		
	}

}
