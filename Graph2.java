package dummy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Graph2 {
	static boolean visited[];
	static int val[];
	static ArrayList<Node> al[];
	static Scanner sc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		int N=sc.nextInt(), M=sc.nextInt(), K=sc.nextInt();
		val= new int[N+1];
		for(int i=1; i<=N; i++) val[i]=sc.nextInt();
		al=new ArrayList[N+1];
		
		for(int i=0; i<M; i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			if(al[x]==null)
				al[x]=new ArrayList<Node>();
			if(al[y]==null)
				al[y]=new ArrayList<Node>();
			if(x!=y) {
				al[x].add(new Node(val[y], y));
				al[y].add(new Node(val[x], x));
			} else {
				al[x].add(new Node(val[y], y));
			}
			
		}
		
		for(int i=1; i<=N; i++) {
		    if(al[i]!=null) {
		        Collections.sort(al[i]);
    			if(al[i].size()-K>=0)
    				System.out.println((al[i].get(K-1)).index);
    			else
    				System.out.println(-1);
		    } else
    				System.out.println(-1);
		}	
	}
}

class Node implements Comparable<Node>{ 
	Integer val; 
	Integer index;
	public Node(int val, int index){
		this.val=val;
		this.index=index;
	}
	@Override
	public int compareTo(Node node) {
		// TODO Auto-generated method stub
		if(this.val!=node.val)
			return node.val.compareTo(this.val);
		else
			return node.index.compareTo(this.index);
	}
	
}

