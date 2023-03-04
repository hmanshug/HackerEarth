package dummy;

public class StringBufferr {

	public StringBufferr() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sbi="";
		String sb[]=sbi.split("\\r?\\n");
	    String s=""; 
	    
	    for(int i=0; i<sb.length; i++) {
	        System.out.println(sb[i].substring(sb[i].indexOf("!sip")+6, sb[i].indexOf("@")));
	        String sip =sb[i].substring(sb[i].indexOf("!sip")+6, sb[i].indexOf("@"));
	        s=s.concat(sip+" ");
	        System.out.println(sb[i].substring(sb[i].indexOf("mnc")+3,sb[i].indexOf("mcc")-1));
	        
	        String rrid = sb[i].substring(sb[i].indexOf("mnc")+3,sb[i].indexOf("mcc")-1);
	        
	        s=s.concat(rrid+" ");
	        System.out.println(sb[i].substring(sb[i].indexOf("rrid")+5,sb[i].indexOf("NAPTR")-1));
	        String mnc = sb[i].substring(sb[i].indexOf("rrid")+5,sb[i].indexOf("NAPTR")-1);
	        s=s.concat(rrid+"\\n");
	        //System.out.println("heelo");
	        
	        
	    }
	    System.out.println("s::::"+s);
	}

}
