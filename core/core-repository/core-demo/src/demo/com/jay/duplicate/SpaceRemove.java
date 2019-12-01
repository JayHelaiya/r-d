package demo.com.jay.duplicate;

public class SpaceRemove {

	public static void main(String[] args) {
		
		System.out.println(removeSpace("Jayesh Helaiya"));
	}
	
	public  static String removeSpace(String value) {
		
		char[] charArray = value.toCharArray();
		
		for(int i=0;i<charArray.length;i++) {
			//System.out.print(i+"="+charArray[i]+",");
			
			if(charArray[i]==' ') {
				int j;
				for(j=i;j<charArray.length-1;j++) {
					
					charArray[j]=charArray[j+1];
				}
				charArray[j]=' ';
			}
		}
		System.out.println(charArray);
		return null;
	}
}
