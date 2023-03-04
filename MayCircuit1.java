package he;

import java.util.Scanner;

public class MayCircuit1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),k=sc.nextInt();
		int mem[]=new int[n+1];
		
		for(int i=1; i<=k; ++i) {
			int cg=sc.nextInt();
			for(int j=1; j<=cg; ++j) {
				mem[sc.nextInt()]= i;
			}
		}
		int q=sc.nextInt();
		while(q--!=0) {
			int u=mem[sc.nextInt()],v=mem[sc.nextInt()];
			int ans1=((u<v?u:v)+k)-(u>v?u:v);
			int ans2=Math.abs(u-v);
			System.out.println(Math.min(ans1, ans2));
		}
	}

}
