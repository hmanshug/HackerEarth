package dummy;

import java.util.Scanner;

public class StringInterleave {

	public StringInterleave() {
		// TODO Auto-generated constructor stub
	}
	private static String a,b;
	private static int la,lb,lt;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		
		while(t--!=0) {
			a=s.next(); b=s.next();
			la=a.length(); lb=b.length(); lt=la+lb;
			
			char[] ans=new char[lt];
			int[] fill=new int[lt];
			for(int i=0; i<fill.length; ++i) fill[i]=0;
			Rec(0, fill, ans);
		}
	}
	
	public static void Rec(int cur, int fill[], char ans[]) {
		if(cur==la) {
			for(int i=0, j=0; i<lt; ++i) {
				if(fill[i]==0) {
					ans[i]=b.charAt(j++);
				}
			}
			for(char cc:ans)
			System.out.print(cc);
			System.out.print("\n");
			return;
		}
		int pos = 0;
		for(int i=lt-1; i>=0 && fill[i]==0; i--,pos=i+1);
		for(int i=pos; i+la-cur<=lt; i++) {
			
			fill[i]=1; ans[i]=a.charAt(cur);
			Rec(cur+1,  fill, ans);
			fill[i]=0;
		}
		return;
	}

}
