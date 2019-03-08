package dec10;
import java.util.*;
public class Sudoku {
	static char grid[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		grid = new char[n][n];
	}
	public static boolean helper()
	{
		RowColumn rowColumn = new RowColumn(0,0);
		if(!findUnAssigned(rowColumn))
			return true;
		for(int i = 1; i <= 9 ; i++ )
		{
			if(isSafe(rowColumn.row,rowColumn.column,i))
				grid[rowColumn.row][rowColumn.column] = (char)(i + '0') ;
			if(helper())
			{
				return true;
			}
			grid[rowColumn.row][rowColumn.column] = '*' ;
			
			
		}
		return false;
	}
	public static boolean findUnAssigned(RowColumn rowColumn)
	{
		for(rowColumn.row = 0 ; rowColumn.row < grid.length ;rowColumn.row++)
		{
			for(rowColumn.column = 0 ; rowColumn.column <grid.length ; rowColumn.column++ )
			{
				if(grid[rowColumn.row][rowColumn.column] == '*')
					return true;
			}
		}
		return false;
	}
	public static boolean isSafe(int row,int column,int num)
	{
		if(!rowCheck(row, column, num) && !columnCheck(row, column, num) 
				&& !isSafeInBox( row - (row % 3), column - (column % 3) , num) )
			return false;
		return true;
	}
	public static boolean rowCheck( int row , int column , int num )
	{
		for(int i = 0 ; i < grid.length ; i++ )
		{
			if(grid[row][i] == (char)('0'+num))
				return true;
		}
		return false;
	}
	public static boolean columnCheck(int row, int column,int num)
	{
		for(int i = 0 ; i < grid.length ; i++ )
		{
			if(grid[i][column] == (char)('0' + num ))
				return true;
		}
		return false;
	}
	public static boolean isSafeInBox(int row,int column, int num)
	{
		for(int i = 0 ; i < 3 ; i++ )
		{
			for(int j = 0 ; j < 3 ; j++ )
			{
				if(grid[row + i][column + j] == (char)('0' + num))
					return true;
			}
		}
		return false;
	}
	static class RowColumn
	{
		int row, column;
		RowColumn(int row,int column)
		{
			this.row = row;
			this.column = column; 
		}
	}
}
