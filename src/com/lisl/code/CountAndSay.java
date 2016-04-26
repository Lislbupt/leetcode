package com.lisl.code;

import java.util.ArrayList;

/**
 * The count-and-say sequence is the sequence of integers beginning as 
 * follows:
 * 1, 11, 21, 1211, 111221, 312211 ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 */
public class CountAndSay {
	private static ArrayList<String> strs;
	
	static{
		strs = new ArrayList<String>();
		strs.add("1");
	}
	
	public String countAndSay(int n) {
		int size = strs.size();
		if(n<=size){
			return strs.get(n-1);
		}
		String str = strs.get(size-1);
		for(int i=size;i<n;i++){
			int len = str.length();
			StringBuilder temp = new StringBuilder();
			for(int j=0;j<len;j++){
				char ch = str.charAt(j);
				int count = 1;
				for(int k=j+1;k<len;k++){
					if(str.charAt(k)==ch){
						count++;
					}else{
						j = k-1;
						break;
					}
					if(k==len-1){
						j = k;
					}
				}
				temp.append(count+""+ch);
			}
			str = temp.toString();
			strs.add(str);
		}
        return str;
    }
	
	public static void main(String[] args) {
		CountAndSay cas = new CountAndSay();
		System.out.println(cas.countAndSay(6));
	}
}
