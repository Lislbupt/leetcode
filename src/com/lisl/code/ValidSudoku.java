package com.lisl.code;

import java.util.HashSet;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The 
 * Rules.
 * The Sudoku board could be partially filled, where empty cells are 
 * filled with the character '.'.
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable.
 *  Only the filled cells need to be validated.
 */
@SuppressWarnings("all")
public class ValidSudoku {
	public void init(HashSet<Character>[] sets){
		for(int i=0;i<9;i++){
			sets[i] = new HashSet<Character>();
		}
	}
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
		HashSet<Character>[] cols = new HashSet[9];
		HashSet<Character>[] cells = new HashSet[9];
		
		init(rows);
		init(cols);
		init(cells);
		
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				char ch = board[i][j];
				if(ch=='.'){
					continue;
				}
				if(rows[i].contains(ch)){
					return false;
				}else{
					rows[i].add(ch);
				}
				if(cols[j].contains(ch)){
					return false;
				}else{
					cols[j].add(ch);
				}
				int cell = (i/3)*3+j/3;
				if(cells[cell].contains(ch)){
					return false;
				}else{
					cells[cell].add(ch);
				}
			}
		}
        return true;
    }
}
