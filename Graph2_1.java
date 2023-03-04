package dummypkg;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Graph2_1 {
	
static ArrayList<Integer> al[];
static ArrayList<Integer> al2[];
static int count=0, count1=0;

public static void main(String[] args) {
// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int N=sc.nextInt(), M=sc.nextInt();
		al=new ArrayList[N+1];
		al2=new ArrayList[N+1];
		
		for(int i=0; i<M; i++) {
			int x=sc.nextInt(), y=sc.nextInt();
			if(al[x]==null)
				al[x]=new ArrayList<Integer>();
			if(al2[y]==null)
				al2[y]=new ArrayList<Integer>();
			al[x].add(y);
			al2[y].add(x);
		}
		for(int i=1; i<=N; i++) {
			if(al[i]==null)
				count++;
			if(al2[i]==null)
				count1++;
		}
		if(count>count1)
			System.out.println(count);
		else
			System.out.println(count);

	}
	

}
