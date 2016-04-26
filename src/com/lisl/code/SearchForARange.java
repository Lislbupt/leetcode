package com.lisl.code;

/**
 * Given a sorted array of integers, find the starting and ending 
 * position of a given target value.
 * Your algorithm's runtime complexity must be in the order of 
 * O(log n).
 * If the target is not found in the array, return [-1, -1].
 */
public class SearchForARange {
	public int searchFirst(int[] nums,int begin,int end,int target){
		if(begin>end || nums[end]!=target){
			return -1;
		}
		int mid = (begin+end)>>1;
		int value = nums[mid];
		if(value<target){
			return searchFirst(nums, mid+1, end, target);
		}else{
			int first = searchFirst(nums, begin, mid-1, target);
			return first==-1?mid:first;
		}
	}
	
	public int searchRear(int[] nums,int begin,int end,int target){
		if(begin>end || nums[begin]!=target){
			return -1;
		}
		int mid = (begin+end)>>1;
		int value = nums[mid];
		if(value>target){
			return searchRear(nums, begin, mid-1, target);
		}else{
			int rear = searchRear(nums, mid+1, end, target);
			return rear==-1?mid:rear;
		}
	}
	
	public int[] search(int[] nums,int begin,int end,int target){
		int[] res = {-1,-1};
		if(begin>end){
			return res;
		}
		int mid = (begin+end)>>1;
		int value = nums[mid];
		
		if(value<target){
			return search(nums, mid+1, end, target);
		}else if(value>target){
			return search(nums, begin, mid-1, target);
		}else{
			int first = searchFirst(nums, begin, mid-1, target);
			int rear = searchRear(nums, mid+1, end, target);
			res[0] = first==-1?mid:first;
			res[1] = rear==-1?mid:rear;
		}
		return res;
	}
	
	public int[] searchRange(int[] nums, int target) {
		return search(nums, 0, nums.length-1, target);
    }
}
