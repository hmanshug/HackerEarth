package dummy;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.omg.CORBA.FREE_MEM;

public class DummyClass {

	public DummyClass() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		/*
		ArrayList bb= new ArrayList();
		bb.add(123);
		bb.add("ghu");
		System.out.println(bb);
		
		Integer c=new Integer(5);
		Integer a=new Integer(5);
		Integer b=a;
		//String b="abc";
		int x=6;
		int y=6;
		System.out.println("a= "+a+"-"+a.equals(b));
		System.out.println(a==b);
		System.out.println(a==c);
		System.out.print(x==y);
		System.out.print("");
		*/
		//MyClient m=new MyClient();
		//MyClient mn=new MyClient();
		/*
		String newline = System.getProperty("line.separator");
		System.out.println("hello"+"\f\r"+"hims");
		Class clazz=Class.forName("dummy.MyClient");
		MyClient client= (MyClient) clazz.newInstance();
		MyClient client2= (MyClient) clazz.newInstance();
		
		int a[];
		a = new int[5];
		a = new int[5];
		String s=new String("");
		System.out.println(s.equals(null));
		
		Point   p = new Point();
        Element e = new Element();
        if (p instanceof Element) {  // compile-time error
            System.out.println("I get your point!");
            e = (Element)p;  // compile-time error
            System.out.println(e.z + "");
        }
		
        
		Integer a=new Integer(127);
		Integer b=a;
		Integer c=Integer.valueOf("128");
		Integer d=Integer.valueOf("128");
		System.out.println(c==d);
		
		int zz[]=new int[4];
		Element e=new A();
		e.run();
		System.out.println("");
		//
		
		HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
		map.put(5, 100);
		map.put(1, 105);
		map.put(10, 110);
		
		System.out.println(map);
		ArrayList<Integer> slist= new ArrayList<Integer>(map.keySet());
		Collections.sort(slist);
		
		System.out.println(slist.get(0) + " " + map.get(slist.get(0)));
		
		String str= "heelo,kk,good,mng";
		String[] arr= str.split(",");
		System.out.println(arr.length);
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		System.out.println(Long.MAX_VALUE); //9223372036854775807
		System.out.println(BigInteger.valueOf(922600000));
		
		A aa= new B1();
		System.out.println(aa.get());//.message();
		( (B1) aa.get()).message();;;;;
		*/
		/*
		Element ee= new Point();
		Point p=new Point();
		Point pp=p.clone();
		System.out.println(p.x+" "+pp.x);
		p.x=11;
		System.out.println(p.x+" "+pp.x);
		pp.x=12;
		System.out.println(p.x+" "+pp.x);
	    char cc[]=new char[25];
	    cc[0]= 'r';
		String s=new String();
		String ss="ram";
		String sss=s.intern();
		//System.out.println(s.charAt(0));
		System.out.println(ss==sss);
		System.out.println(s==sss);
		
		Map<Integer, Integer> f= new TreeMap<Integer, Integer>();
		
		//f.put(null, 6);
		//f.put(null, null);
		f.put(6, null);
		//f.put(6, 6);
		f.put(5, 5);
		f.put(8, 8);
		
		Set<Map.Entry<Integer, Integer>> i= f.entrySet();
		Iterator<Map.Entry<Integer, Integer>> itr=i.iterator();
		while(itr.hasNext()) {
			Map.Entry<Integer,Integer> m= itr.next();
			System.out.println(m.getKey() + " " + m.getValue());
		}
		*/
		HashMap<String, Integer> map= new HashMap<String, Integer>();
		map.put("key1", 1);
		map.put("key2", 2);
		map.put("key3", 3);
		StringBuilder sb= new StringBuilder();
		sb.append("key1");
		if(map.containsKey(sb.toString())) {
			System.out.println("YY");
		}
		
 		//ee.run1();
	}

}
class Element { Element(){System.out.println("CONSTRUCTOR - E");}int z=5; protected void run1(){System.out.println("E");}}
class Point extends Element implements Cloneable{ 
	Point(){System.out.println("CONSTRUCTOR - P");}
	int x, y, z=10;
	public void run(){System.out.println("P");}
	public Point clone() throws CloneNotSupportedException {
		return (Point) super.clone();
	}
	
}

class A implements Cloneable{  
A get() throws CloneNotSupportedException{ System.out.println("P"+ this); return this;}  
}  
  
class B1 extends A implements Cloneable{  
A gety() throws CloneNotSupportedException{return (A) super.get();} 
void gett() throws CloneNotSupportedException {get();}
void message(){System.out.println("welcome to covariant return type");}  
}

