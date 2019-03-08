package dec11;
import java.util.*;
public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		char[][] grid = new char[n][n];
		
		
	}
	public static int helper(char[][] grid)
	{
		for(int i = 0 ; i  < grid.length ; i++)
		{
			HashSet<Integer> set1 = new HashSet<>();
			HashSet<Integer> set2 = new HashSet<>();
			for(int j = 0 ; j < grid.length ; j++)
			{
				if(!set1.add(grid[i][j] - '0'))
					return 0;
				if(!set2.add(grid[j][i] - '0'))
					return 0;
			}
		}
		
		for( int i = 0 ; i < 9 ; i += 3 )
		{
			for( int j = 0 ; j < 9 ; j += 3 )
			{
				HashSet<Integer> set = new HashSet<>();
				for( int x = i  ; x < i + 3 ; i++ )
				{
					for(int y = j ; y < j + 3 ; j++ )
					{
						if(!set.add(grid[i][j] - '0'))
							return 0;
					}
				}
			}
		}
		return 1;
	}
}
