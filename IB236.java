package dummy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class IB236 {

	public IB236() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IB236 ii=new IB236();
		ArrayList<ArrayList<Integer>> al= new ArrayList<>();
		ArrayList<Integer> frow= new ArrayList<>(Arrays.asList(1, 2, 3));
		ArrayList<Integer> srow= new ArrayList<>(Arrays.asList(4,5,6));
		ArrayList<Integer> trow= new ArrayList<>(Arrays.asList(7,8,9));
		al.add(frow);
		al.add(srow);
		al.add(trow);
		
		//System.out.println(spiralOrder(al));
		/*ArrayList al= new ArrayList<>();
		ArrayList frow= new ArrayList<>(Arrays.asList(0,0));
		ArrayList srow= new ArrayList<>(Arrays.asList(1,1));
		
		al.add(frow);
		al.add(srow);
		setZeroes(al);
		System.out.println(al);*/
		TreeLinkNode A=new TreeLinkNode(1);
		A.left=new TreeLinkNode(2);
		A.right=new TreeLinkNode(3);
		A.left.left=new TreeLinkNode(4);
		A.left.right=new TreeLinkNode(5);
		//A.right.left=new TreeLinkNode(6);
		A.right.right=new TreeLinkNode(7);
		A.left.left.left=new TreeLinkNode(8);
		ii.connect(A);
		System.out.println(A.left.next.val);
		System.out.println(A.left.left.next.val);
		System.out.println(A.left.right.next.val);
		//System.out.println(A.right.left.next.val);
		
	}
	public ArrayList<Interval> insert(ArrayList<Interval> exist, Interval newInterval) {
		ArrayList<Interval> ans= new ArrayList<>();
		int len=exist.size();
		boolean alreadyAdded= false;
		
		if(exist.size()==0) {
			ans.add(newInterval);
			return ans;
		}
		
		for(int i=0; i<len; i++) {
			Interval current=exist.get(i);
			if(checkOverlap(current, newInterval)) {
				newInterval.start= Math.min(current.start, newInterval.start);
				newInterval.end= Math.max(current.end, newInterval.end);
				
			} else {
				if(alreadyAdded) {
					ans.add(exist.get(i));
				} else {
					if(newInterval.end<current.start) {
						ans.add(newInterval);
						alreadyAdded=true;
					}
					ans.add(current);
				}
			}
		}
		if(alreadyAdded==false)
			ans.add(newInterval);
		
		return ans;
	}
	
	public boolean checkOverlap(Interval a, Interval b) {
		if(Math.max(a.start, b.start)>Math.min(a.end, b.end))
			return false;
		else
			return true;
	}
	public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> al) {
		 ArrayList<Integer> res = new ArrayList<Integer>();
		 // Populate result;
		 
		 int m=al.size(), n=al.get(0).size();
		 int a=0, c=n-1, d=m-1;
		 while(true) {
			 if(a>c) break;
			 for(int i=a, j=a; j<=c; j++) {
			     res.add(al.get(i).get(j));
			 }
			 if(a+1>d) break;
			 for(int i=a+1, j=c; i<=d; i++) {
				 res.add(al.get(i).get(j));
			 }
			 if(c-1<a) break;
			 for(int i=d, j=c-1; j>=a; j--) {
				 res.add(al.get(i).get(j));
			 }
			 if(d-1<a+1) break;
			 for(int i=d-1, j=a; i>=a+1; i--) {
				 res.add(al.get(i).get(j));
			 }
			 a++;c--;d--;
		 }
		 
		 return res;
	}
	public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
	    int m=a.size(), n=a.get(0).size();
	    /*
	    boolean[] row= new boolean[m];
	    boolean[] col= new boolean[n];
	    
	    for(int i=0; i<m; i++) row[i]=false;
	    for(int i=0; i<n; i++) col[i]=false;
	    */
	    boolean flr=false, flc=false;
 	    for(int i=0; i<m; i++) {
	        for(int j=0; j<n; j++) {
	            if(a.get(i).get(j)==0) {
	            	if(i==0 && j==0) {
	            		flr=true;flc=true;
	            	} else if(i==0) {
	            		flr=true;
	            	} else if(j==0) {
	            		flc=true;
	            	} 
	            		if(i!=0)
	            		a.get(i).set(0, -1);
	            		if(j!=0)
		                a.get(0).set(j, -2);
	            	
	                 
	            }
	        }
	    }
 	    //System.out.println(a);
	    for(int i=0; i<m; i++) {
	        for(int j=0; j<n; j++) {
	            if((a.get(i).get(0)==-1 || a.get(0).get(j)==-2) && (a.get(i).get(j) !=-1 && a.get(i).get(j)!= -2)) {
	                a.get(i).set(j, 0);
	            }
	        }
	    }
	    //System.out.println(a);
	   for(int i=0; i<m; i++) {
	       if(a.get(i).get(0)==-1 || flc==true)
	         a.get(i).set(0, 0);
	   }
	   //System.out.println(a);
	   for(int i=0; i<n; i++) {
	       if(a.get(0).get(i)==-2 || flr==true)
	         a.get(0).set(i, 0);
	   }
	   //System.out.println(a);
	}
	
	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
	    int m=a.size(), n=a.get(0).size();
	    
	    int i=0, j=m-1;
	    while(i<=j) {
	        int mid=(i+j)/2;
	        int left=a.get(mid).get(0), right=a.get(mid).get(n-1);
	        if(b>=left && b<=right) {
	             return search(a.get(mid), b);
	        } else if(b>right) {
	            i=mid+1;
	        } else {
	            j=mid-1;
	        }
	     }
	    return 0;
	}
	public static int search(ArrayList<Integer> a, int b) {
	    int i=0, j=a.size()-1;
	    
	    while(i<=j) {
	       int mid=(i+j)/2;
	       if(a.get(mid)==b)
	            return 1;
	       else if(a.get(mid)>b) {
	           j=mid-1;
	       } else {
	           i=mid+1;
	       }
	    }
	    return 0;
	}
	public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int m=A.size(), n=A.get(0).size();
        int k=(m*n)/2;
        int i=0, j=Integer.MAX_VALUE;
        while(i<=j) {
        	int mid=(i+j)/2;
        	int tcount=0;
        	for(int p=0; p<m; p++) {
        		tcount+=count(A.get(p), mid);
        	}
        	if(tcount==k) {
        		// ans>=k
        		for(int p=0; p<m; p++) {
            		replace(A.get(p), tcount);
            	}
        		int ans=A.get(0).get(0);
        		for(int p=1; p<m; p++) {
            		if(ans>A.get(p).get(0) && A.get(p).get(0)>=tcount)
            			ans=A.get(p).get(0);
            	}
        		return ans;
        	} else if(tcount>k) {
        		j=mid-1;
        	} else {
        		i=mid+1;
        	}
        }
        return 0;
    }
    public static void replace(ArrayList<Integer> a, int d)  {
    	int i=0, j=a.size()-1;
    	
    	while(i<=j) {
    		 int mid=(i+j)/2;
             int m=a.get(mid);
             
             if(m<d) {
            	 i=mid+1;
             } else if(m>d) {
            	 j=mid-1;
             } else {
            	 a.set(0, m);
            	 return;
             }
    	}
    	a.set(0, a.get(i));
    }
    public int count(ArrayList<Integer> a, int d) {
        int i=0, j=a.size()-1;
        int count=0;
        
        while(i<=j) {
            int mid=(i+j)/2;
            int m=a.get(mid);
            
            if(m<=d) {
                count+= j-i+1;
                i=mid+1;
            } else {
                j=mid-1;
            }
        }
        return count;
    }
    
	public ArrayList<Integer> inorderTraversal(TreeNode a) {
		Stack<TreeNode> st=new Stack<>();
	    ArrayList<Integer> al=new ArrayList<>(100000);
	    st.push(a);
	    while(!st.isEmpty()) {
	    	TreeNode tnode= st.peek();
	    	if(tnode.left==null) {
	    		if(tnode.right!=null) {
	    			st.push(tnode.right);
		    		tnode.right=null;
	    		}
	    			
	    		else {
	    			al.add(tnode.val);
	    			st.pop();
	    		}
	    			
	    		
	    	
	    	} else{
	    		
	    		st.push(tnode.left);
	    		tnode.left=null;
	    	}
	    	
	    }
	    return al;
	
	}
	
