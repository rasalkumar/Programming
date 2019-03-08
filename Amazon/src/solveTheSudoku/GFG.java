package solveTheSudoku;

import java.util.*;

public class GFG {
	public static final int UNASSIGNED = 0;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
			for (int i = 0; i < 9; i++) {
				ArrayList<Integer> d = new ArrayList<>();
				for (int j = 0; j < 9; j++) {
					d.add(in.nextInt());
				}
				grid.add(d);
			}
			if (sudokuSolver(grid) == true)
			{
				printGrid(grid);
			}
			else
			{
				System.out.println("No Solution Exists");
			}

		}
	}

	private static void printGrid(ArrayList<ArrayList<Integer>> grid) {
		// TODO Auto-generated method stub
		for (int row = 0; row < 9; row++)
	    {
	       for (int col = 0; col < 9; col++)
	             System.out.print(grid.get(row).get(col));
	        System.out.println();
	    }
		
	}

	public static boolean sudokuSolver(ArrayList<ArrayList<Integer>> grid) {
		RowColumn rowColumn = new RowColumn(0 , 0);
		if (!findUnassignedLocation(grid, rowColumn))
			return true;
		for (int num = 1; num <= 9; num++) {
			if (isSafe(grid, rowColumn.row, rowColumn.column, num)) {
				grid.get(rowColumn.row).set(rowColumn.column, num);
				if (sudokuSolver(grid)) {
					return true;
				}
				grid.get(rowColumn.row).set(rowColumn.column, UNASSIGNED);
			}
		}
		return false;// main step for backtracking
	}

	public static boolean findUnassignedLocation(ArrayList<ArrayList<Integer>> grid, RowColumn rowColumn) {
        
		for (rowColumn.row = 0; rowColumn.row < 9; rowColumn.row++) {
            for (rowColumn.column = 0; rowColumn.column < 9; rowColumn.column++) {
                if (grid.get(rowColumn.row).get(rowColumn.column) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

	public static boolean usedInRow(ArrayList<ArrayList<Integer>> grid, int row,int num) {
		for (int col = 0; col < 9; col++) {
			if (grid.get(row).get(col) == num) {
				return true;
			}
		}
		return false;
	}

	public static boolean usedInCol(ArrayList<ArrayList<Integer>> grid, int col,int num) {
		for (int row = 0; row < 9; row++) {
			if (grid.get(row).get(col) == num) {
				return true;
			}
		}
		return false;
	}

	public static boolean usedInBox(ArrayList<ArrayList<Integer>> grid, int boxStartRow, int boxStartCol, int num) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (grid.get(row+boxStartRow).get(col+boxStartCol) == num) {
					return true;
				}
			}
		}
		return false;
	}
	public static boolean isSafe(ArrayList<ArrayList<Integer>> grid , int row ,int col , int num)
	{
		return !usedInRow(grid, row,num) && !usedInCol(grid, col,num) && !usedInBox(grid, row - (row % 3), col - (col % 3), num );
	}
	


    /*
    * Inner class : so that the value of row and column as passed as a reference
    * */
    public static class RowColumn {
        int row;
        int column;

        RowColumn(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
