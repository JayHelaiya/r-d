package com.jay.core.deepCopy;

import java.util.Arrays;


 class DeepCopy {
	
	private int[] data;
	
	public DeepCopy(int[] data) {
		this.data=new int[data.length];
		for (int i = 0; i < data.length; i++) {
			this.data[i]=data[i];
		}
	}
	
	public void showData() { 
        System.out.println( Arrays.toString(data) ); 
    } 
}

//------------------------------------------ 
 
 public class DeepCopyDemo {
		
		public static void main(String[] args) {
			
			int[] value= {2,5,4};
			DeepCopy copy=new DeepCopy(value);
			copy.showData();
			value[1]=8;
			copy.showData();
		}
		
	}


