package demo.com.jay.duplicate;

public class ReverseString {

	public static void main(String[] args) {

		String value="jayesh";
		System.out.println(reverseRecursively(value));
	}
	
	public static String reverse(String value) {
		
		String reverseValue="";
		char[] valueArr = value.toCharArray();
		
		for(int i=valueArr.length-1;i>=0;i--) {
			reverseValue=reverseValue+valueArr[i];
		}
		System.out.println(reverseValue);
		return reverseValue;
	}
	
	public static String  reverse1(String value) {
		
		StringBuffer bufferValue=new StringBuffer(value);
		StringBuffer reverse = bufferValue.reverse();
		return reverse.toString();
	}
	
	public static String reverseRecursively(String str) {

        //base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }

        return reverseRecursively(str.substring(1)) + str.charAt(0);

    }

}
