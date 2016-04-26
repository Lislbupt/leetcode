package com.lisl.code;
/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *  Find the median of the two sorted arrays. The overall run time complexity 
 *  should be O(log (m+n)).
 */
public class MedianTwoSortedArrays {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length,len2 = nums2.length;
		int sum_len = len1+len2;
		int mid = sum_len/2;
		int p1 = 0,p2 = 0;
		int count = 0;
		int log1 = 0,log2 = 0;
		boolean isEven = sum_len%2==0?true:false;
		if(len1==0){
			if(isEven){
				return (nums2[mid]+nums2[mid-1])*1.0/2;
			}else{
				return nums2[mid];
			}
		}
		if(len2==0){
			if(isEven){
				return (nums1[mid]+nums1[mid-1])*1.0/2;
			}else{
				return nums1[mid];
			}
		}
		for(int i=0;i<sum_len;i++){
			if(nums1[p1]<=nums2[p2]){
				log1 = nums1[p1];
				p1++;
			}else{
				log1 = nums2[p2];
				p2++;
			}
			count++;
			if(isEven){
				if(count==mid){
					log2 = log1;
				}else if(count==mid+1){
					return (log1+log2)*1.0/2;
				}
			}else{
				if(count==mid+1){
					return log1;
				}
			}
			if(p1>=len1){
				int temp1= mid-count+p2;
				if(isEven){
					if(count==mid){
						return (nums2[temp1]+log1)*1.0/2;
					}
					return (nums2[temp1]+nums2[temp1-1])*1.0/2;
				}else{
					return nums2[temp1];
				}
			}
			if(p2>=len2){
				int temp1= mid-count+p1;
				if(isEven){
					if(count==mid){
						return (nums1[temp1]+log1)*1.0/2;
					}
					return (nums1[temp1]+nums1[temp1-1])*1.0/2;
				}else{
					return nums1[temp1];
				}
			}
		}
		return -1;
    }
	
	public static void main(String[] args) {
		int[] a = {6};
		int[] b = {4,5,7};
		System.out.println(findMedianSortedArrays(a, b));
	}
}
