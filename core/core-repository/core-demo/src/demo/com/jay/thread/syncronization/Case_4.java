package demo.com.jay.thread.syncronization;

public class Case_4 {
	
	public static void main(String[] args) {
		
		Display3 d2=new Display3();
		Display3 d3=new Display3();
		MyThread4 t1=new MyThread4(d2, "jayesh"); 
		MyThread4 t2=new MyThread4(d3, "dilip");
		t1.start();
		t2.start();
	}

}
// every class in java has unique lock which is class level lock 
// there are two lock 
//   - class level 
//   - Object level 

// if thread want to execute static syncronized method then thread require class level lock once thead got class level lock then allowed to execute any static syncro menthod of that class
// once method completes automatically thread release the lock 


class MyThread4 extends Thread {

	Display3 display;
	String name;
	public MyThread4(Display3 display3, String name) {
		this.display = display3;
		this.name = name;
	}
	
	@Override
	public void run() {
		display.wish(name);
	}
	
	
}



class Display3 {

	public static synchronized void wish(String name) {
		
		for (int i = 0; i < 10; i++) {
			System.out.print("good morning : ");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
			
			System.out.println(name);
		}
	}
}

// note :

/*	class x {
		
		public static synchronized void m1() {}   t1 [ok]
		public static synchronized void m2() {}	  t2 [not ok]	
		public static void m3() {} 				  t3 [ok]	
		public synchronized void m4() {}		  t4 [ok]	
		public void m5() {}						  t5 [ok]	
	}*/

	// while thread static synchronized remainig thread not allowed any static synchronized of that class symentanuuslly but reamainig thread allowed to execute following method simultenouslly
	// normale static
	// syncronized instance method 
	// normal method 