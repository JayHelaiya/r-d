package demo.com.jay.collaction;

import java.util.ArrayList;

public class demo1 {

	public static void main(String[] args) {
		
		ArrayList list =new ArrayList<>();
		list.add(new String("tiya"));
		list.add(new Integer("1"));
		list.add(new Character('c'));
		list.add(10);
		list.add(10.00);
		list.add("jay");
		list.add('r');
		
		System.out.println(list);
		
		byte b=10;
		
		int[] no=new int[5];
		no[0]=new Integer(10);
		no[1]=10;
		no[2]='c';  /// anccii value
		//no[3]="jay";  // Type mismatch: cannot convert from String to int
		//no[3]=new String("ja");// // Type mismatch: cannot convert from String to int
		
		no[3]=b;
		no[4]=new Character('j');
		
		System.out.println(no);
		
		for (int i = 0; i < no.length; i++) {
			System.out.println(no[i]);
		}
	}
}
