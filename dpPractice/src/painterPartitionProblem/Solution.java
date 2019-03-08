package painterPartitionProblem;
import java.util.*;
public class Solution {
	static int[][] dp;
	static int[] a;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		a = new int[n];
		for(int i = 0 ; i < n ; i++ )
			a[i] = in.nextInt();
		dp = new int[n+1][k+1];
		for(int i = 0 ; i <= n ; i++ )
		{
			for(int j = 0 ; j <= k ; j++ )
			{
				dp[i][j] = -1; 
			}
		}
		System.out.println(partition(n,k));
	}
	public static int partition(int n,int k)
	{
		if( k == 1 )                                  //One Partition
			return sum(0,n-1);
		if(n==1)                                     //One Board   
			return a[0];
		if(dp[n][k] >= 0 )                           //Memoization
			return dp[n][k];
		int best = Integer.MAX_VALUE;
		for(int i = 1 ; i <= n; i++ )
			best = Math.min(best, Math.max( partition( i , k - 1 ) , sum( i , n - 1 )));  //Recursive Step
		dp[n][k] = best;
		return best;
	}
	public static int sum(int start,int end)
	{
		int sum = 0; 
		for(int i = start; i <= end ; i++)
			sum += a[i];
		return sum;
	}
}
