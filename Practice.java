package dummypkg;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Practice {
	public static void main(String[] in) {
	
		System.out.println(findPossibleSmallestNumberMatchingPattern("MNM"));
	}
	static int findPossibleSmallestNumberMatchingPattern(String pattern) {
		if(pattern==null || pattern.length()==0)
			return -1;
        boolean check[]=new boolean[10];
        StringBuilder ans=new StringBuilder();
        
        for(int i=1; i<=9; i++) {
        	ans.append(i);
        	check[i]=true;
        	if(rec(pattern, 0, ans, check))
        		break;
        	ans.deleteCharAt(ans.length()-1);
        	check[i]=false;
        }
        if(ans.length()==0)
        	return -1;
       else
    	   return Integer.valueOf(ans.toString());
    }
 
	static boolean rec(String pattern, int cur, StringBuilder ans, boolean[] check) {
		//Base condition
		if(cur==pattern.length()) {
			return true;
		}
		for(int i=1; i<=9; i++) {
			if(check[i]==false && ((pattern.charAt(cur)=='M' && (ans.charAt(ans.length()-1)-'0')>i) || (pattern.charAt(cur)=='N' && (ans.charAt(ans.length()-1)-'0')<i))) {
				ans.append(i);
				check[i]=true;
				if(rec(pattern, cur+1, ans, check))
	        		return true;
				ans.deleteCharAt(ans.length()-1);
	        	check[i]=false;
			}
		}
	
		return false;
	}
}


