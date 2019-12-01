package com.example.easynotes;

public class B {
	public B() {
		// TODO Auto-generated constructor stub
		System.out.println("hello");
	}
	public B(int i) {
		this();
		// TODO Auto-generated constructor stub
		System.out.println("hello"+i);
	}
	public static void main(String[] args) {
		
		B b=new B(3);
	}

}


/*
 public B () {
	       System. out .println ( "Hello" );
	       }
	             
	   public B ( int i ) {
	        this ();
	        System. out .println ( "Hello" + i );
	        }
	     }*/
