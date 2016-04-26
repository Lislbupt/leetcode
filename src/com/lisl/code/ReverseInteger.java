package com.lisl.code;

import java.util.ArrayList;

/**
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * if overflow return 0
 */
public class ReverseInteger {
	public static int reverse1(int x) {
		StringBuilder s;
		try {
			if(x<0){
				s = new StringBuilder(-1*x+"");
				return Integer.parseInt(s.reverse().toString())*-1;
			}else{
				s = new StringBuilder(x+"");
				return Integer.parseInt(s.reverse().toString());
			}
		} catch (NumberFormatException e) {
			return 0;
		}
    }
	
	public static int reverse2(int x) {
		int[] pattern = {2,1,4,7,4,8,3,6,4,8};
		ArrayList<Integer> data = new ArrayList<Integer>();
		int res = 0;
		while(x!=0){
			int end = x%10;
			data.add(end);
			x /= 10;
		}
		boolean flag = true;
		int data_len = data.size();
		int pat_len = pattern.length;
		if(data_len<pat_len){
			for(int i=0;i<data_len;i++){
				res += data.get(i)*Math.pow(10, data_len-i-1);
			}
		}else if(data_len==pat_len){
			for(int i=0;i<data_len;i++){
				int v = data.get(i);
				int temp = Math.abs(v);
				if(flag && temp>pattern[i]){
					return 0;
				}else if(temp<pattern[i]){
					flag = false;
				}
				res += v*Math.pow(10, data_len-i-1);
			}
		}else{
			return 0;
		}
		return res;
    }
	
	public static void main(String[] args) {
		int a = 1147483312;
//		System.out.println(reverse1(a));
		System.out.println(reverse2(a));
	}
}
