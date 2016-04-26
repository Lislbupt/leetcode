package com.lisl.code;

public class NumMatrix {
	int[][] matrix_sum;
	public NumMatrix(int[][] matrix) {
		if(matrix.length==0){
			matrix_sum = null;
		}else{
			int row = matrix.length;
			int col = matrix[0].length;
			matrix_sum = new int[row][col];
			for(int i=0;i<row;i++){
				int sum_col = 0;
				for(int j=0;j<col;j++){
					sum_col += matrix[i][j];
					if(i==0){
						matrix_sum[i][j] = sum_col;
					}else{
						matrix_sum[i][j] += (matrix_sum[i-1][j]+sum_col);
					}
				}
			}
			
		}
	}
	 
	public int sumRegion(int row1, int col1, int row2, int col2) {
		if(matrix_sum==null){
			return 0;
		}
		if(row1==0 && col1==0){
			return matrix_sum[row2][col2];
		}else if(row1==0){
			return matrix_sum[row2][col2]-matrix_sum[row2][col1-1];
		}else if(col1==0){
			return matrix_sum[row2][col2]-matrix_sum[row1-1][col2];
		}
		
		return matrix_sum[row2][col2]-matrix_sum[row2][col1-1]
				-matrix_sum[row1-1][col2]+matrix_sum[row1-1][col1-1];
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}};
		NumMatrix numMatrix = new NumMatrix(matrix);
		int a = numMatrix.sumRegion(2, 1, 4, 3);
		int b = numMatrix.sumRegion(1, 1, 2, 2);
		int c = numMatrix.sumRegion(1, 2, 2, 4);
		int d = numMatrix.sumRegion(0, 0, 2, 4);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}
}
