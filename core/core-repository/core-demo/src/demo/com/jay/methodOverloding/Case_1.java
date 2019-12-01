package demo.com.jay.methodOverloding;

public class Case_1 {

	static int add(int a, int b) {
		return a + b;
	}

	static double add(int a, int b) {
		return a + b;
	}
}

class TestOverloading3 {
	public static void main(String[] args) {
		System.out.println(Case_1.add(11, 11));// ambiguity
	}
}


/*

Compile Time Error: method add(int,int) is already defined in class Adder

System.out.println(Adder.add(11,11)); //Here, how can java determine which sum() method should be called?

Note: Compile Time Error is better than Run Time Error. So, 
      java compiler renders compiler time error if you declare the same method having same parameters.

*/