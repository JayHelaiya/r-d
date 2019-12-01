package com.jay.methodoverridingexample;

class Vehicle{  
	  void run(){
		  System.out.println("Vehicle is running");
		 }  
	}  

	class Bike extends Vehicle{  
	
		
	}  



public class testOverriding1 {

	  public static void main(String args[]){  
		  Bike obj = new Bike();  
		  obj.run();  
	  }
}
