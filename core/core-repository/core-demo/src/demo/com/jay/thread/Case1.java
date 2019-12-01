package demo.com.jay.thread;

public class Case1 {

	public static void main(String[] args) {
		
		Child t=new Child();
		t.start();// responsible to start thread  internally call  run , if i call t.start separate flow will created  
		//t.run(); // if call run will execute as normal method  by main thread
		
		 for (int i = 0; i < 10; i++) {
				System.out.println("perent-"+i);
			}
						
	}
	
	
}
 class Child extends Thread {

	
	 @Override
	public void run() {
		 
		 for (int i = 0; i < 1000; i++) {
			System.out.println("child-"+i);
		}
	 }
}
