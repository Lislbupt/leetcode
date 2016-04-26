package com.lisl.code;

public class SingleNumber {
	public static int singleNumber(int[] nums) {
		int res = 0;
		for(int i:nums){
			res ^= i;     //1^2^1^2^3=1^1^2^2^3=3
		}
        return res;
    }
	
	public static void main(String[] args) {
		int a[] = {1,2,1,2,3};
		System.out.println(singleNumber(a));
	}
}
