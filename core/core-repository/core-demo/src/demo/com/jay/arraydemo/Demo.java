package demo.com.jay.arraydemo;

public class Demo {
	
	public static void main(String[] args) {
		
		//int x[]=new int[]; //compiletime error  . size is required at creation time
		//int[0] x3;  //compiletime error  . size is not required at  variable declaring time
		int[] x=new int[0];
		int x1[]=new int[0];
		int []x2=new int[0];
		
		//int []x3=new int[-3]; // run time exception // java.lang.NegativeArraySizeException
		int []x4=new int['a']; // a=97 ancci value take 
		
		byte b=10;
		int []x6=new int[b];
		long l=10;
		short s=0;
		long []x7=new long[s];
		//int []x7=new int[l];//  //compile time // type dismatch;
		
		//x[0]=10; // runtime error .java.lang.ArrayIndexOutOfBoundsException:
		
		//int []x8=new int[2939394949494;  //compile time // The literal 2939394949494 of type int is out of range 
		
		
		System.out.println(x6.length);
	}
}
