package com.lisl.code;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 */
public class RegularExpressionMatching {
	public static boolean isMatch1(String s, String p) {
		int s_ptr = 0;
		int s_len = s.length();
		int p_len = p.length();
		char ch = ' ';
		int ch_count = 0;
		if(s_len==0 && p_len==0){
			return true;
		}
		for(int i=0;i<p_len;i++){
			char cur = p.charAt(i);
			char next;
			if(i==p_len-1){
				next = ' ';
			}else{
				next = p.charAt(i+1);
			}
			if(cur!='.'){
				if(next!='*'){
					if((cur==ch || cur=='.') && ch_count>0){
						ch_count--;
					}else{
						ch = ' ';
						ch_count = 0;
						if(s_ptr<s_len && s.charAt(s_ptr)!=cur){
							return false;
						}else{
							s_ptr++;
						}
					}
				}else{
					if(s_ptr<s_len && s.charAt(s_ptr)==cur){
						ch = cur;
						while(s_ptr<s_len && s.charAt(s_ptr)==cur){
							s_ptr++;
							ch_count++;
						}
					}
					i++;
				}
			}else{
				if(next!='*'){
					if(s_ptr>=s_len){
						return false;
					}
					s_ptr++;
				}else{
					for(int k=s_ptr;k<s_len;k++){
						if(isMatch1(s.substring(k), p.substring(i+2))){
							System.out.println("---");
							return true;
						}
					}
					s_ptr = s_len;
					i++;
				}
			}
			if(s_ptr==s_len){
				if(next==' '){
					return true;
				}else{
					for(int j=i+1;j<p_len;j++){
						if((p.charAt(j)==ch || p.charAt(j)=='.') && ch_count>0){
							ch_count--;
						}else{
							if(j==p_len-1 || p.charAt(j+1)!='*'){
								return false;
							}else{
								j++;
							}
						}
					}
					return true;
				}
			}
		}
		return false;
    }
	
	public static boolean isMatch2(String s, String p) {
		Pattern pattern = Pattern.compile(p);
		Matcher m = pattern.matcher(s);
		return m.matches();
	}
	public static void main(String[] args) {
		String s = "aa";
		String pattern = "a";
//		System.out.println(isMatch1(s, pattern));
		System.out.println(isMatch2(s, pattern));
	}
}
