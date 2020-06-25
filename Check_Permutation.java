

//Given two strings, write a method to decide if one is a permutation of the other

// Constraint: Comparison is case sensitive and white space is significant
 

import java.util.*;
public class Check_Permutation {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		String a,b;
		boolean flag;
		a=sc.nextLine();
		b=sc.nextLine();
		flag=permutation(a,b);
		
		if(flag)
			System.out.println("String "+a+" is a permutation of string "+b);
		else
			System.out.println("String "+a+" is not a permutation of string "+b);
	}
	
	static boolean permutation(String s,String t) {
		if(s.length()!=t.length())
			return false;
		return sort(s).equals(sort(t));
	}
	
	static String sort(String s) {
		char []sorted=s.toCharArray();
		java.util.Arrays.sort(sorted);
		return new String(sorted);
	}
}

