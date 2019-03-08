package mobileNumericKeyGeneration;
import java.util.*;

//ERROR IN CODE : CHECK

public class Solution {
	static int dp[];
	static int[] row = { 0 , 0 , -1 , 0 , 1 };
	static int[] col = { 0 , -1 , 0 , 1 , 0 };
	static char[][] keyboard = {{'1','2','3'},{'4','5','6'},{'7','8','9'},{'*','0','#'}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		dp = new int[n+1];
		for(int i = 0 ; i <= n ; i++)
			dp[i] = -1;
		System.out.println(getCount(n));
	}
	public static int getCountUtil(int i, int j , int n)
	{
		if(keyboard == null || n <= 0)
			return 0;
		if( n == 1)
			return 1;
		if(dp[n] >= 0 )
			return dp[n];
		int r = 0 , move = 0 , c = 0 , totalCount = 0 ; 
		for(move = 0 ; move < 5 ; move++)
		{
			r = i + row[move];
			c = i + col[move];
			if( r >= 0 && r <= 3 && c >=0 && c <= 2 && keyboard[r][c]!='#' && keyboard[r][c] !='*' )
			{
				totalCount += getCountUtil(r,c,n-1);
				
			}
		}
		dp[n] = totalCount;
		return totalCount;
	}
	public static int getCount(int n)
	{
		if(keyboard==null || n <= 0 )
			return 0;
		if(n==1)
			return 10;
		int i = 0 , j = 0 , totalCount = 0;  
		for( i = 0 ; i < 4 ; i++ )
		{
			for( j = 0 ; j < 3 ; j++ )
			{
				totalCount += getCountUtil(i,j,n);
			}
		}
		return totalCount;
		
	}

}
