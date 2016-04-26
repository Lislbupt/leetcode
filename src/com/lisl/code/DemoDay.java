package com.lisl.code;

import java.util.Scanner;

/**
 * You work as an intern at a robotics startup. Today is your company's 
 * demo day. During the demo your company's robot will be put in a maze 
 * and without any information about the maze, it should be able to find 
 * a way out.
 * The maze consists of N * M grids. Each grid is either empty(represented 
 * by '.') or blocked by an obstacle(represented by 'b'). The robot will 
 * be release at the top left corner and the exit is at the bottom right 
 * corner.
 * Unfortunately some sensors on the robot go crazy just before the demo 
 * starts. As a result, the robot can only repeats two operations 
 * alternatively: keep moving to the right until it can't and keep moving 
 * to the bottom until it can't. At the beginning, the robot keeps moving 
 * to the right.
 * rrrrbb..            
 * ...r....    ====> The robot route with broken sensors is marked by 'r'. 
 * ...rrb..
 * ...bb...
 * While the FTEs(full-time employees) are busy working on the sensors, 
 * you try to save the demo day by rearranging the maze in such a way 
 * that even with the broken sensors the robot can reach the exit 
 * successfully. You can change a grid from empty to blocked and vice 
 * versa. So as not to arouse suspision, you want to change as few grids 
 * as possible. What is the mininum number?
 */
public class DemoDay {
	//递归，Time limited
	public static int changeNums(String[] matrix,int rows,int cols,int row,int col,int pre){
		if(row==rows-1 && col==cols-1){
			return 0;
		}
		
		int nums1 = 0;
		if(col<cols-1){
			if(row!=0 && row!=rows-1){
				if(pre==2 && matrix[row+1].charAt(col)=='.'){
					nums1++;
				}
			}
			if(matrix[row].charAt(col+1)=='b'){
				nums1++;
			}
		}
		
		int nums2 = 0;
		if(row<rows-1){
			if(col!=0 && col!=cols-1){
				if(pre==1 && matrix[row].charAt(col+1)=='.'){
					nums2++;
				}
			}
			if(matrix[row+1].charAt(col)=='b'){
				nums2++;
			}
		}
		
		if(col==cols-1){
			return nums2+changeNums(matrix,rows,cols, row+1, col,2);
		}
		if(row==rows-1){
			return nums1+changeNums(matrix,rows,cols, row, col+1,1);
		}
		return Math.min(nums1+changeNums(matrix,rows,cols, row, col+1,1), nums2+changeNums(matrix,rows,cols, row+1, col,2));
	}
	
	public static int minChanges(String[] matrix,int rows,int cols){
		//steps[i][j][0]表示从matrix[i][j]到matrix[i][j+1]改变最小次数
		//steps[i][j][1]表示从matrix[i][j]到matrix[i+1][j]改变最小次数
		int[][][] steps = new int[rows][cols][2];
		//初始化steps[0][0]
		if(matrix[0].charAt(1)=='b'){
			steps[0][0][0] = 1; 
			steps[0][0][1] = 0; 
		}else{
			steps[0][0][0] = 0; 
			steps[0][0][1] = 1; 
		}
		//初始化第一行
		for(int i=1;i<cols;i++){
			if(matrix[0].charAt(i+1)=='b'){
				steps[0][i][0] = steps[0][i-1][0] + 1;
				if(matrix[1].charAt(i)=='b'){
					steps[0][i][1] = steps[0][i-1][0] + 1;
				}else{
					steps[0][i][1] = steps[0][i-1][0];
				}
			}else{
				steps[0][i][0] = steps[0][i-1][0];
				if(matrix[1].charAt(i)=='b'){
					steps[0][i][1] = steps[0][i-1][0] + 2;
				}else{
					steps[0][i][1] = steps[0][i-1][0] + 1;
				}
			}
		}
		//初始化第一列
		for(int i=1;i<rows;i++){
			if(matrix[i+1].charAt(0)=='b'){
				steps[i][0][1] = steps[i-1][0][1] + 1;
				if(matrix[i].charAt(1)=='b'){
					steps[i][0][0] = steps[i-1][0][1] + 1;
				}else{
					steps[i][0][0] = steps[i-1][0][1];
				}
			}else{
				steps[i][0][1] = steps[i-1][0][1];
				if(matrix[i].charAt(1)=='b'){
					steps[i][0][0] = steps[i-1][0][1] + 2;
				}else{
					steps[i][0][0] = steps[i-1][0][1] + 1;
				}
			}
		}
		//steps[i][j]由steps[i-1][j]和steps[i][j-1]以及matrix[i][j+1]和matrix[i+1][j]决定
		for(int i=1;i<rows;i++){
			for(int j=1;j<cols;j++){
				char right = matrix[i].charAt(j+1);
				char down = matrix[i+1].charAt(j);
				int a = 0,b = 0,c = 0,d = 0;
				if(right=='b'){
					if(down=='b'){
						a = steps[i-1][j][1]+1;
						c = steps[i-1][j][1]+1;
						d = steps[i][j-1][0]+1;
					}else{
						a = steps[i-1][j][1]+2;
						c = steps[i-1][j][1];
						d = steps[i][j-1][0];
					}
					b = steps[i][j-1][0]+1;
				}else{
					if(down=='b'){
						a = steps[i-1][j][1];
						c = steps[i-1][j][1]+1;
						d = steps[i][j-1][0]+2;
					}else{
						a = steps[i-1][j][1]+1;
						c = steps[i-1][j][1];
						d = steps[i][j-1][0]+1;
					}
					b = steps[i][j-1][0];
				}
				steps[i][j][0] = Math.min(a, b);
				steps[i][j][1] = Math.min(c, d);
			}
		}
		if(rows==1 && cols==1){
			return 0;
		}
		if(rows==1){
			return steps[0][cols-2][0];
		}
		if(cols==1){
			return steps[rows-2][0][1];
		}
		return Math.min(steps[rows-2][cols-1][1], steps[rows-1][cols-2][0]);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		String[] matrix = new String[N+1];
		for(int i=0;i<N;i++){
			matrix[i] = s.next()+"b";
		}
		StringBuilder ss = new StringBuilder();
		for(int i=0;i<M+1;i++){
			ss.append('b');
		}
		matrix[N] = new String(ss.toString());
//		System.out.println(changeNums(matrix,N,M, 0, 0, 1));
		System.out.println(minChanges(matrix, N, M));
		s.close();
	}
}
