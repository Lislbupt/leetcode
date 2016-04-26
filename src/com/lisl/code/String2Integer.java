package com.lisl.code;

/**
 * Implement atoi to convert a string to an integer.
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until 
 * the first non-whitespace character is found. Then, starting from this character, 
 * takes an optional initial plus or minus sign followed by as many numerical digits 
 * as possible, and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral 
 * number, which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral 
 * number, or if no such sequence exists because either str is empty or it contains 
 * only whitespace characters, no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned. If the 
 * correct value is out of the range of representable values, INT_MAX (2147483647) or 
 * INT_MIN (-2147483648) is returned.
 */
public class String2Integer {
	public static int myAtoi(String str) {
		str = str.trim();
		if(str.equals("")){
			return 0;
		}
		StringBuilder target = new StringBuilder();
		char first = str.charAt(0);
		if(first!='+' && first!='-'){
			first = '0';
		}else{
			str = str.substring(1);
		}
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if(ch=='+' || ch=='-'){
				return 0;
			}
			if(ch>47 && ch<58){
				target.append(ch);
			}else{
				break;
			}
		}
		if(target.length()==0){
			return 0;
		}
		
		if(target.length()>10){
			return first=='-'?Integer.MIN_VALUE:Integer.MAX_VALUE;
		}else if(target.length()==10){
			if(first=='-'){
				if(target.toString().compareTo("2147483648")>0){
					return Integer.MIN_VALUE;
				}
			}else if(target.toString().compareTo("2147483647")>0){
				return Integer.MAX_VALUE;
			}
		}
		return Integer.parseInt(first+target.toString());
    }
	
	public static void main(String[] args) {
		String s = "";
		System.out.println(myAtoi(s));
	}
}
