package com.jay.core.ShallowCopy;

import java.util.Arrays;


 class ShallowCopy {
	
	private int[] data;
	
	public ShallowCopy(int[] data) {
		this.data=data;
	}
	
	public void showData() { 
        System.out.println( Arrays.toString(data) ); 
    } 
}

//------------------------------------------ 
 
 public class ShallowCopyDemo {
		
		public static void main(String[] args) {
			
			int[] value= {2,5,4};
			ShallowCopy copy=new ShallowCopy(value);
			copy.showData();
			value[1]=8;
			copy.showData();
		}
		
	}


