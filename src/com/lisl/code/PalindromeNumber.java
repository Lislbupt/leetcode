package com.lisl.code;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
	public static boolean isPalindrome1(int x) {
		String x_str = x + "";
		int len = x_str.length();
		for(int i=0;i<len/2;i++){
			if(x_str.charAt(i)!=x_str.charAt(len-i-1)){
				return false;
			}
		}
        return true;
    }
	
	public static boolean isPalindrome2(int x) {
		long x_rev = 0;		//倒置后可能越界，故用long表示
		int y = x;
		while(y>0){
			x_rev = x_rev * 10 + y % 10;
			y /= 10;
		}
        return x==x_rev?true:false;
    }
	
	public static void main(String[] args) {
		int x = 12;
//		System.out.println(isPalindrome1(x));
		System.out.println(isPalindrome2(x));
	}
}
