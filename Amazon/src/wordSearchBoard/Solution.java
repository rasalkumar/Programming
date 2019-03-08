package wordSearchBoard;
import java.util.*;
public class Solution {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			ArrayList<String> s= new ArrayList<>();
			int n = in.nextInt();
			for(int i = 0 ; i < n ; i++	)
			{
				s.add(in.next());
			}
			String search = in.next();
			int ans = exist(s,search);
			System.out.println(ans);
		}
	}
	public static int exist(ArrayList<String> A , String B)
	{
		int n = A.size();
		int m = A.get(0).length();
		int result = 0;
		char[][] board = new char[n][m];
		
		for(int i= 0 ; i < n ; i++)
			for(int j = 0 ; j < m ; j++ )
				board[i][j] = A.get(i).charAt(j);
		
		for(int i= 0 ; i < n ; i++){
			for(int j = 0 ; j < m ; j++ ){
				if(dfs(board,B,i,j,0))
				{
					result = 1;
					break;
				}
			}
			if(result == 1)
				break;
		}
		return result;
	}
	public static boolean dfs(char[][] board,String x ,int i, int j,int k)
	{
		int m = board.length;
		int n = board[0].length;
		if( i < 0 || i >= m || j < 0 || j >= n)
		{
			return false;
		}
		if(board[i][j]== x.charAt(k))
		{
			if(k == x.length()-1)
			{
				return true;
			}
			else
			{
				return(dfs(board , x , i + 1 , j , k + 1)||
				dfs(board , x , i , j + 1 , k + 1)||
				dfs(board , x , i - 1, j , k + 1)||
				dfs(board , x , i , j - 1, k + 1)) ;
			}
		}
		
		return false;
	}
}
