package com.lisl.code;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point 
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints 
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis 
 * forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 */
public class ContainerWithMostWater {
	public static int maxArea1(int[] height) {
		int max = 0;
		for(int i=0;i<height.length-1;i++){
			for(int j=i+1;j<height.length;j++){
				int area = (j-i)*Math.min(height[i], height[j]);
				if(area>max){
					max = area;
				}
			}
		}
        return max;
    }
	
	public static int maxArea2(int[] height) {
		int maxArea = 0;
		for(int i=0;i<height.length;i++){
			int max = 0;
			for(int j=0;j<height.length;j++){
				if(height[j]>height[i]){
					max = j;
				}
			}
			int temp = height[i]*(max-i);
			if(temp>maxArea){
				maxArea = temp;
			}
		}
        return maxArea;
    }
	
	public static void main(String[] args) {
		int[] height = {1,2,3};
//		System.out.println(maxArea1(height));
		System.out.println(maxArea2(height));
	}
}
