package com.lisl.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger {
	private Map<Character,Integer> romanMap;
	
	public RomanToInteger() {
		romanMap = new HashMap<Character,Integer>();
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);
	}
	public int romanToInt(String s) {
		int res = 0,len = s.length();
		for(int i=0;i<len;i++){
			int first = romanMap.get(s.charAt(i));
			int next = i==len-1?0:romanMap.get(s.charAt(i+1));
			
			if(first<next){
				res += next-first;
				i++;
			}else{
				res += first;
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
		String s = "MMMCMXCIX";
		RomanToInteger a = new RomanToInteger();
		System.out.println(a.romanToInt(s));
	}
}
