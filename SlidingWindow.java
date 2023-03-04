package dummy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SlidingWindow {


	public static void main(String[] args) {
		System.out.println(findMinSubStringLength(new ArrayList<Character>(Arrays.asList('x', 'y', 'a')), "xyyzyyzx"));
	}
	
	public static int findMinSubStringLength(ArrayList<Character> charArray, String text) {
		int left=0, tcount=0, size=charArray.size(), min=Integer.MAX_VALUE;
		HashMap<Character, Integer> charCount= new HashMap<>();
		HashMap<Character, Boolean> want= new HashMap<>();
		
		for(Character ch: charArray) {
			want.put(ch, true);
		}
		
		for(int i=0; i<text.length(); i++) {
			char current= text.charAt(i);
			if(want.containsKey(current)) {
				charCount.put(current, charCount.containsKey(current)?(charCount.get(current)+1):1);
				if(charCount.get(current)==1) tcount++;
			}
			while(charCount.containsKey(text.charAt(left)) && charCount.get(text.charAt(left))>1) {
				charCount.put(text.charAt(left), charCount.get(text.charAt(left))-1);
				left++;
			}
			if(tcount==size) {
				if(i-left+1 < min) {
					min=i-left+1;
				}
			}
		}
		return tcount==size?min:-1;
	}

}
