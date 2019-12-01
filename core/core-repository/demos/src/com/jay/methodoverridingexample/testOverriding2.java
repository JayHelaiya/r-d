package com.jay.methodoverridingexample;

class Vehicle1{  
	  void run(){
		  System.out.println("Vehicle is running");
		 }  
	}  

	class Bike1 extends Vehicle1{  
	@Override
	void run() {
		System.out.println("Bike is running");
		//return 0;
	   }
	}  

public class testOverriding2 {

	public static void main(String args[]){  
		  Bike1 obj = new Bike1();  
		  obj.run();  
	  }
}
