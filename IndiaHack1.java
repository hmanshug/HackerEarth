package he;

import java.util.Scanner;

public class IndiaHack1 {

	private static Scanner s;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s= new Scanner(System.in);
		int n=s.nextInt();
		
		int a[]=new int[n];
		int l[]=new int[n];
		int r[]=new int[n];
		int count=0, tcount=0, max=n;
		
		for(int i=0; i<n; i++) {
			a[i]=s.nextInt();
			if(a[i]==1) {count++; tcount++;}
			else count=0;
			l[i]=count;
		}
		count=0;
		if(tcount!=n) {
			for(int i=n-1; i>=0; i--) {
				if(a[i]==1) count++;
				else count=0;
				r[i]=count;
			}
			max=0;
			for(int i=0; i<n;  i++) {
				if(a[i]==0) {
					if(i==0) {
						if(tcount-r[i+1] > 0 && max< r[i+1]+1)
							max= r[i+1]+1;
						else if(max < r[i+1])
							max= r[i+1];
					} 
					else if(i==n-1) {
						if(tcount- l[i-1] > 0 && max< l[i-1]+1)
							max= l[i-1] +1;
						else if(max < l[i-1])
							max= l[i-1];
					}
					else {
						if(tcount- (l[i-1] + r[i+1]) > 0 && max< l[i-1] + r[i+1]+1)
							max= l[i-1] + r[i+1]+1;
						else if(max < l[i-1] + r[i+1])
							max= l[i-1] + r[i+1];
					}
					
						
				}
			}
		}
		System.out.println(max);
		
	}

}
