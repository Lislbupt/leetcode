package com.lisl.code;

/**
 * The string "PAYPALISHIRING" is written in a zigzag(Ö®×ÖÐÎ) pattern on a given number
 *  of rows like this: (you may want to display this pattern in a fixed font
 *  for better legibility) 
 *  P   A   H   N
 *  A P L S I I G
 *  Y   I   R
 */
public class ZigZagConversion {
	public static String convert(String s, int numRows) {
		if(numRows==1){
			return s;
		}
		int len = s.length();
		StringBuilder res = new StringBuilder();
		for(int i=0;i<numRows;i++){
			int j = i;
			while(j<len){
				res.append(s.charAt(j));
				if(i!=0 && i!=numRows-1){
					int temp = j+((numRows-i-1)<<1);
					if(temp<len){
						res.append(s.charAt(temp));
					}
				}
				j += ((numRows<<1)-2);
			}
		}
        return res.toString();
    }
	
	public static void main(String[] args) {
		String s = "ABC";
		System.out.println(convert(s, 1));
	}
}
