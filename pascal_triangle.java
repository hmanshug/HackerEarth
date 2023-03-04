package dummy;

import java.util.ArrayList;

public class pascal_triangle {

	public pascal_triangle() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getRow(3));

	}
	public static ArrayList<ArrayList<Integer>> generate(int a) {
	    ArrayList<ArrayList<Integer>> ans= new ArrayList<ArrayList<Integer>>();
	    
	    for(int i=1; i<=a; i++) {
	        ans.add(new ArrayList<Integer>());
	        for(int j=1; j<=i; j++) {
	            if(j==1 || j==i) {
	                ans.get(i-1).add(1);
	                
	            } else {
	            	
	                ans.get(i-1).add(ans.get(i-2).get(j-2) + ans.get(i-2).get(j-1));
	            }
	        }
	    }
	    return ans;
	}
	public static ArrayList<Integer> getRow(int a) {

	    a++;
	    ArrayList<Integer> ans= new ArrayList<Integer>();
	    int prev=1;
	    
	    for(int i=1; i<=a; i++) {
	        for(int j=1; j<=i; j++) {
	            if(j==1 || j==i) {
	            	if(j<=ans.size())
	            		ans.set(j-1, 1);
	            	else
	            		ans.add(j-1, 1);
	            } else {
	            	int temp=ans.get(j-1);
	            	if(j<=ans.size())
	            		 ans.set(j-1, prev + temp);
	            	else
	            		 ans.add(j-1, prev + temp);
	            	prev=temp;
	            }
	        }
	    }
	    return ans;
	
	}
}
