package demo.com.jay.duplicate;

public class DuplicateCharacters {

	public static void main(String[] args) {
		
        test2();  
    }
	
	private static void test2() {
		
		String msg="great rrresponsibility rr";
		
		System.out.println(msg);
		int count=0;
		char[] msg1 = msg.toCharArray();
		for(int i=0;i<msg1.length;i++) {
			count=1;
			for(int j=i+1;j<msg1.length;j++) {
				
				if(msg1[i]==msg1[j]  && msg1[i]!=' ') {
					count++;
					msg1[j]='0';
				}
			}
			
			if (count>1 && msg1[i]!='0') {
				
				System.out.println(msg1[i] +"="+count);
			}

		}
	}
	
	
private static void test3() {
		
		String msg="great is great rr is tt is";
		
		System.out.println(msg);
		int count=0;
		 String[] split = msg.split(" ");
		for(int i=0;i<split.length;i++) {
			count=1;
			for(int j=i+1;j<split.length;j++) {
				
				if(split[i].trim().equals(split[j].trim() )) {
					count++;
					split[j]="0";
				}
			}
			
			if (count>1 && !split[i].equals("0")) {
				
				System.out.println(split[i] +"="+count);
			}

		}
	}
	
	private static void test() {
		String str = "Great responsibility";  
        int count;  
          
        //Converts given string into character array  
        char[] string1 = str.toCharArray();  
          
       System.out.println("Duplicate characters in a given string: ");  
        //Counts each character present in the string  
        for(int i = 0; i <string1.length; i++) {  
            count = 1;  
            for(int j = i+1; j <string1.length; j++) {  
                if(string1[i] == string1[j] && string1[i] != ' ') {  
                    count++;  
                    //Set string1[j] to 0 to avoid printing visited character  
                    string1[j] = '0';  
                }  
            }  
            //A character is considered as duplicate if count is greater than 1  
            if(count > 1 && string1[i] != '0')  
                System.out.println(string1[i]);  
        }
	}  
}
