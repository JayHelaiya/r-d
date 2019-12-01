package demo.com.jay.duplicate;

import java.util.LinkedHashSet;

public class RemoveDuplicateFromString {
	
	public static void main(String[] args) {
		
		String msg= "geeksforgeeks"; 
		removeDuplicate(msg); 
	}
	
	public static void removeDuplicate(String value) 
	{ 
		char[] charArray = value.toCharArray();
		LinkedHashSet<Character> characters=new LinkedHashSet<>();
		
		for (char c : charArray) {
			characters.add(c);
		}
		
		System.out.println(characters);
		
	} 
}
