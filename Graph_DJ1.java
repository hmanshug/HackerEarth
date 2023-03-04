package dummy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Graph_DJ1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(), M=sc.nextInt();
		ArrayList<Node> al[]=new ArrayList[N+1];
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
			dist[i]=1000000000;
			vis[i]=false;
		}
		dist[0]=0;
		PriorityQueue<Node> pq=new PriorityQueue<>();
		pq.add(new Node(1, 0));
		while(!pq.isEmpty()) {
			//System.out.println("In: Before- "+pq);
			Iterator<Node> itr=pq.iterator();
			Node n=	itr.next(); itr.remove();
			//System.out.println("In: After- "+pq);
			int x=n.y, w=n.w;
			if(vis[x-1]==true)
				continue;
			vis[x-1]=true;
			//System.out.println("OuterLoop: X- "+x);
			for(Node nn:al[x]) {
				int y=nn.y, w1=nn.w;
				//System.out.println("\tInnerLoop: Node- "+nn);
				if(dist[x-1]+w1<dist[y-1]) {
					dist[y-1]=dist[x-1]+w1;
					pq.add(new Node(y, dist[y-1]));
				}
					
			}
		}
		for(int i=0; i<N; i++)
			System.out.print(dist[i]+ " ");
		
			
	}

}
class Node implements Comparable<Node> {
	Integer y, w;
	Node(int y, int w){
		this.y=y;
		this.w=w;
	}
	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((w == null) ? 0 : w.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (w == null) {
			if (other.w != null)
				return false;
		} else if (!w.equals(other.w))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}
	*/
	@Override
	public int compareTo(Node node) {
		return this.w.compareTo(node.w);
	}
	public String toString(){
		return "Y: "+this.y+"--W: "+this.w;
		
	}
}
