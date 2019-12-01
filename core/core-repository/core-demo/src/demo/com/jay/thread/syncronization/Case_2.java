package demo.com.jay.thread.syncronization;

public class Case_2 {
	
	public static void main(String[] args) {
		
		Display1 display1=new Display1();
		MyThread2 t1=new MyThread2(display1, "jayesh");
		MyThread2 t2=new MyThread2(display1, "dilip");
		t1.start();
		t2.start();
	}

}


class MyThread2 extends Thread {

	Display1 display;
	String name;
	public MyThread2(Display1 display, String name) {
		this.display = display;
		this.name = name;
	}
	
	@Override
	public void run() {
		display.wish(name);
	}
	
	
}


// not declaring wish method synchronized then both the tread executed symentenoussly and hence we will get irregulat output
//declaring wish method synchronized then ate time only one thread allowed to executed wish method give object hence we will get irregulat output

class Display1 {

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


