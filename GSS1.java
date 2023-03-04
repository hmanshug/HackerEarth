package dummy;

import java.util.Scanner;

public class GSS1 {

	public GSS1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int a[]= new int[n+1];
		for(int i=1; i<=n; ++i) a[i]=s.nextInt();
		int dp[][]= new int[n+1][n+1];
		
		for(int i=1; i<=n; ++i) {
			for(int j=i; j<=n; ++j) {
				dp[i][j]= dp[i][j-1] + a[j];
			}
		}
		int max[][]= new int[n+1][n+1];
		for(int i=1; i<=n; ++i) {
			for(int j=i; j<=n; ++j) {
				//starts
				int mt=Integer.MIN_VALUE;
				for(int k=i; k<=j; ++k) {
					for(int l=k; l<=j; ++l) {
						if(mt<dp[k][l]) mt=dp[k][l];
					}
				}
				max[i][j]= mt;
			}
		}
		int m=s.nextInt();
		while(m-- != 0) {
			int x=s.nextInt();
			int y=s.nextInt();
			
			System.out.println(max[x][y]);
		}
	}

}
