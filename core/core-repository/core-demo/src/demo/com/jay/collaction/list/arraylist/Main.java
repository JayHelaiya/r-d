package demo.com.jay.collaction.list.arraylist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
	
		ArrayList<String> list =new ArrayList<>();
		list.add("jay");
		list.add("sip");
		list.add("jay");
		list.add(null);
		
		System.out.println(list);
		
		HashSet<String> set =new HashSet<>();
		set.add("jay");
		set.add("sip");
		set.add("jay");
		set.add("anus");
		
		

		LinkedList<String> list1 =new LinkedList<>(set);
			
		System.out.println(list1);
		
	}
}
