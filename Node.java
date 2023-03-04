package dummy;

public class Node implements Comparable<Node>{
	Integer t, x, y;
	public Node (Integer t, Integer x, Integer y) {
		this.t=t;
		this.x=x;
		this.y=y;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		if(this.t!=o.t) {
			return this.t.compareTo(o.t);
		}
		else {
			if(this.y==o.y) {
				return this.x.compareTo(o.x);
			} else {
				return o.y.compareTo(this.y);
			}
		}
	}
	public String  toString(){
		// TODO Auto-generated method stub
		return ( t+" "+x+" "+y);
	}
}
