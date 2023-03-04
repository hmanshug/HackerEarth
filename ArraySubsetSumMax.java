package he;

import java.util.ArrayList;

public class ArraySubsetSumMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();

	}
	public ArrayList<Integer> maxset(ArrayList<Integer> a) {

	    
	    int len=a.size(), left=0, right=0, i=0;
	    long fsum=-1, sum=0;
	    int fleft=-1, fright=-1;
	    ArrayList<Integer> temp= new ArrayList<>();
	    boolean flag=false;
	    
	    for(i=0; i<len; i++) { // negative
	        if(a.get(i)<0) {
	            if(flag==true) {
	                right=i-1;
	                if(fsum<sum) {
	                    fsum=sum;
	                    fleft=left;
	                    fright=right;
	                } else if(fsum==sum) {
	                    int flen=fright=fleft+1, nlen=right-left+1;
	                    if(flen<nlen) {
	                        fsum=sum;
    	                    fleft=left;
    	                    fright=right;
	                    }
	                }
	                
	                sum=0;
	            }
	            flag=false;
	            
	        } else if(flag==true){ // positive repeat
	            sum+=a.get(i);
	            
	        } else { //first positive
	            sum=a.get(i);
	            left=i;
	            flag=true;
	        }
	    }
	    if(flag==true) {
            right=i-1;
            if(fsum<sum) {
                fsum=sum;
                fleft=left;
                fright=right;
            } else if(fsum==sum) {
                int flen=fright=fleft+1, nlen=right-left+1;
                if(flen<nlen) {
                    fsum=sum;
                    fleft=left;
                    fright=right;
                }
            }
            
            sum=0;
        }
        if(fsum!=-1)
	    for(int j=fleft; j<=fright; j++) {
	    	temp.add(a.get(j));
	    }
		return temp;
	
	
	}
}
