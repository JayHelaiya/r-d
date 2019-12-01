package demo.com.jay.thread.priority;

class MyThread1  extends Thread
{
	@Override
	public void run() {
		for (int i = 0; i <10; i++) {
			
			System.out.println("child thread -"+i);
		}
	}
	

}
public class Case2 {
	
	public static void main(String[] args) {
		
		MyThread1 child=new MyThread1();
		child.setPriority(10);
		child.start();
		
		
		for (int i = 0; i <10; i++) {
			
			System.out.println("main thread -"+i);
		}
		
	}
	
	// note
	// if we are comminting line one then both main and child thread have same priority 5 and hencewe cant expect exicution order
//	and exact output
//	
//	if not comminentin line the main thread has prioty has 5 and child priory 10 hence child thread get chance first followed by inthis case output 
//	is child thread 10 follwed by main thread 10 times

	
	// some plateform want for thread priority 
}
