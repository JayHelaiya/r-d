package demo.com.jay.collaction;

import java.util.ArrayList;

public class Main {

		public static void main(String[] args) {
			
			ArrayList<Integer> list=new ArrayList<>();
			list.add(1);
			list.add(2);
			list.add(3);
			list.add(4);
			
			ArrayList<Integer> list2=new ArrayList<>();
			list2.add(1);
			list2.add(2);
			list2.add(5);
			list2.add(6);
			
			System.out.println(list);
			System.out.println(list2);
			
			list.retainAll(list2);	
			
			System.out.println("--------------after retain---------------");
			
			System.out.println(list);
			System.out.println(list2);
			
		}
}
