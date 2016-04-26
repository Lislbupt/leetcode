package com.lisl.code;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', 
 * '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all 
 * valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
	public boolean match(char l,char r){
		if(l=='{' && r=='}'){
			return true;
		}
		if(l=='[' && r==']'){
			return true;
		}
		if(l=='(' && r==')'){
			return true;
		}
		return false;
	}
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			if(ch=='{' || ch=='[' || ch=='('){
				stack.push(ch);
			}else{
				if(stack.empty()){
					return false;
				}
				char top = stack.pop();
				if(!match(top, ch)){
					return false;
				}
			}
		}
		if(stack.empty()){
			return true;
		}
        return false;
    }
	public static void main(String[] args) {
		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValid("]"));
	}
}
