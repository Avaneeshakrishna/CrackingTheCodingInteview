/**
 * 
 */

/* PROBLEM STATEMENT: 
 * 					 There are three types of edits can be performed on strings: insert a character, remove a character, or replace a
 * character. Given two strings, write a function to check if they are one edit (or zero edits) away.
 * 
 * EXAMPLE
 * 			pale,    ple    -> true, because we can insert a character to the second string : i.e insert 'a' to second string
 * 			pales,   pale   -> true, because we can remove a character from the first string : i.e remove 's' from first string
 * 			pale,    bale   -> true, because we can replace a charcter from the second string : i.e replace 'b' from second string
 * 
 * SOLUTION
 * 			What does it mean for two strings to be one insertion, replacement, or removal away from each other
 * 
 * 			1. Replacement: Consider two strings, such as bale and pale, that are one replacement away. It means that you could replace a character in bale to make pale.
 * 
 * 			2. Insertion: The strings apple and aple are one insertion away. It means that you could insert a character to aple to become apple.
 * 
 * 			3. Removal: The strings apple and aple are also one removal away, since removal is just the inverse of insertion.
 * 
 * 			
 * 			"The length of the two strings will determine whether we need to perform insertion, removal or replacement"
 * 
 */
import java.util.*;
public class One_Away {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);						//create an object of scanner class to read input
		String first = sc.nextLine(); 							//read first string
		String second = sc.nextLine();							//read second string
		
		if(first.length()==second.length()) {                                          	//to hold 1. Replacement strings must be equal
			boolean flag = oneEditReplace(first,second);            		//call a function
			if(flag)                                                       
				System.out.println("Strings are one replace Away");
			else                                                           
				System.out.println("Strings are not one edit Away");
		}
		else if(first.length()+1==second.length()) {                  			//if second string is is grater than first by 1, then we need to remove a charater from first string
			boolean flag1 = oneEditInsert(first,second);             		//call a function
			if(flag1) 														
				System.out.println("Strings are one Edit Away");
			else                                                           
				System.out.println("Strings are not one edit Away");
		}
		else if(first.length()-1==second.length()) {                  			//if first string is is grater than fsecond by 1, then we need to remove a charater from second string
			boolean flag2 = oneEditInsert(second,first);              		//we now that removal is a INVERSE of insertion, I done insertion method but while calling the function
			if(flag2)								// I swapped the two strings.
				System.out.println("Strings are one Insert Away");
			else 
				System.out.println("Strings are not one edit Away");
		}
		else {
			System.out.println("Strings are not one edit Away");
		}

	}
	static boolean oneEditReplace(String s1, String s2) {
		boolean foundDifference = false;
		for(int i=0;i<s1.length();i++) {                             			//loop through the string and compare every characetr, 
		if(s1.charAt(i)!=s2.charAt(i)) {                             			// if characters are same make foundDifference as true and compare next character, 
				if(foundDifference) {                                		//if your string has more than one character difference then it should return false. 
					return false;						//This line handles that case
				}
				foundDifference=true;
			}
		}
		return true;
	}
	
	static boolean oneEditInsert(String s1, String s2) {
		int index1=0, index2=0;                                      			//initialize two indexes with zero: index2 -> s2 and index1 -> s1
		while(index2<s2.length() && index1<s1.length()) {            			//loop until these pointers are greater than string lengths
			if(s1.charAt(index1)!=s2.charAt(index2)) {               		//Our aim is to check that one non-equal character:compare each character of the 
				if(index1!=index2) {                                		//strings with the pointer, if both chars are same just increment the pointers. If not check the pointers, if
					return false;                                   	// they are equal just increment the second pointer
				}								//if not it means that strings are not one edit away so return false.
				index2++;
			}
			else {
				index1++;
				index2++;
			}
		}
		
		return true;                                              
	}
}























