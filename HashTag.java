package he;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HashTag {
	private static Scanner  s;
	public static void main(String[] args) {
		s=new Scanner(System.in);
		int n=s.nextInt();
		HashMap<String, Integer> mymap=new HashMap<>();
		
		for(int i=0; i<n; i++) {
			String str=s.nextLine();
			int flag=0;
			StringBuilder tstr=new StringBuilder();
			
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j)=='#') {
					flag=1;
				}
				if(flag==1 && (str.charAt(j)==' ' || j==str.length()-1)) {
					if(mymap.containsKey(tstr)) 
						mymap.put(tstr.toString(), mymap.get(tstr.toString())+1);
					else 
						mymap.put(tstr.toString(), 1);
					tstr= new StringBuilder();
					flag=0;
				}
				if(flag==1) {
					tstr.append(str.charAt(j));
				}
			}
		}
		ValueComparator bvc = new ValueComparator(mymap);
        TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(bvc);
        
        HashSet<String> al=(HashSet<String>) sorted_map.keySet();
        Iterator<String> itr =al.iterator();
        for(int i=0; i<5 && itr.hasNext(); i++) {
        	System.out.println(itr.next());
        }
	}
}

class ValueComparator implements Comparator<String> {
    Map<String, Integer> base;

    public ValueComparator(Map<String, Integer> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with
    // equals.
    public int compare(String a, String b) {
        if (base.get(a) > base.get(b)) {
            return 1;
        } else if(base.get(a) == base.get(b)) {
        	return a.compareTo(b);
        }
        else {
            return -1;
        } // returning 0 would merge keys
    }
}