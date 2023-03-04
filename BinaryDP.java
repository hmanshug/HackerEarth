package he;

import java.util.Scanner;

public class BinaryDP {

	private static Scanner s;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s= new Scanner(System.in);
		int n=s.nextInt();
		int b[]=new int[n+1];
		for(int i=1; i<=n; i++) b[i]=  s.nextInt();
		
		int dp[][]= new int[n+1][n+1];
		for(int i=0; i<n+1; i++)
			for(int j=0; j<n+1; j++)
				dp[i][j]=-1;
		
		int[][] co=new int[n+1][2];
		int count=0;
		for(int i=1; i<=n; i++) {
			for(int j=i; j<=n; j++) {
				if(i==1) {
					dp[i][j]= b[j];
				}
				else {
					dp[i][j]= dp[i-1][j-1]^b[j];
				}
				count+=dp[i][j];
				for(int k=j; k>j-i; k--) {
					co[k][dp[i][j]]++;
				}
			}
		}
		/*
		for(int i=1; i<=n; i++) {
			for(int j=i; j<=n; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		for(int i=1; i<=n; i++) {
			for(int j=0; j<=1; j++) {
				System.out.println(co[i][j]);
			}
		}
		*/
		int max=0;
		for(int i=1; i<=n; i++) {
			if(co[i][0]>co[i][1]) {
				if(max<(co[i][0]-co[i][1])) {
					max=(co[i][0]-co[i][1]);
				}
			}
		}
		System.out.println(count+max);
		
		
	}

}
