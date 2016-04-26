package com.lisl.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a digit string, return all possible letter combinations that the 
 * number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is 
 * given below.
 */
public class LetterCombinationsOfAPhoneNumber {
	private static Map<Character,String> map = new HashMap<Character,String>();
	
	static{
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
	}
	
	public static List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		int len = digits.length();
		if(len==0){
			return res;
		}
		int indexs[] = new int[len];
		int total = 1;
		for(int i=0;i<len;i++){
			int temp = map.get(digits.charAt(i)).length();
			indexs[i] = temp-1;
			total *= temp;;
		}
		int index_copy[] = indexs.clone();
		for(int i=0;i<total;i++){
			StringBuilder s = new StringBuilder();
			for(int j=0;j<len;j++){
				char ch = digits.charAt(j);
				s.append(map.get(ch).charAt(indexs[j]));
			}
			res.add(s.toString());
			for(int j=len-1;j>=0;j--){
				if(indexs[j]==0){
					indexs[j] = index_copy[j];
				}else{
					indexs[j]--;
					break;
				}
			}
			
		}
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(letterCombinations("").toString());
	}
}
