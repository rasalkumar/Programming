package validSudoku;
import java.util.*;
public class Solution {

	public int isValidSudoku(final List<String> board) {
		HashSet set, set2;
		for (int i = 0; i < 9; i++) {
		set = new HashSet();
		set2 = new HashSet();
		for (int j = 0; j < 9; j++) {
		if(!set.add(board.get(i).charAt(j)) && board.get(i).charAt(j) != '.') return 0; //Checking Rows
		if(!set2.add(board.get(j).charAt(i)) && board.get(j).charAt(i) != '.') return 0; //Checking Columns
		}
		}
		// checking 9 boxes
		for (int x = 0; x < 9; x += 3) {
		for (int y = 0; y < 9; y += 3) {
		set = new HashSet();
		for (int i = x; i < x + 3; i++) {
		for (int j = y; j < y + 3; j++) {
		if(!set.add(board.get(i).charAt(j)) && board.get(i).charAt(j) != '.') return 0;
		}
		}
		}
		}
		return 1;
		}
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> sudoku= Arrays.asList("53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79");
		Solution obj= new Solution();
		int ans= obj.isValidSudoku(sudoku);
		System.out.println(ans);
		}

}
