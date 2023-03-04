package he;

import java.util.Scanner; 

public class Honeywell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int N=sc.nextInt();
		int data[]= new int[N];
		for(int i=0; i<N; i++) data[i]=sc.nextInt();
		int test=sc.nextInt();
		for(int j=0; j<test; j++) {
			int L=sc.nextInt(), R=sc.nextInt();
			for(int i=0; i<test; i++) {
			if(i!=N-i-1) {
		        data[i] = data[i] ^ data[N-i-1];
                data[N-i-1] = data[N-i-1] ^ data[i];
                data[i] = data[i] ^ data[N-i-1];
		    }
			}
		}
		
		for(int i=0; i<N; i++) System.out.print(data[i]+" ");
			
	}

}
