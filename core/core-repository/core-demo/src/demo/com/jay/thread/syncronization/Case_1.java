package demo.com.jay.thread.syncronization;

public class Case_1 {
	
	public static void main(String[] args) {
		
		Display1 display=new Display1();
		MyThread t1=new MyThread(display, "jayesh");
		t1.start();
	}

}


class MyThread extends Thread {

	Display1 display;
	String name;
	public MyThread(Display1 display, String name) {
		this.display = display;
		this.name = name;
	}
	
	@Override
	public void run() {
		display.wish(name);
	}
	
	
}

class Display {

	public void wish(String name) {
		
		for (int i = 0; i < 10; i++) {
			System.out.print("good morning : ");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
			
			System.out.println(name);
		}
	}
}


