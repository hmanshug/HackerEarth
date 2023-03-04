package he;

import java.util.Scanner;
import java.util.Stack;

public class BRACKETS {

	private static Scanner  s;

	public static void main(String[] args) {
		 s = new Scanner(System.in);
		 String str= s.nextLine();
		 int t= s.nextInt();
		 
		 
		 // ( removed
		 
		 // ) removed
		 int fc;
		 if(t==1) {
			 Stack<Character> st=new Stack<>();
			 int count=0;
			 fc=0;
			 for(int i=str.length()-1; i>=0; i--) {
				 if(str.charAt(i)==')') {
					 st.push(str.charAt(i));
					 count++;
				 }
				 else if(str.charAt(i)=='(') 
					 st.pop();
				 
				 if(st.isEmpty()) {
					 fc+=count*2;
					 count=0;
				 }
			 }
		 }
		 else {
			 Stack<Character> st=new Stack<>();
			 int count=0;
			 fc=0;
			 for(int i=0; i<str.length(); i++) {
				 if(str.charAt(i)=='(') {
					 st.push(str.charAt(i));
					 count++;
				 }
				 else if(str.charAt(i)==')') 
					 st.pop();
				 
				 if(st.isEmpty()) {
					 fc+=count*2;
					 count=0;
				 }
			 }
		 }
		 System.out.println((str.length()+1 - fc)/2);
		 
		 
	}

}
