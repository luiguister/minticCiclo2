public class Solution {
	public static String runLengthEncoding(String input) {
		int count = 0;
		String input2 = "";
		
		//Converts given string into character array  
	    char string[] = input.toCharArray();  
	    System.out.println("Duplicate characters in a given string: ");  
	    //Counts each character present in the string
	    for(int i = 0; i <string.length; i++) {
	    	count = 1;  
	        for(int j = i+1; j <string.length; j++) {
	        	if(string[i] == string[j] && string[i] != '0') {
	        		count++;  
	                //Set string[j] to 0 to avoid printing visited character  
	                string[j] = '0'; 
	            }  
	        }
	        //A character is considered as duplicate if count is greater than 1  
	        if(count == 1 && string[i] != '0') 
	        	input2 += string[i];
	        else if(count > 1 && string[i] != '0')
	        	input2 += String.valueOf(count)+string[i];
	    }
	    return input2;
	}
	/*public static void main(String[] args) {
    	System.out.println(runLengthEncoding("aaabbcdddd"));  
    	
    }*/
}