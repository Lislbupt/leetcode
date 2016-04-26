package com.lisl.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 * The solution set must not contain duplicate combinations.
 */
public class CombinationSum2 {
	public static List<List<Integer>> solve(int[] candidates, int target){
		HashSet<List<Integer>> set = new HashSet<>();
		int index = 0;
		for(int candidate : candidates){
			if(candidate==target){
				ArrayList<Integer> l = new ArrayList<>();
				l.add(candidate);
				set.add(l);
				continue;
			}
			if(candidate>target){
				break;
			}
			int[] arrs = candidates.clone();
			arrs[index] = Integer.MAX_VALUE;
			List<List<Integer>> temp = solve(arrs, target-candidate);
			if(!temp.isEmpty()){
				for(List<Integer> combination : temp){
					combination.add(candidate);
					Collections.sort(combination);
					set.add(combination);
				}
			}
			index++;
		}
        return new ArrayList<List<Integer>>(set);
	}
	
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
        return solve(candidates, target);
    }
	
	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5};
		List<List<Integer>> combinations = combinationSum2(candidates, 8);
		for(List<Integer> combination : combinations){
			System.out.println(combination.toString());
		}
	}
}
