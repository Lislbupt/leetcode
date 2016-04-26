package com.lisl.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that 
 * a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a °‹ b °‹ c)
 * The solution set must not contain duplicate triplets.
 */
public class Sum3 {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> all = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int len = nums.length;
		int left_pre = 1;	//±‹√‚÷ÿ∏¥
		for(int i=0;i<len;i++){
			int left = nums[i];
			if(left>0){
				break;
			}
			if(left==left_pre){
				continue;
			}
			left_pre = left;
			int start = len-1;
			int mid_pre = 1-left;	//±‹√‚÷ÿ∏¥
			for(int j=i+1;j<len-1;j++){
				int mid = nums[j];
				int sum2 = left+mid;
				int right = 0-sum2;
				if(sum2>0){
					break;
				}
				if(mid==mid_pre){
					continue;
				}
				mid_pre = mid;
				for(int k=start;k>j;k--){
					int temp = nums[k];
					if(temp==right){
						List<Integer> triplet = new ArrayList<Integer>();
						triplet.add(left);
						triplet.add(mid);
						triplet.add(right);
						all.add(triplet);
						start = k-1;
						break;
					}else if(temp<right){
						start = k;
						break;
					}
				}
			}
		}
        return all;
    }
	
	public static void main(String[] args) {
		int[] nums = {0,0,0};
		List<List<Integer>> all = threeSum(nums);
		System.out.println(all.toString());
	}
}
