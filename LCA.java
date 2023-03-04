package dummypkg;

import java.util.ArrayList;

public class LCA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		root.left.right.left=new TreeNode(6);
		
		System.out.print(lca(root, 6, 6));
	}
	public static int lca(TreeNode a, int x, int y) {
    	ArrayList<Integer> alx=new ArrayList<>();
    	ArrayList<Integer> aly=new ArrayList<>();
	
    	fun( a,  x, alx);
    	fun( a,  y, aly);
    	int i, min=Math.min(alx.size(), aly.size());
    	
    	for(i=0; i<min; i++) {
    		if(alx.get(i)!=aly.get(i))
    			break;
    	}
    	if(i==0)
    	    return -1;
    	 else
    	return (alx.size()<aly.size())?alx.get(i-1):aly.get(i-1);
    	
	}

	public static boolean fun(TreeNode a, int x, ArrayList<Integer> al) {
		if(a==null) return false;
		al.add(a.val);
		boolean resA=false, resB=false;
		if(a.val==x) return true;
		
		if(a.left!=null) {
			resA=fun(a.left, x, al);
		}
		
		if(a.right!=null && !resA) {
			resB= fun(a.right, x, al);
		}
		if(resA||resB) {
			return true;
		} else {
			al.remove(al.size()-1);
			return false;
		}
		
	}
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}

 

