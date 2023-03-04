package dummy;

import java.util.ArrayList;
import java.util.Scanner;
// PROBLEM OF DAG Strongly Connected component
public class CityTrip {

	private static Scanner s;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s= new Scanner(System.in);
		int n=s.nextInt(), m=s.nextInt();
		ArrayList<Integer> edges[]=new ArrayList[n+1];
		
		for(int i=0; i<m; ++i) {
			int u=s.nextInt();
			int v=s.nextInt();
			if(edges[u]==null) edges[u]=new ArrayList<Integer>();
			edges[u].add(v);
		}
		
	}

}
