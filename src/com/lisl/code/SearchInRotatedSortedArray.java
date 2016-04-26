package com.lisl.code;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you 
 * beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return 
 * its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray {
	public static int binarySearch(int[] nums,int target,int begin,int end){
        if(begin>end){
            return -1;
        }
        int mid = (begin+end)/2;
        int value = nums[mid];
        if(value==target){
            return mid;
        }else if(value>target){
            int index = binarySearch(nums,target,begin,mid-1);
            if(index==-1){
                return binarySearch(nums,target,mid+1,end);
            }
            return index;
        }else{
            int index = binarySearch(nums,target,mid+1,end);
            if(index==-1){
                return binarySearch(nums,target,begin,mid-1);
            }
            return index;
        }
    }
	
    public static int search1(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
    }
    
    public static int myBinarySearch(int[] nums,int target,int begin,int end){
        if(begin>end){
            return -1;
        }
        int mid = (begin+end)/2;
        int value = nums[mid];
        if(value==target){
            return mid;
        }else if(value>target){
            return myBinarySearch(nums,target,begin,mid-1);
        }else{
            return myBinarySearch(nums,target,mid+1,end);
        }
    }
    
    public static int search2(int[] nums, int target) {
    	int len = nums.length;
    	if(len==0){
    		return -1;
    	}
    	int _target = nums[len-1];
    	int begin = 0,end = len-2;
    	if(begin==end){
    		begin = nums[begin]>_target?begin+1:0;
    	}
    	//二分法找到反转点
    	while(begin<end){
    		int mid = (begin+end)>>1;
    		int value = nums[mid];
    		if(value>_target){
    			begin = mid+1;
    		}else{
    			end = mid;
    		}
    		if(begin==end && nums[begin]>_target){
    			begin++;
    		}
    	}
    	if(begin==0){
    		return myBinarySearch(nums,target,begin,len-1);
    	}
    	if(nums[begin]>target){
    		return -1;
    	}
    	if(nums[begin-1]<target){
    		return -1;
    	}
        return Math.max(myBinarySearch(nums,target,0,begin-1), myBinarySearch(nums,target,begin,len-1));
    }
    
    public static void main(String[] args) {
		int[] nums = {1,3};
		System.out.println(search2(nums,1));
	}
}
