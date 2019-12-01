package com.jay.thread.threadclass;

public class Customer implements Runnable{

	private String name;
	private int order;
	CounterPerson  counterPerson=new CounterPerson();
	
	public Customer(String name, int order) {
		this.order=order;
		this.name=name;
	}
	@Override
	public void run() {
		counterPerson.giveTikit(name,order);
	}

}
