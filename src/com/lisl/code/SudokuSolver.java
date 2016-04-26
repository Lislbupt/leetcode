package com.lisl.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 */
@SuppressWarnings("unchecked")
public class SudokuSolver {
	//二维数组深层复制
	public static void deepCopy2Array(char[][] src,char[][] dest){
		for(int i=0;i<src.length;i++){
			dest[i] = src[i].clone();
		}
	}
	//Set数组深层复制
	public static HashSet<Character>[] deepCopySetArray(HashSet<Character>[] src){
		HashSet<Character>[] dest = new HashSet[src.length];
		for(int i=0;i<src.length;i++){
			dest[i] = new HashSet<Character>(src[i]);
		}
		return dest;
	}
	//求board[i][j]在该处所有的可能取值
	public static List<Character> common(HashSet<Character> rows,HashSet<Character> cols,HashSet<Character> cells){
		List<Character> res = new ArrayList<Character>();
		for(Character ch:rows){
			if(cols.contains(ch) && cells.contains(ch)){
				res.add(ch);
			}
		}
		return res;
	}
	//初始化rows,cols,cells,填充1·9九个字符
	public static void init(HashSet<Character>[] sets){
		for(int i=0;i<9;i++){
			HashSet<Character> set = new HashSet<Character>();
			for(int j=0;j<9;j++){
				set.add((char)(j+49));
			}
			sets[i] = set;
		}
	}
	
	public static boolean solve(char[][] board,LinkedList<int[]> emptys,HashSet<Character>[] rows,
			HashSet<Character>[] cols,HashSet<Character>[] cells){
		while(!emptys.isEmpty()){
			int count = 10, row = -1,col = -1 ,empty = -1;
			List<Character> list = new ArrayList<Character>();
			boolean flag = true;
			for(int k=0;k<emptys.size();k++){
				int[] temp = emptys.get(k);
				int i = temp[0];
				int j = temp[1];
				List<Character> comms = common(rows[i], cols[j], cells[(i/3)*3+j/3]);
				int size = comms.size();
				if(size==1){
					flag = false;
					char comm = comms.get(0);
					board[i][j] = comm;
					emptys.remove(k);
					rows[i].remove(comm);
					cols[j].remove(comm);
					cells[(i/3)*3+j/3].remove(comm);
				}else if(size==0){
					return false;
				}else if(size<count){
					list = new ArrayList<Character>(comms);
					count = size;
					row = i;
					col = j;
					empty = k;
				}
			}
			if(flag){
				char[][] board_copy = new char[9][9];
				boolean valid = true;
				for(Character ch : list){
					deepCopy2Array(board, board_copy);
					board_copy[row][col] = ch;
					LinkedList<int[]> emptys_copy = new LinkedList<int[]>(emptys);	
					HashSet<Character>[] rows_copy = deepCopySetArray(rows);			
					HashSet<Character>[] cols_copy = deepCopySetArray(cols);		
					HashSet<Character>[] cells_copy = deepCopySetArray(cells);
					emptys_copy.remove(empty);
					rows_copy[row].remove(ch);
					cols_copy[col].remove(ch);
					cells_copy[(row/3)*3+col/3].remove(ch);
					if(solve(board_copy, emptys_copy, rows_copy, cols_copy, cells_copy)){
						valid = false;
						deepCopy2Array(board_copy, board);
						return true;
					}
				}
				if(valid){
					return false;
				}
			}
		}
		return true;
	}
	
	public static void solveSudoku(char[][] board) {
		LinkedList<int[]> emptys = new LinkedList<int[]>();	//保存所有的空位索引
		HashSet<Character>[] rows = new HashSet[9];			//保存所有行的可填数字
		HashSet<Character>[] cols = new HashSet[9];			//保存所有列的可填数字
		HashSet<Character>[] cells = new HashSet[9];		//保存所有单元（3*3的小正方形）的可填数字
		
		init(rows);
		init(cols);
		init(cells);
		
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				char ch = board[i][j];
				if(ch=='.'){
					int[] index = {i,j};
					emptys.add(index);
				}else{
					rows[i].remove(ch);
					cols[j].remove(ch);
					cells[(i/3)*3+j/3].remove(ch);
				}
			}
		}
		//若函数返回的是false,说明该数独无解，此程序可以判断一个数独是否有解，若有解，可以填充数独，并且可以填充解不唯一的数独
		solve(board, emptys, rows, cols, cells);		
    }
	
	public static void main(String[] args) {
		char[][] board = new char[9][9];
		String[] str = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				board[i][j] = str[i].charAt(j);
			}
		}
		solveSudoku(board);
		for(char[] chs : board){
			for(char ch:chs){
				System.out.print(ch);
			}
			System.out.println();
		}
	}
}
