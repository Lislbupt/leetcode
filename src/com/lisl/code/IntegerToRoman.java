package com.lisl.code;

/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegerToRoman {
	private StringBuilder res = new StringBuilder();
    private static String[][] map = new String[4][10];
    static{
		String[] chs = {"I","V","X","L","C","D","M"};
		for(int i=0;i<map.length;i++){
			int temp = i<<1;
			for(int j=0;j<10;j++){
				if(i==3 && j>3){
					break;
				}
				if(j==9){
					map[i][j] = chs[temp]+chs[temp+2];
				}else if(j>4){
					StringBuilder temp_str = new StringBuilder();
					temp_str.append(chs[temp+1]);
					for(int k=0;k<j-5;k++){
						temp_str.append(chs[temp]);
					}
					map[i][j] = temp_str.toString();
				}else if(j==4){
					map[i][j] = chs[temp] + chs[temp+1];
				}else{
					StringBuilder temp_str = new StringBuilder();
					for(int k=0;k<j;k++){
						temp_str.append(chs[temp]);
					}
					map[i][j] = temp_str.toString();
				}
			}
		}
	}
    
    public String intToRoman(int num) {
        int[] temp = {1000,100,10,1};
		for(int i=0;i<4;i++){
			int d = num/temp[i];
			res.append(map[3-i][d]);
			num %= temp[i];
		}
		return res.toString();
    }
}
