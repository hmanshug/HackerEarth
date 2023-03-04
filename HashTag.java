package dummy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class HashTag {
	private static Scanner  s;
	public static <E> void main(String[] args) {
		s=new Scanner(System.in);
		int n=s.nextInt();
		HashMap<String, Integer> mymap=new HashMap<>();
		
		for(int i=0; i<=n; i++) {
			String str=s.nextLine();
			int flag=0;
			StringBuilder tstr=new StringBuilder();
			
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j)=='#') {
					flag=1;
				}
				else if(flag==1 && (str.charAt(j)==' ' || j==str.length()-1)) {
					if(j==str.length()-1) tstr.append(str.charAt(j));
					if(mymap.get(tstr.toString()) != null)  {
						int ag=mymap.get(tstr.toString());
						//System.out.println("Found Again: "+ tstr+ag);
						mymap.put(tstr.toString(), ag+1);
					}
						
					else 
						mymap.put(tstr.toString(), 1);
					tstr= new StringBuilder();
					flag=0;
				}
				else if(flag==1) {
					tstr.append(str.charAt(j));
				}
			}
		}
		/*for(Map.Entry<String, Integer> me: mymap.entrySet()) {
			System.out.println("Key: "+ me.getKey()+" Value: "+me.getValue());
		}
		*/
		Comparator<Entry<String, Integer>> bvc = new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				
				if(o1.getValue()==o2.getValue()) {
					return o1.getKey().compareTo(o2.getKey());
				} else {
					return o2.getValue().compareTo(o1.getValue());
				}
			}
			
		};
		ArrayList<Entry<String, Integer>> listOfEntries = new ArrayList<Entry<String, Integer>>(mymap.entrySet());
        Collections.sort(listOfEntries, bvc);
        for(int i=0; i<5; i++) {
			System.out.println("#"+listOfEntries.get(i).getKey());
		}
        
	}
}