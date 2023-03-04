package he;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Graph_DJ1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(), M=sc.nextInt();
		ArrayList<Node> al[]=new ArrayList[N];
		for(int i=0; i<M; i++) {
			int x=sc.nextInt(), y=sc.nextInt(), w=sc.nextInt();
			if(al[x]==null)
				al[x]=new ArrayList<>();
			if(al[y]==null)
				al[y]=new ArrayList<>();
			al[x].add(new Node(y, w));
			al[y].add(new Node(x, w));
		}
		int dist[]=new int[N];
		Boolean vis[]=new Boolean[N];
		for(int i=0; i<N; i++) {
			dist[i]=Integer.MAX_VALUE;
			vis[i]=false;
		}
		HashSet<Node> pq=new HashSet<>();
		pq.add(new Node(1, 0));
		while(!pq.isEmpty()) {
			Node n=pq.iterator().next();
			int x=n.y, w=n.w;
			if(vis[x]==true)
				continue;
			for(Node nn:al[x]) {
				if(dist[x]+w<dist[nn.y]) {
					dist[nn.y]=dist[x]+w;
					pq.add(new Node(nn.y, dist[nn.y]));
				}
					
			}
		}
			
	}

}
class Node implements Comparable<Node>{
	int y, w;
	Node(int y, int w){
		this.y=y;
		this.w=w;
	}
	@Override
	public int compareTo(Node node) {
		
		return node.w < this.w? 1:-1;
	}
}
