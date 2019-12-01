package demo.com.jay.thread.syncronization;

public class Case_3 {
	
	public static void main(String[] args) {
		
		Display2 d2=new Display2();
		Display2 d3=new Display2();
		MyThread3 t1=new MyThread3(d2, "jayesh"); 
		MyThread3 t2=new MyThread3(d3, "dilip");
		t1.start();
		t2.start();
	}

}
// t1 (d2) start wish ---"jayesh"
//t2 (d3) start wish ---"jayesh"
// even tho wish method is sync we will get irregular output because thread are operationg different java object []
// if multiple thread operationg on same object 
// if multiple thread operationg on multiple  object then sync not need to use 

class MyThread3 extends Thread {

	Display2 display;
	String name;
	public MyThread3(Display2 display2, String name) {
		this.display = display2;
		this.name = name;
	}
	
	@Override
	public void run() {
		display.wish(name);
	}
	
	
}



class Display2 {

	public synchronized void wish(String name) {
		
		for (int i = 0; i < 10; i++) {
			System.out.print("good morning : ");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
			
			System.out.println(name);
		}
	}
}


