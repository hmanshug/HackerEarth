package he;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class ABLAZE {

	private static final int MOD=1000000007;
	private static Scanner s;
	static LinkedList<Integer>[] ll;
	static boolean[] visited;
	static int[] E;
	static int MIN=Integer.MAX_VALUE;
	static int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner(System.in);
		int n=s.nextInt();
		E=new int[n];
		for(int i=0; i<n; ++i) E[i]=s.nextInt();
		int e=s.nextInt();
		ll=new LinkedList[n];
		for(int i=0; i<e; ++i) {
			
			int u=s.nextInt()-1;
			int v=s.nextInt()-1;
			if(ll[u]==null)
				ll[u]=new LinkedList<>();
			if(ll[v]==null)
				ll[v]=new LinkedList<>();
			ll[u].add(v);
			ll[v].add(u);
			
		}
		visited=new boolean[n];
		for(int i=0; i<n; ++i) {
			visited[i]=false;
		}
		int ans=1;
		for(int i=0; i<n; ++i) {
			if(!visited[i]) {
				count=0;
				MIN=Integer.MAX_VALUE;
				dfs(i);
				ans=(ans*count)%MOD;
			}
		}
		System.out.println(ans);
	}
	
	public static void dfs(int u) {
		if(E[u]<MIN) {
			MIN=E[u];
			count=1;
		}
		else if(E[u]==MIN) count++;
		visited[u]=true;
		if(ll[u]!=null) {
			Iterator<Integer> i=ll[u].iterator();
			while(i.hasNext()) {
				int v=i.next();
				if(!visited[v]) dfs(v);
			}
		}
		
		
		
	}

}
