package com.lisl.code;

import java.util.Scanner;

public class Gift {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int count = s.nextInt();
		for(int i=0;i<count;i++){
			int age = s.nextInt();
			if(age==1){
				System.out.println("A");
				continue;
			}
			char inner = (char) ('A' + age - 1);
			char out = (char) (inner - 1);
			
			for(int j=0;j<5;j++){
				if(j==0 || j==4){
					for(int k=0;k<5;k++){
						System.out.print(out);
					}
					System.out.println();
					continue;
				}
				
				if(j==1 || j==3){
					System.out.println(out+"ZZZ"+out);
					continue;
				}
				
				System.out.println(out+"Z"+inner+"Z"+out);
			}
		}
		s.close();
	}
}
