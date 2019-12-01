package com.jay.instanceInitializerBlockexample;

public class Bike extends Vihical {

	int speed;
	
	public Bike() {
		super();
		System.out.println("bike constructor");
	}
	
	{
		speed=50;
		System.out.println("bike instance Initializer block");
	}
}
