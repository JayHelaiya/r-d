package demo.com.jay.duplicate;

public class FindVowels {
	
	public static void main(String[] args) {

		String value="How many vowels in this String";
		System.out.println(vowel(value));
	}

	public static String vowel(String value) {

		char[] charArray = value.toCharArray();
		int count=0;
		
		for (char c : charArray) {
			switch (c) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			count++;
			default:
			}
		}
		System.out.println("vowel counts = "+count);
		return value;
	}
}
