package dummy;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyClient {

	public MyClient() {
		// TODO Auto-generated constructor stub
		System.out.println("IN Construstor");
	}
	static {
		System.out.println("IN STAIC");
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		Socket s=new Socket("localhost",3333);  
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		  
		String str="",str2="";  
		while(!str.equals("stop")){ 
			//System.out.println("in client");
			str=br.readLine();  
			//System.out.println("in client");
			dout.writeUTF(str);  
			dout.flush();  
			str2=din.readUTF();  
			System.out.println("Server says: "+str2);  
		}  
		  
		dout.close();  
		s.close();
	}

}
