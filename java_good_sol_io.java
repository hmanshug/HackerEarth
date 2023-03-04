import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
 
public class PP2 {
	static double eps = (double) 1e-6;
 
	public static void main(String[] args) throws FileNotFoundException {
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		// InputReader in = new InputReader(new FileInputStream("in.txt"));
		// PrintWriter out = new PrintWriter(new FileOutputStream("out.txt"));
 
		int t = in.nextInt();
 
		for (int ww = 1; ww <= t; ww++) {
 
			int n = in.nextInt();
			int m = in.nextInt();
			long c[] = new long[n];
			Pair p[] = new Pair[n];
			long w[] = new long[n];
			long l[] = new long[m];
			for (int i = 0; i < m; i++) {
				l[i] = in.nextLong();
 
			}
 
			for (int i = 0; i < n; i++) {
				w[i] = in.nextLong();
 
			}
			long ans = 0;
			for (int i = 0; i < n; i++) {
				c[i] = in.nextLong();
				ans = ans + c[i];
			}
			for (int i = 0; i < n; i++) {
				p[i] = new Pair(w[i], c[i], i);
			}
 
			Arrays.sort(l);
			Arrays.sort(p);
 
			if (p[n - 1].w > l[m - 1]) {
				out.println("-1");
				continue;
			}
 
			long low = 0;
			long high = ans;
			while (low <= high) {
				long mid = (low + high) / 2;
				int cc = check(mid, n, m, p, l);
				if (cc == 1) {
					high = mid - 1;
					ans = mid;
				} else {
					low = mid + 1;
				}
 
			}
 
			out.println(ans);
 
		}
 
		out.close();
	}
 
	private static int check(long mid, int n, int m, Pair p[], long l[]) {
 
		long tt = 0;
		int i = m - 1;
		long rem = 0;
 
		int j = n - 1;
 
		rem = p[j].c;
 
		while (i >= 0) {
 
			if (p[j].w <= l[i]) {
				if (tt + rem <= mid) {
					tt = tt + rem;
					j--;
					if (j == -1)
						return 1;
					rem = p[j].c;
				} else {
					rem = rem - (mid - tt);
					i--;
					tt = 0;
 
					if (i < 0)
						return -1;
				}
 
			} else {
				return -1;
 
			}
		}
		return -1;
	}
 
	static class Pair implements Comparable<Pair> {
		long w;
		long c;
		int i;
 
		Pair(long rr, long hh, int ii) {
			w = rr;
			c = hh;
			i = ii;
		}
 
		@Override
		public int compareTo(Pair edge) {
			if (this.w != edge.w) {
				return Long.compare(this.w, edge.w);
			} else {
				return Long.compare(this.c, edge.c);
 
			}
		}
 
	}
 
	static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
 
		public InputReader(InputStream stream) {
			this.stream = stream;
		}
 
		public static boolean isWhitespace(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
 
		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}
 
		public int nextInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
 
		public long nextLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
 
		public String nextToken() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}
 
		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return isWhitespace(c);
		}
 
		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
 
	}
}