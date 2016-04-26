package com.lisl.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given n pairs of parentheses, write a function to generate all combinations 
 * of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GenerateParentheses {
	public static final char LB = '(';
    public static final char RB = ')';
    
	public static List<String> generateParenthesis1(int n) {
		List<String> res = new ArrayList<String>();
		Set<String> set = new HashSet<String>();
		if(n==0){
			return res;
		}
		set.add("()");
		for(int i=1;i<n;i++){
			Set<String> temp = new HashSet<String>();
			for(String s : set){
				for(int j=1;j<s.length()+1;j++){
					String ss = s.substring(0,j)+"()"+(j==s.length()?"":s.substring(j));
					temp.add(ss);
				}
			}
			set.clear();
			set.addAll(temp);
		}
		res.addAll(set);
        return res;
    }
	
	public void addToResult(int left, int unclosed, List<String> r, String temp){
        if(left == 0 && unclosed == 0){
             r.add(temp);
        }else if(unclosed == 0 && left != 0){
            addToResult(left-1, unclosed+1, r, temp + LB);
        }else if(unclosed!=0 && left == 0){
            addToResult(left, unclosed-1, r, temp + RB);
        }else{
            addToResult(left-1, unclosed+1, r, temp + LB);
            addToResult(left, unclosed-1, r, temp + RB);
        }
    }
	
	public List<String> generateParenthesis2(int n) {
        List<String> r = new ArrayList<String>();
        addToResult(n, 0, r, "");
        return r;
    }
	public static void main(String[] args) {
		System.out.println(generateParenthesis1(4).toString());
	}
}
