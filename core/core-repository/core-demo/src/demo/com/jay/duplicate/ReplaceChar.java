package demo.com.jay.duplicate;

public class ReplaceChar {


    static void translate(char str[]) 
    { 
        // Start traversing from second character 
        for (int i = 1; i < str.length; i++) 
        { 
            // If previous character is 'A' and 
            // current character is 'B" 
            if (str[i - 1] == 'A' && str[i] == 'B') 
            { 
                // Replace previous character with 
                // 'C' and move all subsequent 
                // characters one position back 
                str[i - 1] = 'C'; 
                int j; 
                for (j = i; j < str.length - 1; j++) 
                    str[j] = str[j + 1]; 
                str[j] = ' '; 
                  
            } 
        } 
        return; 
    } 
      
    // Driver code 
    public static void main(String args[]) 
    { 
        String st = "helloABworldABGfG"; 
        char str[] = st.toCharArray(); 
        translate(str); 
        System.out.println("The modified string is :"); 
        System.out.println(str); 
    } 
}
