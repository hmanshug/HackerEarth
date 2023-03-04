package dummy;

public class CustomException {

	public CustomException() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			chk();
			
		} catch(exc e) {
			System.out.println(e.getMessage());
			System.out.println( e.getMsg());
			System.out.println( e.getCode());
			System.out.println(1);
			e.printStackTrace();;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(((exc) e).getMsg());
			System.out.println(((exc) e).getCode());
			
			e.printStackTrace();
		} 
		
	}
	public static void chk() throws exc {
		
		if(1>0)
		throw new exc("101", "MY EXCEPTION");
	}

}

class exc extends Exception {
	String code;
	String msg;
	public exc(String code, String msg) {
		super(msg+" "+code);
		this.code = code;
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}