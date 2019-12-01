package demo.com.jay.duplicate;

public class DuplicateCharacters2 {

	public static void main(String[] args) {
		
        test2();  
    }
	
	private static void test2() {
	
		int[] anciTable=new int[128];// default value 0 
		
		/*for (int i = 0; i < anciTable.length; i++) {
			System.out.println(anciTable[i]);
		}
		*/
		String name="jayesh helaiya jay";
		
		char[] charArray = name.toCharArray();
		
		for (int i = 0; i < charArray.length; i++) {
			anciTable[charArray[i]]++;
		}
		
		for (int i = 0; i < anciTable.length; i++) {
			if(anciTable[i]!=0) {
				System.out.println((char)i+"="+anciTable[i]);
			}
		}
		
	}
	
	
}
