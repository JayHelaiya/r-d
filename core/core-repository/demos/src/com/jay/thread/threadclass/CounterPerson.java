package com.jay.thread.threadclass;

public class CounterPerson {

	static int tikit=10;
	
	public void giveTikit(String name,int order) {
		
		if(order<=tikit) {
			tikit=tikit-order;
			System.out.println(name+" got "+order);
			System.out.println("left="+tikit);
		}
	}
}
