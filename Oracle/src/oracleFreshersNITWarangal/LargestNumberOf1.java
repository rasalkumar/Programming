package oracleFreshersNITWarangal;
import java.util.*;
public class LargestNumberOf1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int m = in.nextInt();
			int n = in.nextInt();
			int a[][] = new int[m][n];
			for(int i = 0 ; i < m ; i++ )
			{
				for(int j = 0 ; j < n ; j++ )
				{
					a[i][j] = in.nextInt();
				}
			}
			int dp[][] = new int[m][n];
			for(int i = 0 ; i < m ; i++ )
				for(int j = 0 ; j < n ; j++ )
					dp[i][j] = 0;
			int ans =subMatrixWithLargestOnes(a,dp,m,n,a[0][0]);
			System.out.println(ans);
		}
	}
	public static int subMatrixWithLargestOnes(int[][] a,int[][] dp,int m,int n,int max)
	{
		if(a[0][0]==1)
			dp[0][0] = 1 ;
		for(int i = 1 ; i < m ; i++ )
			if(a[i][0]==1)
				dp[i][0] = dp[i-1][0] + 1;
		
		for(int i = 1 ; i < n ; i++ )
			if(a[0][i]==1)
				dp[0][i] = dp[0][i-1] + 1;
		
		for(int i = 1 ; i < m ;i++)
		{
			for(int j = 1 ; j < n ; j++ )
			{
				if( a[i][j] == 0 )
				{
					dp[i][j] = 0 ;
				}
				else
				{
					dp[i][j] = 1 + Math.min( dp[i-1][j-1] , Math.max(dp[i-1][j],dp[i][j-1]));
					if(dp[i][j] > max)
					{
						max = dp[i][j];
					}
				}
			}
		}
		return max;
	}
}
