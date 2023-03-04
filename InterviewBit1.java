package dummy;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class InterviewBit1 {

	public static void main(String[] args) {
		
	}
	public int t2Sum(TreeNode A, int B) {
		if(A==null) {
			return 0;
		}
		int val=A.val, want=B-A.val;
		
		if(want<val && rec(A.left, want))
			return 1;
		else if(rec(A.right, want))
			return 1;
		
		if(B<A.val)
			return t2Sum(A.left, B);
		else {
			return (t2Sum(A.left, B) | t2Sum(A.right, B));
		}
		
		
    }
	public boolean rec(TreeNode A, int want) {
		if(A==null) return false;
		if(A.val==want) return true;
		else if(A.val>want) return rec(A.left, want);
		else return rec(A.right, want);
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
    TreeNode cur;
    Stack<TreeNode> st;
    public Solution(TreeNode root) {
        st= new Stack<TreeNode>();
        cur=root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(st.empty() && cur==null) 
        	return false;
        else
        	return true;
    }

    /** @return the next smallest number */
    public int next() {
    	int ans=0;
        if(cur==null) {
        	if(!st.empty()) {
        		TreeNode temp=st.pop();
            	ans=temp.val;
            	cur=temp.right;
            	return ans;
        	} else
        		return -1;
        	
        } else {
        	st.push(cur);
        	cur=cur.left;
        	return next();
        }
    }
}

 class Solution1 {
	 ArrayList<ArrayList<Integer>> all=new ArrayList<ArrayList<Integer>>();
	 public ArrayList<Integer> al;
	 
	 public int fmin(TreeNode A, int dis) {
		 if(A!=null) {
			 return Math.min( fmin(A.left, dis-1), fmin(A.right, dis+1));
		 }
		 else return 0;
	 }
	 
	 public int fmax(TreeNode A, int dis) {
		 if(A!=null) {
			 return Math.max( fmax(A.left, dis-1), fmax(A.right, dis+1));
		 }
		 else return 0;
	 }
	 
	 public void add(TreeNode A, int level, int dis) {
		 Queue<TreeNode> q=new LinkedList;
		 
		 if(A==null) return;
		 q.add(A);
		 while(!q.isEmpty()) {
			 TreeNode temp= q.poll();
			 
		 }
		 if(level==dis) {
			 al.add(A.val);
		 }
		 add(A.left, level, dis-1);
		 add(A.right, level, dis+1);
	 }
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
    	int l=fmin(A, 0);
    	int r=fmax(A,0);
    	
    	for(int i=l; i<=r; i++) {
    		al=new ArrayList<Integer>();
    		add(A, i, 0);
    	}
    	return null;
    }
}

