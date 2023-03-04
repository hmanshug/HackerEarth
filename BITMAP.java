package he;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BITMAP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int test=s.nextInt();
		
		while(test--!=0) {
			int m=s.nextInt(), n=s.nextInt();
			s.nextLine();
			int mat[][]= new  int[m][n];
			ArrayList<Node1> list=new ArrayList<>();
			int[][] dist=new int[m][n];
			for(int i=0; i<m; ++i) {
				String tstr=s.nextLine();
				for(int j=0; j<n; ++j) {
					mat[i][j]=tstr.charAt(j)-48;
					dist[i][j]=Integer.MAX_VALUE;
					if(mat[i][j]==1) {
						dist[i][j]=0;
						list.add(new Node1(i,j));
					}
				}
			}
			for(Node1 no:list)
				bfs(no, dist, mat, m, n);
			
			for(int i=0; i<m; ++i) {
				for(int j=0; j<n; ++j) {
					System.out.print(dist[i][j] + " ");
				}
				System.out.println();
			}
			
					
			
					
		}
	}
	public static void bfs(Node1 no, int[][] dist, int[][] mat, int m, int n) {
		Queue<Node1> q=new LinkedList<>();
		q.add(no);
		
		while(!q.isEmpty()) {
			Node1 nn=q.poll();
			int u=nn.x, v=nn.y;
			
			if(u-1>=0 && dist[u][v]+1<dist[u-1][v]) {
				dist[u-1][v]= dist[u][v]+1;
				q.add(new Node1(u-1, v));
			}
			if(u+1<m && dist[u][v]+1<dist[u+1][v]) {
				dist[u+1][v]= dist[u][v]+1;
				q.add(new Node1(u+1, v));
			}
			if(v-1>=0 && dist[u][v]+1<dist[u][v-1]) {
				dist[u][v-1]= dist[u][v]+1;
				q.add(new Node1(u, v-1));
			}
			if(v+1<n && dist[u][v]+1<dist[u][v+1]) {
				dist[u][v+1]= dist[u][v]+1;
				q.add(new Node1(u, v+1));
			}
				
		}
	}

}
class Node1 {
	int x;
	int y;
	public Node1(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}