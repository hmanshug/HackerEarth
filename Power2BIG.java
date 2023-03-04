package dummypkg;

public class Power2BIG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(power("16"));
	}
	public static int power(String a) {
		
	    while(!a.equals("2")) {
	    	a=divideBy2(a);
	    	if(a.equals("NO"))
	    		return 0;
	    }
	    return 1;
	}
	public static String divideBy2(String str) {
		StringBuilder ans=new StringBuilder();
		int carry=0;
		
		for(int i=0; i<str.length(); i++) {
			int digit=str.charAt(i)-'0';
			int temp=carry*10 + digit;
			carry=temp%2;
			ans.append(temp/2);
		}
		if(carry!=0)
			return "NO";
		if(ans.charAt(0)=='0')
			ans.substring(1);
		
		System.out.println("--"+ans);
		return ans.toString();
	}

}
