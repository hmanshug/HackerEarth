package he;

import java.util.Scanner;

public class SegmentTreeSamsung {

	static private Scanner sc;
	static private int a[], n, q, fib[];
	static private int[] nodes;
	static final private int MOD = 101;

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	static int fib(int n) {
		long F[][] = new long[][] { { 1, 1 }, { 1, 0 } };
		if (n == 0)
			return 0;
		power(F, n - 1);

		return (int )F[0][0]%MOD;
	}

	static void multiply(long F[][], long M[][]) {
		long x = (F[0][0] * M[0][0])%MOD + (F[0][1] * M[1][0])%MOD;
		long y = (F[0][0] * M[0][1])%MOD + (F[0][1] * M[1][1])%MOD;
		long z = (F[1][0] * M[0][0])%MOD + (F[1][1] * M[1][0])%MOD;
		long w = (F[1][0] * M[0][1])%MOD + (F[1][1] * M[1][1])%MOD;

		F[0][0] = x;
		F[0][1] = y;
		F[1][0] = z;
		F[1][1] = w;
	}
	
	static void power(long F[][], int n) {
		if (n == 0 || n == 1)
			return;
		long M[][] = new long[][] { { 1, 1 }, { 1, 0 } };

		power(F, n / 2);
		multiply(F, F);

		if (n % 2 != 0)
			multiply(F, M);
	}

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		n = sc.nextInt();
		q = sc.nextInt();
		a = new int[n + 1];
		for (int i = 1; i <= n; ++i)
			a[i] = sc.nextInt(); 
		
		while (q-- != 0) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			int ans = gcd(fib(a[p]), fib(a[p + 1]));
			for (int i = p + 2; i <= q; i++) {
				ans = gcd(ans, fib(a[i]));
			}
			System.out.println(ans);
		}
	}

}
