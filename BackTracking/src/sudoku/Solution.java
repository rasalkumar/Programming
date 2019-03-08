package sudoku;
import java.util.*;
public class Solution 
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int[][] sudoku = new int[9][9];
			for(int i = 0 ; i < 9 ; i++ )
				for(int j = 0 ; j < 9 ; j++ )
					sudoku[i][j] = in.nextInt();
			
			sudokuSolver(sudoku);
			
			for(int i = 0 ; i < 9 ; i++ ){
				for(int j = 0 ; j < 9 ; j++ ){
					System.out.print(sudoku[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
	public static boolean sudokuSolver(int[][] grid)
	{
		RowColumn rowColumn = new RowColumn(0,0);
		if(!findUnassignedLocation(grid,rowColumn))
			return true;
		for(int num  = 1 ; num <= 9 ; num++)
		{
			if(isSafe(grid,rowColumn.row,rowColumn.column,num))
			{
				grid[rowColumn.row][rowColumn.column] = '0' + num ; 
			}
			if(sudokuSolver(grid))
				return true;
			grid[rowColumn.row][rowColumn.column] = '.';
		}
		return false;
	}
	public static boolean findUnassignedLocation(int[][] grid, RowColumn rowColumn)
	{
		for(rowColumn.row = 0 ; rowColumn.row < 9 ; rowColumn.row++)
			for(rowColumn.column = 0 ; rowColumn.column < 9 ; rowColumn.column++)
				if(grid[rowColumn.row][rowColumn.column] == '.')
					return true;
		return false;
	}
	public static boolean isSafe(int[][] grid,int row,int column,int num)
	{
		return !usedInRow(grid, row, num) && !usedInColumn(grid,column,num) && !usedInBox(grid,row,column,num);
	}
	public static boolean usedInRow(int[][] grid, int row,int num)
	{
		for(int i = 0 ; i < 9 ; i++ )
			if(grid[row][i]== '0' + num)
				return false;
		return true;
	}
	public static boolean usedInColumn(int[][] grid, int column, int num)
	{
		for(int i = 0 ; i < 9 ; i++ )
			if(grid[i][column] == '0' + num)
				return false;
		return true;
	}
	public static boolean usedInBox(int[][] grid,int rowStart, int columnStart, int num)
	{
		for(int row = 0 ; row < 3 ; row++)
			for(int column = 0 ; column < 3 ; column++)
				if(grid[row+rowStart][column+columnStart] == '0' + num)
					return false;
		return true;
	}
	static class RowColumn
	{
		int row,column;
		RowColumn(int row,int column)
		{
			this.row= row;
			this.column = column;
		}
	}
}

