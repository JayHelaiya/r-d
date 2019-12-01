package com.jay.methodoverridingexample;

class A{  
	A get(){
		return this;
		}  
	}  

public class ConvinientReturnType extends A{

	 ConvinientReturnType get(){
		return this;
		}  
		void message(){System.out.println("welcome to covariant return type");}  
		  
		public static void main(String args[]){  
		new ConvinientReturnType().get().message();  
		}  
}
