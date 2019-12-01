package demo.com.jay.thread;

public class Case2 {

	public static void main(String[] args) {
		
		Child3 t=new Child3();
		t.start();
		
	}
	
	
}
 class Child2 extends Thread {
	
	 
	 // thread class method can invoke no argument rum method , another overloaded method we have to call explicitly like normal method call 
	 // run method is possible but JVM will call no argument will call
	 @Override
	public void run() {
		 
		System.out.println("no argument");
	 }
	 
	public void run(int i) {
		System.out.println("argument="+i);
	}
}
