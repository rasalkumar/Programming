package dpSet9;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int dp[][] = new int[n+1][k+1];
		for(int i  = 0 ; i < n+1 ; i++)
		{
			for(int j = 0 ; j < k+1 ; j++)
			{
				dp[i][j] = -1;
			}
		}
		Solution obj = new Solution();
		System.out.println(obj.binomial(n,k,dp));
		
	}
	public int binomial(int n, int k,int[][] dp)
	{
		if(k==0||k==n)
		{
			return 1;
		}
		if(k>n)
		{
			return 0;
		}
		if(dp[n][k]>=0)
		{
			return dp[n][k];
		}
		else
		{
			dp[n][k] = binomial(n-1,k-1,dp) + binomial(n-1,k,dp) ; 
		}
		return dp[n][k];
	}

}
