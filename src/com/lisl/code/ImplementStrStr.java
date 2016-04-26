package com.lisl.code;

/**
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 
 * if needle is not part of haystack.
 */
public class ImplementStrStr {
	public static boolean equals(String haystack, String needle,int begin){
		for(int i=0;i<needle.length();i++){
			if(haystack.charAt(i+begin)!=needle.charAt(i)){
				return false;
			}
		}
		return true;
	}
	
	public static int strStr(String haystack, String needle) {
		if(haystack.equals("") && needle.equals("")){
			return 0;
		}
		if(haystack.length()<needle.length()){
			return -1;
		}
		for(int i=0;i<=haystack.length()-needle.length();i++){
			if(equals(haystack,needle,i)){
				return i;
			}
		}
        return -1;
    }
	
	public static void main(String[] args) {
		System.out.println(strStr("abcdbcd", "e"));
	}
}
