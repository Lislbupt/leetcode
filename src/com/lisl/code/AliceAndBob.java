package com.lisl.code;

import java.util.Scanner;

public class AliceAndBob {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int count = s.nextInt();
		for(int i=0;i<count;i++){
			int n = s.nextInt();
			if(n==0){
				System.out.println(0);
				continue;
			}
			int zeros = 0;
			int zeros_sub = 0;
			for(int j=0;j<31;j++){
				if(((n>>j) & 1)==0){
					zeros++;
					zeros_sub++;
				}else{
					zeros_sub = 0;
				}
			}
			int zeros_real = zeros-zeros_sub;
			if(zeros_real>0){
				System.out.println(2<<(zeros-zeros_sub-1));
			}else{
				System.out.println(1);
			}
			
		}
		s.close();
	}
}
