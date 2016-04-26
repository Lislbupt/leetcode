package com.lisl.code;

/**
 * Divide two integers without using multiplication, division and mod 
 * operator.
 * If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers {
	public static int divide(int dividend, int divisor) {
		if(dividend==Integer.MIN_VALUE && divisor==-1){
			return Integer.MAX_VALUE;
		}
		boolean flag = true;
		if((dividend<0 && divisor>0) || (dividend>0 && divisor<0)){
			flag = false;
		}
		long _dividend = Math.abs((long)dividend);
		long _divisor = Math.abs((long)divisor);
		long sum = _divisor;
		int addNums = 1;
		int count = 0;
		while(sum<_dividend){
			sum = sum << 1;
			addNums = addNums << 1;
			count++;
		}
		if(sum==_dividend){
			return flag?addNums:(0-addNums);
		}
		count--;
		while(count>0){
			long temp = sum-(_divisor<<--count);
			if(temp==_dividend){
				return flag?addNums-(1<<count):(1<<count)-addNums;
			}else if(temp>_dividend){
				sum = temp;
				addNums -= (1<<count);
			}
		}
        return flag?addNums-1:1-addNums;
    }
	
	public static void main(String[] args) {
		System.out.println(divide(10, 11));
	}
}
