package demo.com.jay.arraydemo;

public class MissingNumber {
	
	public static void main(String[] args) {
		 int[] input = { 1, 1, 2, 3, 5, 5, 7, 9, 9, 9 };

		 findMissingNumber(input);
		 //missingNumber(input);
	}
	
	private static void findMissingNumber(int[] numArray) {
		
		int[] register=new int[numArray.length];
		
		//[0, 1, 1, 1, 0, 1, 0, 1, 0, 1]
		for (int i : numArray) {
			register[i]=1;
		}
		
		for(int i=1;i<register.length;i++) {
			
			if(register[i]==0) {
				System.out.println(i);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

	/*private static void missingNumber(int[] input) {
		int[] register = new int[input.length];
		 
		 for (int i : input) {
			 register[i] = 1; 
			 }

		 System.out.println("missing numbers in given array");

		 for (int i = 1; i < register.length; i++) { 
			 if (register[i] == 0) { 
				 System.out.println(i);
			 } 
		}
	}*/
}
