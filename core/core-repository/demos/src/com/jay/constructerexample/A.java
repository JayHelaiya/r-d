package com.jay.constructerexample;

class A{  
	A(){
		System.out.println("hello a");
	}  
	A(int x){  
		this();  
		System.out.println(x);  
	}  
	A(int x,int y){  
		this(x);  
		System.out.println(x);  
	}  
}  
class TestThis5 {  
public static void main(String args[]){  
A a=new A(10,20);  
}}  
