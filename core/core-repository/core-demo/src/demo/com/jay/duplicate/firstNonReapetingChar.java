package demo.com.jay.duplicate;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class firstNonReapetingChar {
	
	static int count=0;
	public static void main(String[] args) {
		
		String value="hellow welcome to java";
		System.out.println(nonReapeatingChar(value));
		
	}
	private static Character nonReapeatingChar(String value) {
		char[] charArray = value.toCharArray();
		
		Map<Character, Integer> map=new LinkedHashMap<>();
		
		for (char c : charArray) {
			
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
		}
		
		for(Entry<Character, Integer> entry: map.entrySet()){
			if(entry.getValue()==1) {
				return entry.getKey();
			}
		}
		throw new RuntimeException("didn't find any non repeated Character");
	}
}
