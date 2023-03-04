package dummypkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeBST {

	
	public static void printArray(int[] a, int n) {
		for(int i=0; i<n; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PracticeBST p=new PracticeBST();
		ArrayList<Integer> al=new ArrayList<>();
		al.add(0);
		al.add(1);
		al.add(2);
		al.add(5);
		//System.out.println(solve(al, 2, 21));
		System.out.println(p.searchRange(new ArrayList<>(Arrays.asList(5, 7, 8, 8, 8, 10)), 9));
		
	}
	public static int solve(ArrayList<Integer> A, int B, int C) {
        int n=A.size(), i=0;
        boolean[] present=new boolean[10];
        int[] limit=new int[10];
        
        for(int t: A) {
            present[t]=true;
        }
        
        while(C!=0) {
            limit[i++]=C%10;
            C/=10;
        }
        int len=i;
        i=0;int j=len-1;
        while(i<j) {
        	limit[i]=limit[i]^limit[j];
        	limit[j]=limit[i]^limit[j];
        	limit[i]=limit[i]^limit[j];
        	i++;j--;
        }
       // printArray(limit, len);
        
        if(len>B) len=B;
        return count(limit, A, 0, len);
        
		}
    
	public static int count(int[] limit, ArrayList<Integer> al, int pos, int len) {
		
		if(pos>=len) return 1;
		
		int ans=0;
		for(int i=0; i<al.size(); i++) {
			if(pos==0 && len>1 && al.get(i)==0)	
				continue;
			if(pos==len-1 && al.get(i)==limit[pos])
				break;
			
			if(al.get(i)==limit[pos]) {
				ans+= count(limit, al, pos+1, len);
			} else if(al.get(i)<limit[pos]) {
				ans+=Math.pow(al.size(), len-pos-1);
			} else 
				break;
		}
		return ans;
	}
	
	public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
	    int n=a.size();
	    int i=0, j=n-1, left, right;
	    ArrayList<Integer> al=new ArrayList<>();
	    
	    while(i<=j) {
	        int mid=(i+j)/2;
	        int m=a.get(mid);
	        
	        if(m>=b) {
	            j=mid-1;
	        } else {
	            i=mid+1;
	        }
	    }
	    if(a.get(i)!=b) {
	    	al.add(-1);
		    al.add(-1);
		    return al;
	    }
	    left=i;
	    i=0; j=n-1;
	    
	    while(i<=j) {
	        int mid=(i+j)/2;
	        int m=a.get(mid);
	        
	        if(m>b) {
	            j=mid-1;
	        } else {
	            i=mid+1;
	        }
	    }
	    right=j;
	    
	    al.add(left);
	    al.add(right);
	    return al;
	}
	public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
	    int m=a.size(), n=b.size();
	    int i=0,j=0;
	    
	    for( ; i<m && j<n;) {
	        int aa=a.get(i), bb=b.get(j);
	        
	        if(aa==bb) {
	            a.add(i, aa);
	            i=i+2;j++;
	        } else if(aa<bb) {
	            i++;
	        } else {
	            a.add(i,bb);
	            i++;
	            j++;
	        }
	    }
	    
        while(j!=n) {
            a.add(b.get(j++));
        }
	   
	}
}
