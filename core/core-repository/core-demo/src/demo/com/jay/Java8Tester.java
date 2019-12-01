package demo.com.jay;

public class Java8Tester {

	   public static void main(String args[]) {
		
	      MathOperation multiplication = ( a, b) -> { return a * b; };
	      
	      System.out.println(multiplication.operation(10, 20));
			
	      //with parenthesis
	      GreetingService greetService2 = (message,message1)-> {return message+"Jayesh";};
			
	      greetService2.sayMessage("Suresh","jayesh");
	   }
		
	   interface MathOperation {
	      int operation(int a, int b);
	   }
		
	   interface GreetingService {
	      String sayMessage(String message,String message1);
	   }
		
	}