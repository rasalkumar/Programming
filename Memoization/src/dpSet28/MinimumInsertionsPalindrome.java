package dpSet28;
import java.util.*;
public class MinimumInsertionsPalindrome {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		String a = in.next();
		int n = a.length();
		int dp[][] =new int[n+1][n+1];
		for(int i = 0 ; i <= n ;i++)
		{
			for(int j = 0 ; j <= n; j++ )
			{
				dp[i][j] = -1 ;
			}
		}
		MinimumInsertionsPalindrome obj = new MinimumInsertionsPalindrome();
		System.out.println(obj.palin(a,0,n-1,dp));
	}
	public int palin(String a,int i,int j, int[][] dp)
	{
		if(i>=j)
		{
			return 0;
		}
		if(dp[i][j]>=0)
		{
			return dp[i][j];
		}
		if(a.charAt(i)!=a.charAt(j))
		{
			dp[i][j] = 1 + Math.min(palin(a, i+1, j, dp), palin(a, i, j-1, dp));
		}
		else
		{
			dp[i][j] = palin(a, i+1, j-1, dp);  
		}
		
		return dp[i][j];
	}
}
