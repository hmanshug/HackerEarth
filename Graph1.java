package dummypkg;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;

public class Graph1 {
	static boolean visited[];
	static HashSet<Integer> al[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(), M=sc.nextInt();
		
		al=new HashSet[N+1];
		visited=new boolean[N+1];
		for(int i=0; i<M; i++) {
			int x=sc.nextInt(), y=sc.nextInt();
			if(x!=y) {
				if(al[x]==null)
					al[x]=new HashSet<>();
				if(al[y]==null)
					al[y]=new HashSet<>();
				al[x].add(y);
				al[y].add(x);
			}
		}
		dfs(sc.nextInt());
		int count=0;
		for(int i=1; i<=N; i++) {
			if(visited[i]==false)
				count++;
		}
		System.out.println(count);
		
	}
	public static void dfs(int st) {
		visited[st]=true;
		if(al[st]!=null)
		for(int i:al[st]) {
			if(visited[i]==false) {
				dfs(i);
			}
		}
	}

}
