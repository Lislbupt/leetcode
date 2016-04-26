package com.lisl.code;

import java.util.Arrays;

/**
 * Given an array and a value, remove all instances of that value in place 
 * and return the new length.
 * Do not allocate extra space for another array, you must do this in place 
 * with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave 
 * beyond the new length.
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * Your function should return length = 2, with the first two elements of 
 * nums being 2.
 */
public class RemoveElement {
	public static int removeElement(int[] nums, int val) {
		int res = 0,cur = 0,index = 0;
		for(int temp:nums){
			if(temp!=val){
				res++;
				if(index!=cur){
					nums[cur] = temp;
				}
				cur++;
			}
			index++;
		}
		
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {3,2,2,3};
		int len = removeElement(nums, 2);
		System.out.println(len);
		System.out.println(Arrays.toString(Arrays.copyOf(nums, len)));
	}
}
