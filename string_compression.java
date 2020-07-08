/*
PROBLEM STATEMENT: String Compression
              
              " Implement a method to perform basic string compression using counts of repeated characters. For example, the string 'aabcccccaaa" would become a2b1c5a3.
              If the "compressed" string would not become smaller than the original string, your method should return the original string. You can assume the string 
              has only uppercase and lowercase letters."
              

EXAMPLE:      1. aabcccccaaa    -->     a2b1c5a3    - correct example

              2. aaaAAbbbbbb    -->     a2A2b5      - corret example
              
              3. aabb           -->     aabb        - the compressed string length is equal to the original string, so return original string

              4. aab            -->     aab         - the compressed string length is less than the original string, so return original string




*/


import java.util.*;
public class string_compression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);                                     		// creating object of the scanner to read inputs
		System.out.println("Enter one string");
		String str = sc.nextLine();                                              		// reading input
		
		String res = compress(str);                                              		// calling compress method with one parameter i.e our input
		System.out.println("The resultedd string is = "+ res);
		
	}
	 public static String compress(String s) {                                   			// compress method definition here
		int finalLength = countCompression(s);                                   		// call a function countCompress with our input as the parameter. finalLength holds the exact length of the compressed (resultant) string should hold
		if(finalLength >= s.length())                                            		// as said in the problem if finalLength > input string's length we should return the original string
			return s;
		
		StringBuilder compressed = new StringBuilder(finalLength);               		// creating string builder
		int countConsecutive = 0;                                               		// this is used to count the occurence of the character
		for (int i = 0; i < s.length(); i++) {                                   		// loop through the string
			countConsecutive++;                                                  		// increment counter for the current character
			
			if(i+1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {            		// 2 if conditions with OR opertor. one checks if you are at last but one character and the other compares if the current and next characters are different
				compressed.append(s.charAt(i));                                  	// if so, append the current character to the string builder compress
				compressed.append(countConsecutive);                             	// also append its total number of occurence
				countConsecutive = 0;                                            	// make countConsecutive to zero, because we need to count the next character
			}
			
		}
		return compressed.toString();                                           	 	// return the result by converting it to string
	}
	 public static int countCompression(String str) {                            			// countCompress method definition here
		 int compressedLength = 0;                                               		// compressedLength holds the exact length of the compressed (resultant) string should hold
		 int countConsecutive = 0;                                               		// this is used to count the occurence of the character
		 for (int i = 0; i < str.length(); i++) {                               		// loop through the string to count the occurence of the character
			 countConsecutive++;                                                       	// increment counter for the current character
			 
			 if(i+1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {            	//  2 if conditions with OR opertor. one checks if you are at last but one character and the other compares if the current and next characters are different
				 compressedLength += 1 + String.valueOf(countConsecutive).length();     // update the compressedLength, here valueOf is used to convert int to string and its length is returned here                                  
				 countConsecutive = 0;                                                  // make countConsecutive to zero, because we need to count the next character
			 }
		 }
		 return compressedLength;                                                     		// return length of the compressed (resultant) string
	 }

}
