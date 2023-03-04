package he;

import java.util.Scanner;

public class GraphSamsung {

	static private Scanner sc;
	static boolean prime[];
	static int[][] data;
	static int m, n, count;
	static boolean[][] vis;
	
	static void sieve(int n) {
		prime = new boolean[n + 1];
		for (int i = 0; i < n; i++)
			prime[i] = true;

		for (int p = 2; p * p <= n; p++) {
			if (prime[p] == true) {
				for (int i = p * 2; i <= n; i += p)
					prime[i] = false;
			}
		}
	}
	static boolean rec(int x, int y) {
		if(x==m && y==n) {
			vis[x][y]=true;
			return true;
		}
		if(x>m || y>n) return false;
		vis[x][y]=true;
		
		if(x<m && y<n && prime[data[x+1][y+1]] && rec(x+1, y+1)){
			return true;
		}
		if(x<m && prime[data[x+1][y]] && rec(x+1, y)){
			return true;
		}
		if(y<n && prime[data[x][y+1]] && rec(x, y+1)){
			return true;
		}
		vis[x][y]=false;
		return false;
	}
	static void rec1(int x, int y) {
		if(x==m && y==n) {
			count++;
		}
		if(x>m || y>n) return;
		
		if(x<m && y<n && prime[data[x+1][y+1]]){
			rec(x+1, y+1);
		}
		if(x<m && prime[data[x+1][y]]){
			rec(x+1, y);
		}
		if(y<n && prime[data[x][y+1]]){
			rec(x, y+1);
		}
	}
	static void printRec(int x, int y) {
		if(x==m && y==n) {
			System.out.println(x+" "+y);
			return;
		}
		System.out.println(x+" "+y);
		if(x<m && y<n && vis[x+1][y+1]==true) {
			 printRec(x+1, y+1);
			 return;
		}
		if(y<n && vis[x][y+1]==true) {
			 printRec(x, y+1);
			 return;
		}
		if(x<m && vis[x+1][y]==true) {
			 printRec(x+1, y);
			 return;
		}
			 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		m = sc.nextInt(); n = sc.nextInt();
		data = new int[m + 1][n + 1];
		vis = new boolean[m + 1][n + 1];
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++) {
				data[i][j] = sc.nextInt();
				vis[i][j]=false;
			}
		sieve(100000);
		if(rec(1,1)==true) {
			count=0;
			rec1(1,1);
			System.out.println(count);
			printRec(1, 1);
		}
		else {
			System.out.println(0);
		}
		
		

	}

}
