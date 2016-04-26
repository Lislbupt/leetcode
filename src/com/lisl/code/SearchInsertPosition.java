package com.lisl.code;

/**
 * Given a sorted array and a target value, return the index if the 
 * target is found. If not, return the index where it would be if it 
 * were inserted in order.
 * You may assume no duplicates in the array.
 */
public class SearchInsertPosition {
	public int search(int[] nums,int begin,int end,int target){
		int mid = (begin+end)>>1;
		int value = nums[mid];
		if(value==target){
			return mid;
		}else if(value>target){
			if(mid-1<begin || nums[mid-1]<target){
				return mid;
			}else{
				return search(nums, begin, mid-1, target);
			}
		}else{
			if(mid+1>end || nums[mid+1]>target){
				return mid+1;
			}else{
				return search(nums, mid+1, end, target);
			}
		}
	}
	
	public int searchInsert(int[] nums, int target) {
		return search(nums, 0, nums.length-1, target);
    }
}
