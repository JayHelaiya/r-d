package demo.com.jay.collaction.map;

import java.util.HashMap;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		HashMap<Integer, String> map=new HashMap<>();
		map.put(1, "jay");
		map.put(8, "dip");
		map.put(5, "reeya");
		map.put(3, "sandeep");
		
		Set<Integer> keySet = map.keySet();
		
		for (Integer key : keySet) {
			System.out.println(key+"="+map.get(key));
		}
		
	}
}
