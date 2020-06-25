
//Implement an algorithm to determine if a string has all unique characters. 

//Here character set is ASCII

import java.util.*;
public class Is_Unique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str;
		boolean flag;
		System.out.println("Enter a string");
		str=sc.nextLine();
		flag=isUniqueChars(str);
		System.out.print(flag);
		
	}
	static boolean isUniqueChars(String str) {
		if(str.length()>128)
			return false;
		
		boolean[]char_set=new boolean[128];
		for(int i=0;i<str.length();i++) {
			int val=str.charAt(i);
			if(char_set[val])
				return false;
			char_set[val]=true;
		}
		return true;
	}
}
