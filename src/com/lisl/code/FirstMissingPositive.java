package com.lisl.code;

import java.util.Arrays;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 * @author 85359_000
 *
 */
public class FirstMissingPositive {
	public static int firstMissingPositive1(int[] nums) {
        if(nums.length==0){
            return 1;
        }
        Arrays.sort(nums);
        int last = nums[0];
        if(last>1){
        	return 1;
        }
        int count = 1;
        for(int i=1;i<nums.length;i++){
            int num = nums[i];
            if(num==last){
            	continue;
            }
            if(num>0){
                if(last<=0){
                	if(num!=1){
                		return 1;
                	}
                }else if(num!=last+1){
                    return last+1;
                }
            }
            last = num;
            count++;
        }
        if(count==1){
        	return last==1?2:1;
        }
        return last<=0?1:last+1;
    }
	
	public static int firstMissingPositive2(int[] nums) {
		int len = nums.length;
		boolean[] flags = new boolean[len+1];
		for(int i=0;i<len;i++){
			int num = nums[i];
			if(num>0 && num<=len){
				flags[num] = true;
			}
		}
		for(int i=1;i<=len;i++){
			if(!flags[i]){
				return i;
			}
		}
        return len+1;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,2};
		System.out.println(firstMissingPositive2(nums));
	}
}
