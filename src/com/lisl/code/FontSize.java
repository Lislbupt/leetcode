package com.lisl.code;

import java.util.Scanner;

public class FontSize {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		for(int i=0;i<num;i++){
			int N = s.nextInt();
			int P = s.nextInt();
			int W = s.nextInt();
			int H = s.nextInt();
			int[] numbers = new int[N];
			for(int j=0;j<N;j++){
				int number = s.nextInt();
				numbers[j] = number;
			}
			int max = Math.min(W, H);
			int min = 1;
			boolean flag = true;
			while(min<=max){
				int S = (min+max)/2;
				int lines = 0;
				for(int j=0;j<N;j++){
					lines += (int)Math.ceil(numbers[j]*1.0/(W/S));
				}
				int pages = (int)Math.ceil(lines*1.0/(H/S));
				if(pages==P){
					System.out.println(S);
					flag = false;
					break;
				}else if(pages>P){
					max = S-1;
				}else{
					min = S+1;
				}
			}
			if(flag){
				System.out.println(min-1);
			}
		}
		s.close();
	}
}
