package dummypkg;

import java.util.ArrayList;
import java.util.Arrays;

public class InPOST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root= buildTree(new ArrayList<Integer>(Arrays.asList(7, 5, 6, 2, 3, 1, 4)), new ArrayList<Integer>(Arrays.asList(5, 6, 3, 1, 4, 2, 7)));
		printPRE(root);
	
	}
	private static int postIndex;
	
	public static void printPRE(TreeNode root) {
		if(root==null) return;
		System.out.print(root.val);
		printPRE(root.left);
		printPRE(root.right);
	}
	public static TreeNode buildTree(ArrayList<Integer> in, ArrayList<Integer> post) {
		int len=in.size();
	    postIndex=len-1;
	    return build(in, post, 0, len-1);
	}
	public static TreeNode build(ArrayList<Integer> in, ArrayList<Integer> post, int l, int r) {
		if(l>r)
			return null;
		System.out.println(postIndex + " --"+l+"--"+r);
		TreeNode root=new TreeNode(post.get(postIndex));
		postIndex--;
		
		if(l==r) return root;
		
		int index=find_IN(in, l, r, root.val);
		
		root.right=build(in, post, index+1, r);
		root.left=build(in, post, l, index-1);
		
		return root;
		
	}
	public static int find_IN(ArrayList<Integer> in, int l, int r, int val) {
		int i;
		for(i=l; i<=r; i++) {
			if(in.get(i)==val)
				break;
		}
		return i;
	}
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int val) {
			this.val=val;
		}
	}
}

