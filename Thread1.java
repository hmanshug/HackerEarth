package dummypkg;

public class Thread1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
		Pair p=new Pair();
		Thread one=new MYThread("one", p);
		Thread two=new MYThread("two", p);
		Thread three=new MYThread("three", p);
		one.start();
		two.start();
		three.start();
	}

}
class Pair {
	int count=0;
}
class MYThread extends Thread{
	
	Pair p;
	
	public MYThread(String string, Pair p) {
		super(string);
		this.p=p;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		func1();
	}
	public void func1() {
		
		for(int i=0; i<5; i++) {
			synchronized(p) {
				p.notify();
				try {
					p.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " " + p.count++);
				
				
			}
		}
		
	}
}