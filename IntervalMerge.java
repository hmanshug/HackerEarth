package he;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IntervalMerge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval a, Interval b) {
				if(a.start<b.start)
					return -1;
				else if(a.start>b.start)
					return 1;
				else
					return a.end<b.end?-1:1;
			
			}
		});
        int n=intervals.size();
        ArrayList<Interval> ans= new ArrayList<>();
        Interval prev= intervals.get(0);
        for(int i=1; i<n; i++) {
        	Interval cur=intervals.get(i);
            if(check(prev, cur)) {
            	prev.start=Math.min(prev.start, cur.start);
            	prev.end=Math.max(prev.end, cur.end);
            } else {
            	ans.add(prev);
            	prev=intervals.get(i);
            }
        }
        ans.add(prev);
		return ans;
    }
    public static boolean check(Interval a, Interval b) {
    	if(Math.max(a.start, b.start)<=Math.min(a.end, b.end))
    		return true;
    	else 
    		return false;
    }
}
class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
		
	  }
class MyCompartor implements Comparator<Interval> {

	@Override
	public int compare(Interval a, Interval b) {
		if(a.start<b.start)
			return -1;
		else if(a.start>b.start)
			return 1;
		else
			return a.end<b.end?-1:1;
	
	}
	
}