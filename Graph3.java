package dummypkg;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Graph3 {
static ArrayList<Integer> al[];
static boolean visited[];
static int count=0;
public static void main(String[] args) {
// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int N=sc.nextInt(), M=sc.nextInt();
		al=new ArrayList[N+1];
		visited=new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			int x=sc.nextInt(), y=sc.nextInt();
			if(al[x]==null)
				al[x]=new ArrayList<Integer>();
			if(al[y]==null)
				al[y]=new ArrayList<Integer>();
			if(x!=y) {
				al[x].add(y);
				al[y].add(x);
			} else {
				al[x].add(x);
				al[x].add(x);
			}
		}
		int max = -1;
		for(int i=1; i<=N; i++) {
			if(visited[i]==false) {
				if(max<count) max=count;
				count=0;
				dfs(i);
			}
			if(max<count) max=count;
		}
		System.out.println(max/2);

	}
	public static void dfs(int st) {
		Stack<Integer> s=new Stack<>();
		s.push(st);
		visited[st]=true;
		while(!s.isEmpty()) {
			int r=s.peek();
			s.pop();
			if(al[r]!=null)
			for(int i:al[r]) {
				count++;
				if(visited[i]==false) {
					s.push(i);
				}
			}
		}
	}

}
