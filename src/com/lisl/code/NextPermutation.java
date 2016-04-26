package com.lisl.code;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the 
 * lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the 
 * lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * 寻找比当前排列顺序大的下一个排列(字典序)
 */
public class NextPermutation {
	public static void nextPermutation(int[] nums) {
		int len = nums.length;
		int index = 0;
		int ptr = Integer.MAX_VALUE;
		boolean flag = false;;
        for(int i=len-1;i>0;i--){
        	if(nums[i]>nums[i-1]){
        		index = i;
        		ptr = nums[i-1];
        		flag = true;
        		break;
        	}
        }
        int front = index;
        int rear = len-1;
        int minOverPtr = -1;
        while(front<=rear){
        	if(flag){
        		if(nums[rear]>ptr){
        			minOverPtr = rear;
        			flag = false;
        		}else if(nums[front]>ptr){
        			minOverPtr = front;
        		}else{
        			flag = false;
        		}
        	}
        	int temp = nums[rear];
        	nums[rear] = nums[front];
        	nums[front] = temp;
        	front++;
        	rear--;
        }   
        if(minOverPtr>0){
        	int p = len-1-minOverPtr+index;
        	nums[index-1] = nums[p];
        	nums[p] = ptr;
        }
	}
	
	public static void main(String[] args) {
		int[] nums = {3,2,1};
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
}
