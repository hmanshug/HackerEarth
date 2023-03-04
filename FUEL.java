package he;

import java.util.Scanner;

public class FUEL {
	private static Scanner  s;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner(System.in);
		int a[]=new int[5];
		int b[]=new int[5];
		
		for(int i=0; i<5; ++i) a[i]=s.nextInt();
		for(int i=0; i<5; ++i) b[i]=s.nextInt();
		
		while(true) {
			int i;
			for(i=0; i<5 && a[i]==0; i++);
			if(i==5) break;
				
		}

	}

}
