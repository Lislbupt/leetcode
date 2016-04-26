package com.lisl.code;

/**
 * Given an array S of n integers, find three integers in S such that 
 * the sum is closest to a given number, target. Return the sum of the 
 * three integers. You may assume that each input would have exactly one 
 * solution.
 */
public class Sum3Closest {
	public static int threeSumClosest1(int[] nums, int target) {
		int len = nums.length;
		int dif = 0;
		int dif_abs = Integer.MAX_VALUE;
		for(int i=0;i<len-2;i++){
			int left = nums[i];
			for(int j=i+1;j<len-1;j++){
				int mid = nums[j];
				int sum2 = left + mid;
				int right = target - sum2;
				for(int k=j+1;k<len;k++){
					int _right = nums[k];
					int _dif = right-_right; 
					if(_dif==0){
						return target;
					}
					int _dif_abs = Math.abs(_dif);
					if(_dif_abs<dif_abs){
						dif_abs = _dif_abs;
						dif = _dif;
					}
				}
			}
		}
		return target-dif;
    }

	
	public static void main(String[] args) {
		int[] nums = {0,0,0};
		System.out.println(threeSumClosest1(nums, 1));
	}
}
