package he;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SubString {
	
	//private static Scanner s;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//s= new Scanner(System.in);
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		
		int n=in.nextInt();
		int q=in.nextInt();
		
		ArrayList<Pair> al=new ArrayList<>();
		for(int i=0; i<n; i++) {
			al.add(new Pair(in.nextToken(), i));
			//System.out.println("ii"+al.get(i).s);
		}
		//s.nextLine();
		Collections.sort(al);
		for(int i=0; i<q; ++i) {
			String temp=in.nextToken();
			int x=-1,y=-1;
			for(Pair p:al) {
				if(p.s.contains(temp)) {
					x=p.pos;
					break;
				}
			}
			for(int j=al.size()-1; j>=0; j--) {
				if(al.get(j).s.contains(temp)) {
					y=al.get(j).pos;
					break;
				}
			}
			System.out.println(x+" "+y);
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

class Pair implements Comparable<Pair>{
	String s;
	Integer pos;

	public Pair(String s, int pos) {
		super();
		this.s = s;
		this.pos = pos;
	}

	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		if(this.s.equals(o.s)) {
			return this.pos.compareTo(o.pos);
		} else
			return this.s.compareTo(o.s);
	}
}