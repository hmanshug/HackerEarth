package he;

import java.util.Scanner;

public class GSS1 {
	
	static private Scanner sc;
	static private int a[], n;
	static private NodeST[] nodes;
	
	public static int getMid(int l, int r) {
		return (int)(l+r)/2;
	}
	public static NodeST combine(NodeST l, NodeST r) {
		int left=l.left;
		if(l.sum+r.left > left) left=l.sum+r.left;
		int right=r.right;
		if(l.right+r.sum>right) right=l.right+r.sum;
		int best=Math.max(Math.max(l.best, r.best), l.right+r.left);
		int sum=l.sum+r.sum;
		return new NodeST(best, right, left, sum);
		
	}
	public static NodeST buildST(int l, int r, int i) {
		if(l==r) {
			nodes[i]=new NodeST(a[l], a[l], a[l], a[l]);
			return nodes[i];
		}
		int mid=getMid(l, r);
		nodes[i]= combine(buildST(l, mid, 2*i+1), buildST(mid+1, r, 2*i+2));
		return nodes[i];
	}
	public static NodeST ans(int l, int r, int a, int b, int i) {
		if(l==a && b==r)
			return nodes[i];
		int mid=getMid(l, r);
		if(b<=mid)
			return ans(l, mid, a, b, 2*i+1);
		if(a>mid+1)
			return ans(mid+1, r, a, b, 2*i+2);
		
		return combine(ans(l, mid, a, mid, 2*i+1), ans(mid+1, r, mid+1, b, 2*i+2));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		n=sc.nextInt();
		a=new int[n+1];
		for(int i=1; i<=n; ++i) a[i]=sc.nextInt();
		nodes=new NodeST[2*n+1]; //2n-1
		buildST(1, n, 0);
		
		int q=sc.nextInt();
		while(q--!=0) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			System.out.println(ans(1, n, a, b, 0).best);
		}
	}

}

class NodeST {
	int best;
	int right;
	int left;
	int sum;
	public NodeST(int best, int right, int left, int sum) {
		this.best = best;
		this.right = right;
		this.left = left;
		this.sum = sum;
	}
	
}