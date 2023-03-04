package dummy;


import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class PaintTheHouse {
	static Scanner sc;
	static PrintStream out;
	
	public static void init(){
		sc= new Scanner(System.in);
		out= new PrintStream(System.out);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		int N;long D;
		N= sc.nextInt();
		D= sc.nextLong();
		Node[] nodes= new Node[N];
		for(int i=0; i<N; i++) {
			nodes[i]= new Node(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(nodes);
		//out.println(nodes[0]+ " "+ nodes[1]+" "+nodes[2]);
		long tcost=0,workCompleted=0;
		int cur=0, max=-1;
		for(int i=0; i<nodes.length; i++) {
			if(i==0) {
				tcost=nodes[i].x;
				cur=i;
				max=nodes[i].y;
				workCompleted=0;
			} else {
				if((nodes[i].t - nodes[cur].t)*nodes[cur].y + workCompleted + max>= D) {
					//work completed
					break;
				} else {
					if(max<nodes[i].y) max=nodes[i].y;
					if(nodes[cur].y < nodes[i].y) {
						//update new worker
						tcost+=nodes[i].x;
						workCompleted += (nodes[i].t - nodes[cur].t)*nodes[cur].y;
						cur=i;
					}
				}
			}
		}
		out.println(tcost);
	}
}
