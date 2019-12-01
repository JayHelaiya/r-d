package demo.com.jay.thread;

public class Case3 {

	public static void main(String[] args) {
		
		Child2 t=new Child2();
		t.start();
		
	}
	
	
}
 class Child3 extends Thread {
	
	 // if not overriding run method then thread class run method will be executed which has empty implementation hence we want get any output
}
