package com.lisl.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SingleNumber3 {
	public static int[] singleNumber(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i:nums){
			if(set.contains(i)){
				set.remove(i);
			}else{
				set.add(i);
			}
		}
		int[] res = new int[2];
		int index = 0;
		for(int i:set){
			res[index] = i;
			++index;
		}
        return res;
    }
	public static void main(String[] args) {
		int a[] = {1, 2, 1, 3, 2, 5};
		System.out.println(Arrays.toString(singleNumber(a)));
	}
}
