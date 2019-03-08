package dpSet30;
import java.util.*;
public class DiceThrow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int x = in.nextInt();
		int dp[][] = new int[m+1][x+1];
		for(int i = 0 ; i <= m ; i++ )
		{
			for(int j = 0 ; j <= x ; j++ )
			{
				dp[i][j] = 0; 
			}
		}
		DiceThrow obj = new DiceThrow();
		System.out.println(obj.getSum(m,x,dp));
	}
	public int getSum(int m, int x,int[][] dp)
	{
		if( m <= 0 || x < 0 )
		{
			return 0;
		}
		if( x == 0 )
		{
			return 1;
		}
		if( dp[m][x] >= 0 )
		{
			return dp[m][x];
		}
		int max = Integer.MIN_VALUE;
		for(int i = 1 ; i <= m && i < x ; i++ )
		{
			dp[m][x] = Math.max(max, getSum( m - 1 , x - i , dp ) + dp[m][x]);
		}
		return dp[m][x];
	}
}
