package com.jay.thread.threadclass;

public class Run {
	
	public static void main(String[] args) {
		
		Thread jay=new Thread(new Customer("jay",5), "jay");
		Thread dhamo=new Thread(new Customer("dhamo",5), "dhamo");
		Thread apu=new Thread(new Customer("apu",5), "apu");
		
		jay.start();
		dhamo.start();
		apu.start();
	}
}