public ArrayList<Integer> postorderTraversal(TreeNode a) {
	    System.out.println(null==null);
		Stack<TreeNode> st=new Stack<>();
	    ArrayList<Integer> al=new ArrayList<>();
	    st.push(a);
	    HashMap<TreeNode, Integer> map= new HashMap<TreeNode, Integer>();
	    while(!st.isEmpty()) {
	    	TreeNode tnode= st.peek();
	    	if(myget(map, tnode)>=1 || tnode.left==null) {
	    		if(tnode.right!=null && myget(map, tnode)!=2) {
	    			st.push(tnode.right);
		    		map.put(tnode, 2);
	    		}
	    		else {
	    			al.add(tnode.val);
	    			st.pop();
	    		}
	    	} else {
	    		st.push(tnode.left);
	    		map.put(tnode, 1);
	    	}
	    	
	    }
	    return al;
	
	
	}
	static int myget(Map<TreeNode, Integer> m, TreeNode t) {
		if(m.containsKey(t)) {
			return m.get(t);
		} else 
			return -1;
	}
	
	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
		int left= -findLeftEnd(A), right=findRightEnd(A);
		System.out.println(left+" "+ right);
		Queue<TreeNode_Pos> qq=new LinkedList<TreeNode_Pos>();
		ArrayList<ArrayList<Integer>> al=new ArrayList<ArrayList<Integer>>(1000000);
		for(int i=0; i<(left+right+1); i++) {
			al.add(new ArrayList<Integer>());
		}
		if(A==null) 
			return al;
		qq.add(new TreeNode_Pos(0, A));
		
		while(!qq.isEmpty()) {
			TreeNode_Pos tnode=qq.poll();
			al.get(tnode.pos+left).add(tnode.node.val);
			
			if(tnode.node.left!=null) {
				qq.add(new TreeNode_Pos(tnode.pos-1, tnode.node.left));
			}
			if(tnode.node.right!=null) {
				qq.add(new TreeNode_Pos(tnode.pos+1, tnode.node.right));
			}
			
		}
		return al;
    }
	public static int findLeftEnd(TreeNode A) {
		if(A==null)
			return 0;

		return Math.min(A.left!=null?findLeftEnd(A.left)-1:0, A.right!=null?findLeftEnd(A.right)+1:0); 
		
	}
	public static int findRightEnd(TreeNode A) {
		if(A==null)
			return 0;

		return Math.max(A.left!=null?findRightEnd(A.left)-1:0, A.right!=null?findRightEnd(A.right)+1:0); 
		
	}
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
		hasPathSum(root, sum, new ArrayList<Integer>(), ans);
		return ans;
	}
	
	public void hasPathSum(TreeNode root, int sum, ArrayList<Integer> al,  ArrayList<ArrayList<Integer>> ans) {
		if(root.left==null && root.right==null) {
			if(sum==root.val) {
				al.add(root.val);
				ans.add(new ArrayList<Integer>(al));
				al.remove(al.size()-1);
			}
			return;
		}
		
		al.add(root.val);
	   
	   if(root.left!=null) {
		   
	       hasPathSum( root.left, sum-root.val, al, ans);
	       
	   }
	   if(root.right!=null) {
		  
	       hasPathSum( root.right,  sum-root.val, al, ans);
	      
	   }
	   al.remove(al.size()-1);
		
	    
	}
	 public void connect(TreeLinkNode root) {
	        if(root==null)
	            return;
	        if(root.left!=null) {
	            if(root.right!=null)
	                root.left.next=root.right;
	            else {
	                TreeLinkNode temp=root;
	                while(temp.next!=null) {
	                    temp=temp.next;
	                    if(temp.left!=null) {
	                        root.left.next=temp.left;
	                        break;
	                    }
	                    else if(temp.right!=null){
	                        root.left.next=temp.right;
	                        break;
	                    }
	                }
	            }
	        }
	        if(root.right!=null) {
	            TreeLinkNode temp=root;
	            while(temp.next!=null) {
	                temp=temp.next;
	                if(temp.left!=null) {
	                    root.right.next=temp.left;
	                    break;
	                }
	                else if(temp.right!=null){
	                    root.right.next=temp.right;
	                    break;
	                }
	            }
	        }
	        connect(root.left);
	        connect(root.right);
	    }
	 
	 public int strStr(final String h, final String n) {
		    if(h==null || n==null) return -1;
		    
		    return h.indexOf(n);
		}
}
class TreeNode_Pos {
	int pos;
	TreeNode node;
	public TreeNode_Pos(int pos, TreeNode node) {
		super();
		this.pos = pos;
		this.node = node;
	}
	
}
class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int val) {
		this.val=val;
	}
	
}
class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}