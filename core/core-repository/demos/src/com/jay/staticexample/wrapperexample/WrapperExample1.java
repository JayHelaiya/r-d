package com.jay.staticexample.wrapperexample;

public class WrapperExample1 {

	public static void main(String args[]){  
		//Converting int into Integer  
		int a=20;  
		Integer b=a;
		System.out.println(b);
		//Integer i=Integer.valueOf(a);//converting int into Integer  
		//Integer j=a;//autoboxing, now compiler will write Integer.valueOf(a) internally  
		//System.out.println(a+" "+i+" "+j);  
		
		
		Integer no=new Integer("10");
		int no2=no;
		System.out.println(no2);
		Integer no3=no2;
		
		System.out.println(no3);
		
		
	}
}
