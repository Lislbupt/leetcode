package com.lisl.code;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the 
 * length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has 
 * length = 2.
 * Another example is ")()())", where the longest valid parentheses 
 * substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {
	public static int longest(String s,int index,int rightNums){
		int len = s.length();
		int res = 0;
		int unClose = 0;
		for(int i=index;i<len;i++){
			if(s.charAt(i)=='('){
				unClose++;
				if(unClose>rightNums || unClose>(len-i)/2){
					return res;
				}
			}else if(unClose==0){
				return res;
			}else{
				unClose--;
				if(unClose==0){
					res = i - index + 1;
				}
			}
		}
		return res;
	}
	
	public static int longestValidParentheses1(String s) {
		int len = s.length();
		int res = 0;
		int rightNums = 0;
		for(int i=0;i<len;i++){
			if(s.charAt(i)==')'){
				rightNums++;
			}
		}
		for(int i=0;i<len;i++){
			int temp = longest(s, i,rightNums);
			if(temp>res){
				if(temp==len-i){
					return temp;
				}else{
					res = temp;
				}
			}
		}
        return res;
    }
	
	public static void explode(String s,int center,int[] res){
		int s_len = s.length(),left_begin=center-1,right_begin=center+2;
		boolean direct = true,leftIsClose = true,rightIsClose = true;
		boolean leftIsEnd = false,rightIsEnd = false;
		
		while(true){
			if(left_begin<0){
				leftIsEnd = true;
			}
			if(right_begin==s_len){
				rightIsEnd = true;
			}
			if(leftIsEnd && rightIsEnd){
				res[0] = right_begin-left_begin-1;
				res[1] = right_begin;
				return;
			}
			if(direct){
				if(rightIsEnd){
					direct = false;
					continue;
				}
				int unClose = 0;
				for(int i=right_begin;i<s_len;i++){
					if(s.charAt(i)=='('){
						unClose++;
					}else if(unClose==0){
						if(leftIsClose){
							if(leftIsEnd){
								rightIsEnd = true;
								break;
							}
							direct = false;
							rightIsClose = false;
							break;
						}else{
							leftIsClose = true;
							left_begin--;
							right_begin++;
						}
					}else{
						unClose--;
						if(unClose==0){
							right_begin = i + 1;
						}
					}
					if(i==s_len-1){
						rightIsEnd = true;
						direct = false;
					}
				}
			}else{
				if(leftIsEnd){
					direct = true;
					continue;
				}
				int unClose = 0;
				for(int i=left_begin;i>=0;i--){
					if(s.charAt(i)==')'){
						unClose++;
					}else if(unClose==0){
						if(rightIsClose){
							if(rightIsEnd){
								leftIsEnd = true;
								break;
							}
							direct = true;
							leftIsClose = false;
							break;
						}else{
							rightIsClose = true;
							right_begin++;
							left_begin--;
						}
					}else{
						unClose--;
						if(unClose==0){
							left_begin = i - 1;
						}
					}
					if(i==0){
						leftIsEnd = true;
						direct = true;
					}
				}
			}
		}
	}
	//中心扩展(从'()'两边进行扩展)
	public static int longestValidParentheses2(String s) {
		int res = 0;
		int center = s.indexOf("()");
		while(center>-1){
			int[] log = new int[2];
			explode(s, center, log);
			int temp = log[0];
			res = temp>res?temp:res;
			center = s.indexOf("()", log[1]);
		}
		return res;
	}
	
	//二维动态规划，O(n2)，Time Limited
	public static int longestValidParentheses3(String s) {
		int len = s.length();
		int maxLength = 0;
		boolean[][] valid = new boolean[len][len];	//valid[i][j]=true表示s从i到j有效
		for(int i=0;i<len-1;i++){
			if(s.charAt(i)=='(' && s.charAt(i+1)==')'){
				valid[i][i+1] = true;
				maxLength = 2;
			}
		}
		if(maxLength==0){
			return maxLength;
		}
		for(int i=4;i<=len;i+=2){
			for(int j=0;j<=len-i;j++){
				boolean flag = false;
				if(valid[j][j+i-3] && valid[j+i-2][j+i-1]){
					flag = true;
				}else if(valid[j+2][j+i-1] && valid[j][j+1]){
					flag = true;
				}else if(valid[j+1][j+i-2] && s.charAt(j)=='(' && s.charAt(j+i-1)==')'){
					flag = true;
				}
				if(flag){
					maxLength = i;
					valid[j][j+i-1] = true;
				}
			}
			if(maxLength!=i){
				return maxLength;
			}
		}
        return maxLength;
    }
	//O(2n),Time Limited 
	public static int longestValidParentheses4(String s){
		int len = s.length();
		int maxLength = 0;
		boolean[] isMatched = new boolean[len];
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<len;i++){
			if(s.charAt(i)=='('){
				stack.push(i);
			}else if(!stack.isEmpty()){
				isMatched[i] = true;
				isMatched[stack.pop()] = true;
			}
		}
		int maxMatch = 0;
		for(int i=0;i<len;i++){
			if(isMatched[i]){
				maxMatch++;
			}else{
				maxLength = maxMatch>maxLength?maxMatch:maxLength;
				maxMatch = 0;
			}
		}
		maxLength = maxMatch>maxLength?maxMatch:maxLength;
		return maxLength;
	}
	//一维动态规划，O(n)
	public static int longestValidParentheses5(String s){
		int len = s.length();
		int maxLength = 0;
		int[] maxMatch = new int[len];	//maxMatch[i]表示从开始到结尾可以匹配到的最大长度
		for(int i=len-2;i>=0;i--){
			if(s.charAt(i)=='('){
				int j = i+1+maxMatch[i+1];
				if(j<len && s.charAt(j)==')'){
					maxMatch[i] = maxMatch[i+1]+2;
					if(j+1<len){
						maxMatch[i] += maxMatch[j+1];
					}
				}
			}
			maxLength = maxMatch[i]>maxLength?maxMatch[i]:maxLength;
		}
		return maxLength;
	}
	
	public static void main(String[] args) {
		String s = "()(";
//		System.out.println(longestValidParentheses1(s));
		System.out.println(longestValidParentheses2(s));
	}
}
