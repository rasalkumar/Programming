package myntra;
import java.util.*;
public class CostOfATree {
static int[] a;
static int[][] dp;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			a = new int[n];
			dp = new int[n][n];
			for(int i = 0 ;i < n ;i++)
			{
				a[i] = in.nextInt();
			}
			for( int i = 0 ; i < n ; i++ )
			{
				for( int j = 0 ; j < n ; j++ )
				{
					dp[i][j] = -1;
				}
			}
			System.out.println(helper(0 ,n-1));
		}

	}
	public static int helper(int i, int j)
	{
		if(i > j)
			return 0;
		if(j == i + 1)
			return a[i]* a[j];
		if(i == j)
			return 0;
		if(dp[i][j] >= 0)
			return dp[i][j];
		dp[i][j] = Integer.MAX_VALUE;
		for(int k = i ; k <= j ; k++ )
		{
			int x = Math.min(dp[i][j],(helper(i ,k-1) * helper(k+1,j))) ;
			int p =  + (max(i,k-1) * max(k+1,j))  ;
			dp[i][j] = Math.min(dp[i][j],p);
		}
		return dp[i][j];
	}
	public static int max(int start ,int end)
	{
		if(start > end)
			return 0;
		int max = Integer.MAX_VALUE;
		for( int i = start ; i <= end  ; i++ )
		{
			max = Math.max( max,a[i]);
		}
		//System.out.println(max);
		return max;
	}

}
