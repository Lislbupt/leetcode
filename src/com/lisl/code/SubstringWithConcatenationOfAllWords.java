package com.lisl.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * You are given a string, s, and a list of words, words, that are all of the same 
 * length. Find all starting indices of substring(s) in s that is a concatenation 
 * of each word in words exactly once and without any intervening characters.
 */
public class SubstringWithConcatenationOfAllWords {
	public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
		if(words.length==0 || s==null){
			return res;
		}
		int len = words[0].length();
		int total = len*words.length;
		HashMap<String,Integer> strs = new HashMap<String,Integer>();
		for(String word : words){
			Integer num = strs.get(word);
			if(num==null){
				strs.put(word, 1);
			}else{
				strs.put(word, num+1);
			}
		}
		
		for(int i=0;i<=s.length()-total;i++){
			HashMap<String,Integer> strs_copy = new HashMap<String,Integer>(strs);
			boolean flag = true;
			for(int j=i;j<total+i;j+=len){
				String sub = s.substring(j,j+len);
				Integer num = strs_copy.get(sub);
				if(num==null || num==0){
					flag = false;
					break;
				}else{
					strs_copy.put(sub, num-1);
				}
			}
			if(flag){
				res.add(i);
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
		String s = "barfoobarfoobarman";
		String[] words = {"foo", "bar"};
		System.out.println(findSubstring(s, words));
	}
}
