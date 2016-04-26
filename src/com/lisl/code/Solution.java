package com.lisl.code;

public class Solution {
	 public static int[] twoSum(int[] nums, int target) {
		 int temp1 = Integer.MIN_VALUE,temp2 = Integer.MIN_VALUE;
		 int[] result = {0,0};
		 for(int i=0;i<nums.length;i++){
			 int data1 = nums[i];
			 int dest = target - data1;
			 if(data1==temp1 || data1==temp2){
				 continue;
			 }
			 for(int j=i+1;j<nums.length;j++){
				 int data2 = nums[j];

				 if(data2==dest){
					 result[0] = i+1;
					 result[1] = j+1;
					 return result;
				 }
				 if(j==nums.length-1){
					 temp1 = data1;
					 temp2 = data2;
				 }
			 }
		 }
		 return null;
	 }
	 
	 public static void main(String[] args) {
		 int[] numbers = {0,2,3,2,11,5};
		 int[] result = twoSum(numbers,16);
		 for(int index:result){
			 System.out.println(index);
		 }
	 }
}
