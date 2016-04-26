package com.lisl.code;

/**
 * Write a function to find the longest common prefix string amongst an array 
 * of strings.
 */
public class LongestCommonPrefix {
	//time limited
	public static String longestCommonPrefix1(String[] strs) {
		if(strs.length==0){
			return "";
		}
		StringBuilder res = new StringBuilder();
		int index = 0;
		boolean flag = true;
		while(flag){
			char ch = ' ';
			boolean same;
			try {
				ch = strs[0].charAt(index);
				
				same = true;
				for(int i=1;i<strs.length;i++){
					if(strs[i].charAt(index)!=ch){
						same = false;
						break;
					}
				}
			} catch (Exception e) {
				flag = false;
				same = false;
			}
			if(same){
				index++;
				res.append(ch);
			}
		}
        return res.toString();
    }

	public static String commonPrefix(String a,String b){
		StringBuilder s = new StringBuilder();
		int len1 = a.length();
		int len2 = b.length();
		for(int i=0;i<Math.min(len1, len2);i++){
			char ch = a.charAt(i);
			if(ch==b.charAt(i)){
				s.append(ch);
			}else{
				break;
			}
		}
		return s.toString();
	}
	
	public static String longestCommonPrefix2(String[] strs) {
		int len = strs.length;
		if(len==0){
			return "";
		}
		if(len==1){
			return strs[0];
		}
		String common = commonPrefix(strs[0], strs[1]);
		for(int i=2;i<len;i++){
			if(common.equals("")){
				return "";
			}
			common = commonPrefix(common, strs[i]);
		}
        return common;
    }
	
	public static void main(String[] args) {
		String[] strs = {"","a"};
//		System.out.println(longestCommonPrefix1(strs));
		System.out.println(longestCommonPrefix2(strs));
	}
}
