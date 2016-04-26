package com.lisl.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S 
 * such that a + b + c + d = target? Find all unique quadruplets in the 
 * array which gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. 
 * (ie, a °‹ b °‹ c °‹ d)
 * The solution set must not contain duplicate quadruplets.
 */
public class Sum4 {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> all = new ArrayList<List<Integer>>();
		int len = nums.length,flag = 1;
		if(target<0){
			flag = -1;
			target *= -1; 
			for(int i=0;i<len;i++){
				nums[i] *= -1;
			}
		}
		Arrays.sort(nums);
		int left_pre = 1;	//±‹√‚÷ÿ∏¥
		for(int i=0;i<len;i++){
			int left = nums[i];
			if(left>target){
				break;
			}
			if(left==left_pre){
				continue;
			}
			left_pre = left;
			int mid1_pre = target-left+1;	//±‹√‚÷ÿ∏¥
			for(int j=i+1;j<len-2;j++){
				int mid1 = nums[j];
				int sum2 = left+mid1;
				if(sum2>target){
					break;
				}
				if(mid1==mid1_pre){
					continue;
				}
				mid1_pre = mid1;
				int start = len-1;
				int mid2_pre = target-sum2+1;
				for(int k=j+1;k<len-1;k++){
					int mid2 = nums[k];
					int sum3 = sum2+mid2;
					int right = target-sum3;
					if(sum3>target){
						break;
					}
					if(mid2==mid2_pre){
						continue;
					}
					mid2_pre = mid2;
					for(int r=start;r>k;r--){
						int temp = nums[r];
						if(temp==right){
							List<Integer> triplet = new ArrayList<Integer>();
							if(flag==1){
								triplet.add(left);
								triplet.add(mid1);
								triplet.add(mid2);
								triplet.add(right);
							}else{
								triplet.add(right*flag);
								triplet.add(mid2*flag);
								triplet.add(mid1*flag);
								triplet.add(left*flag);
							}
							all.add(triplet);
							start = r-1;
							break;
						}else if(temp<right){
							start = r;
							break;
						}
					}
				}
			}
		}
        return all;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,-2,-5,-4,-3,3,3,5};
		System.out.println(fourSum(nums, -11).toString());
	}
}
