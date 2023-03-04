package dummy;

import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Collections;

public class ThreadExample extends Thread {
	
	public int count=1;
	
	public ThreadExample(String s) {
		// TODO Auto-generated constructor stub
		this.setName(s);
	}
	public synchronized void run() {
		
		for(int i=1; i<=25; i++) {
			
				
				System.out.println(this.getName() +" "+ count++);
				try {
					this.wait(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new ThreadExample("A").start();
		//new ThreadExample("B").start();
		System.out.println(titleToNumber("AA"));
	}
	public static int titleToNumber(String a) {
		int len=a.length();
		int ref=Character.getNumericValue('A')-1;
		int sum=0;
		
	    for(int i=len-1, j=0; i>=0; i--, j++) {
	    	int temp=Character.getNumericValue(a.charAt(j)) - ref;
	    	sum+= (int) Math.pow(26, i) * temp;
	    }
	    
	    return sum;
	}
}
