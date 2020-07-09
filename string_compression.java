/*
PROBLEM STATEMENT: String Compression
              
              " Implement a method to perform basic string compression using counts of repeated characters. For example, the string 'aabbccc" would become a2b2c3.
              If the "compressed" string would not become smaller than the original string, your method should return the original string. You can assume the string 
              has only uppercase and lowercase letters."
              

EXAMPLE:      1. aabcccccaaa    -->     a2b1c5a3    - correct example

              2. aaaAAbbbbbb    -->     a3A2b5      - corret example
              
              3. aabb           -->     aabb        - the compressed string length is equal to the original string, so return original string

              4. aab            -->     aab         - the compressed string length is less than the original string, so return original string


*/


import java.util.*;
public class string_compression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);              				// creating scanner object to read the input
		String str;
		System.out.println("Enter the input string");
		str = sc.nextLine();								// reading the string input
		
		String result = compress(str);  						// calling a function named compress. Parameter passed is the string input
		
		System.out.println("The compressed string is " +result);			// Displaying the result
		
	}
	public static String compress (String str) {						// function definition
		StringBuilder compressed = new StringBuilder();					// creating the StringBuilder object to hold the result
		int countConsecutive = 0;							// this is used to count the occurrence of the characters
		for (int i = 0; i < str.length(); i++) {					// loop through the string and count the occurrence of each characters
			countConsecutive++;
			
			if(i + 1 >=str.length() || str.charAt(i) != str.charAt(i + 1)) {	// if next character is different than current, append this char to the result
				compressed.append(str.charAt(i));				// appending the current character
				compressed.append(countConsecutive);				// appending its count
				countConsecutive = 0;						// this is made zero because we need to go for next character in the string
			}
		}
		return compressed.length() < str.length() ? compressed.toString() : str;	// according to the problem, we need to chec the length of the compressed string. If that is less than the input string 
												// return compressed string. Otherwise return the original string
	}

}
