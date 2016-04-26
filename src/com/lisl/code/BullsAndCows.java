package com.lisl.code;

import java.util.ArrayList;
import java.util.HashMap;

public class BullsAndCows {
	public static String getHint(String secret, String guess) {
		int bulls = 0;
		int cows = 0;
		HashMap<Character,ArrayList<Integer>> map = new HashMap<Character,ArrayList<Integer>>();
		ArrayList<Integer> bull_index = new ArrayList<Integer>();
		for(int i=0;i<guess.length();i++){
			char s = secret.charAt(i);
			if(map.get(s)==null){
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(s, list);
			}else{
				ArrayList<Integer> list = map.get(s);
				list.add(i);
				map.put(s, list);
			}
		}
		for(int i=0;i<guess.length();i++){
			char g = guess.charAt(i);
			ArrayList<Integer> list_index = map.get(g);
			if(list_index!=null){
				if(list_index.contains(i)){
					bulls++;
					bull_index.add(i);
					list_index.remove((Integer)i);
					if(list_index.isEmpty()){
						list_index = null;
					}
					map.put(g, list_index);
				}
			}
		}
		for(int i=0;i<guess.length();i++){
			char g = guess.charAt(i);
			ArrayList<Integer> list_index = map.get(g);
			if(list_index!=null && !bull_index.contains(i)){
				cows++;
				list_index.remove(0);
				if(list_index.isEmpty()){
					list_index = null;
				}
				map.put(g, list_index);
			}
		}
        return bulls+"A"+cows+"B";
    }
	
	public static void main(String[] args) {
		System.out.println(getHint("1122", "0111"));
	}
}
