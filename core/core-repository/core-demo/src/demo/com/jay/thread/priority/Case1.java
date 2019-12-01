package demo.com.jay.thread.priority;

class MyThread  extends Thread
{
	

}
public class Case1 {
	
	public static void main(String[] args) {
		
		//System.out.println(Thread.MIN_PRIORITY); //1
		//System.out.println(Thread.MAX_PRIORITY); //10
		//System.out.println(Thread.NORM_PRIORITY); //5
		
		//System.out.println(Thread.currentThread().getPriority());
		// Thread.currentThread().setPriority(17); // java.lang.IllegalArgumentException
		Thread.currentThread().setPriority(7); 
		
		MyThread child=new MyThread();
		
		System.out.println(child.getPriority()); // priority is override from parent thread
		
	}

}
