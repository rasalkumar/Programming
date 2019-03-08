package bnyMellon;
import java.util.*;
public class StarTopBottomReturn {
static int n = 5,m = 5;
static int dp[][][];
static char[][] grid =  { 
        { '.', '*', '.', '*', '.' }, 
        { '*', '#', '#', '#', '.' }, 
        { '*', '.', '*', '.', '*' }, 
        { '.', '#', '#', '#', '*' }, 
        { '.', '*', '.', '*', '.' } 
    };
static int max = 5;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int ans = 0 ;
		dp = new int[max][max][max];
		for(int i = 0 ; i < max ; i++)
		{
			for(int j = 0 ; j < max ; j++ )
			{
				for(int k = 0 ; k < max ; k++ )
				{
					dp[i][j][k] = -1 ;
				}
			}
		}
		//System.out.println(cost);
		System.out.println(helper());
		for(int i = 0 ; i < max ; i++)
		{
			for(int j = 0 ; j < max ; j++ )
			{
				for(int k = 0 ; k < max ; k++ )
				{
					System.out.print(dp[i][j][k]+" ") ;
				}
			}
			System.out.println();
		}
		  	

	}
	public static int helper()
	{
		int ans = 0;
		//System.out.println(n +" "+ m);
		if (grid[n - 1][m - 1] == '#' || grid[0][0] == '#') 
	        ans = -1 * Integer.MAX_VALUE; 
	  
	    // If top left cell contain * 
	    if (grid[0][0] == '*') 
	        ans++; 
	    grid[0][0] = '.'; 
	  
	    // If bottom right cell contain * 
	    if (grid[n - 1][m - 1] == '*') 
	        ans++; 
	    grid[n - 1][m - 1] = '.'; 
	    System.out.println(ans);
	    ans += solve(0, 0, 0); 
	    return Math.max(ans, 0); 
	}
	public static int cost(int row1,int col1,int row2,int col2 )
	{
		if(row1 == col1 && row2 == col2)
		{
			if(grid[row1][col1] == '*')
				return 1;
			else 
				return 0;
		}
		else
		{
			int ans = 0;
			if(grid[row1][col1] == '*' )
			{
				ans++;
			}
			if(grid[row2][col2] == '*')
				ans++;
			return ans;
		}
		
	}
	public static int solve(int row1,int col1 ,int row2 )
	{
		int col2 = row1 + col1 - row2;
		if(row1 == n-1 && col1 == m - 1 && row2 == n - 1 && col2 == m - 1 )
		{
			return 0;
		}
		if(row1 >= n || col1 >= m || row2 >= n || col2 >= m)
		{
			return -1 * Integer.MAX_VALUE;
		}
		if(dp[row1][col1][row2] != -1)
			return dp[row1][col1][row2];
		
		int ch1 = -1 * Integer.MAX_VALUE;
		int ch2 = -1 * Integer.MAX_VALUE;
		int ch3 = -1 * Integer.MAX_VALUE;
		int ch4 = -1 * Integer.MAX_VALUE;
		
		if(row1 < n && col1 + 1 < m && row2 + 1 < n && col2 < m && 
				grid[row1][col1 + 1] != '#' && grid[row2 + 1][col2] != '#') //Path1 right Path2 down
		{
			//System.out.println();
			ch1 = cost(row1, col1+1, row2 + 1, col2) + solve(row1,col1 +1,row2 +1); 
		}
		if(row1 < n && col1 + 1 < m && row2 < n && col2 + 1< m &&
				grid[row1][col1 + 1] != '#' && grid[row2][col2+1] != '#') //Path11 right Path2 right
		{
			ch2 = cost(row1,col1+1,row2,col2+1) + solve(row1,col1+1,row2);
		}
		if(row1 + 1 < n && col1 < m && row2 < n && col2 + 1 < m &&
				grid[row1+1][col1] != '#' && grid[row2][col2+1] != '#') //Path11 down Path2 right
		{
			ch3 = cost(row1+1,col1,row2,col2+1) + solve(row1+1,col1,row2);
		}
		if(row1 + 1 < n && col1 < m && row2 + 1 < n && col2 < m &&
				grid[row1+1][col1] != '#' && grid[row2+1][col2] != '#') //Path11 down Path2 down
		{
			ch4 = cost(row1+1,col1,row2+1,col2) + solve(row1+1,col1,row2+1);
		}
		return dp[row1][col1][row2] =  Math.max(Math.max(ch1, ch2) , Math.max(ch3, ch4));
	}

}
