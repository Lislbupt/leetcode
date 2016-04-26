package com.lisl.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 * The solution set must not contain duplicate combinations.
 */
public class CombinationSum {
	public static List<List<Integer>> removeDuplicates(List<List<Integer>> combinations){
		HashSet<List<Integer>> set = new HashSet<>();
		for(List<Integer> combination : combinations){
			Collections.sort(combination);
			set.add(combination);
		}
		return new ArrayList<List<Integer>>(set);
	}
	
	public static List<List<Integer>> solve(int[] candidates, int target){
		HashSet<List<Integer>> set = new HashSet<>();
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
			List<List<Integer>> temp = solve(candidates, target-candidate);
			if(!temp.isEmpty()){
				for(List<Integer> combination : temp){
					combination.add(candidate);
					Collections.sort(combination);
					set.add(combination);
				}
			}
		}
        return new ArrayList<List<Integer>>(set);
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
//		return removeDuplicates(solve(candidates, target));
		return solve(candidates, target);
    }
	
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		List<List<Integer>> combinations = combinationSum(candidates, 7);
		for(List<Integer> combination : combinations){
			System.out.println(combination.toString());
		}
	}
}
