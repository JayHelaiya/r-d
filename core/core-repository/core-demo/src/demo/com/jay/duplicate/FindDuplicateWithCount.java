package demo.com.jay.duplicate;

import java.util.Map;
import java.util.TreeMap;

public class FindDuplicateWithCount {
	
	static int count=0;
	public static void main(String[] args) {
		
		String value="hellow welcome to java";
		char[] charArray = value.toCharArray();
		
		Map<Character, Integer> map=new TreeMap<>();
		
		for (char c : charArray) {
			
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
		}
		
		System.out.println(map);
		
	}
}
