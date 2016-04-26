package com.lisl.code;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber2 {
	public static int singleNumber(int[] nums){
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++){
			int data = nums[i];
			if(map.containsKey(data)){
				int temp = map.get(data);
				if(temp==2){
					map.remove(data);
				}else{
					map.put(data, ++temp);
				}
			}else{
				map.put(data, 1);
			}
		}
		for(int data:map.keySet()){
			return data;
		}
		return -1;
	}

	public static int singleNumber2(int[] nums){
		int[] bytes = new int[32];
		int res = 0;
		for(int i=0;i<32;i++){
			for(int data:nums){
				bytes[i] += (data >> i) & 1;
			}
			res |= bytes[i] % 3 << i;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int a[] = {-2,-2,1,1,-3,1,-3,-3,-4,-2};
//		System.out.println(singleNumber(a));
		System.out.println(singleNumber2(a));
	}
}
