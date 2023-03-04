package he;

import java.util.Scanner;

public class LCS {

	
	private static Scanner sc;
	private static String str;
	
	public static int doLCS(String a, String b) {
		int m=a.length();
		int n=b.length();
		int[][] memo=new int[m+1][n+1];
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(i==0 || j==0) 
					memo[i][j]=0;
				else if(a.charAt(i-1)==b.charAt(j-1))
					memo[i][j]=1+memo[i-1][j-1];
				else
					memo[i][j]=Math.max(memo[i-1][j], memo[i][j-1]);
				//System.out.print(memo[i][j] + " ");
			}
			//System.out.println();
		}
		
		
		return memo[m][n];
	}
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int q=sc.nextInt();sc.nextLine();
		while(q--!=0) {
			str=sc.nextLine();
			System.out.println(str.length()-doLCS(str, new StringBuilder().append(str).reverse().toString()));
			
		}

	}

}
 