package com.lisl.code;

import java.util.Scanner;

public class StarvingWolf {
	public static int submultipleNum(int n){
		if(n==1){
			return 1;
		}
		int log[] = new int[n/2+1];
		int count = 0;
		for(int i=2;i<log.length;i++){
			if(log[i]==1){
				continue;
			}
			if(n%i==0){
				count++;
			}else{
				for(int j=i;j<log.length;j*=2){
					log[j] = 1;
				}
			}
		}
		return count+2;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int count = s.nextInt();
		for(int i=0;i<count;i++){
			int n = s.nextInt();
			int sum = 0;
			int j = 1;
			int begin = n;
			int end;
			while(true){
				int k = j+1;
				end = n/k;
				int sub = begin-end;
				if(sub>1){
					sum += sub*j;
				}else{
					break;
				}
				j++;
				begin = end; 
			}
			for(int k=begin;k>0;k--){
				sum += n/k;
			}
			System.out.println(sum);
		}
		s.close();
	}
}
