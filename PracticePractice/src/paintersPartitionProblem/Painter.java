package paintersPartitionProblem;
import java.util.*;
public class Painter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			int k = in.nextInt();
			int a[] = new int[n];
			for(int i = 0 ; i < n ; i++)
				a[i] = in.nextInt();
			int dp[][] = new int[n + 1][k + 1];
			for(int i = 0 ; i <= n ; i++ )
			{
				for(int j = 0 ; j <= k ; j++ )
				{
					dp[i][j] = -1 ;
				}
			}
			System.out.println(painterPartition(n,k,a,dp));
		}
	}
	public static int painterPartition(int n, int k ,int[] a, int[][] dp)
	{
		if(k == 1)
			return sum(a,0,n-1);
		if(n == 1)
			return a[0];
		if(dp[n][k] >= 0)
			return dp[n][k];
		int best = Integer.MAX_VALUE;
		for(int i = 1 ; i <= n ; i++ )
			best = Math.min(best, Math.max(painterPartition(i, k-1, a, dp), sum(a,i,n-1)));
		dp[n][k] = best;
		return best; 
	}
	public static int sum(int[] a,int start,int end)
	{
		int sum = 0 ;
		for(int i = start ; i <= end ; i++ )
			sum += a[i];
		return sum;
	}
}
