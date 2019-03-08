package dpSet31;
import java.util.*;
public class OptimalStrategyForAGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		for(int i = 0 ; i < n ; i++ )
		{
			a[i] = in.nextInt();
		}
		int dp[][] = new int[n+1][n+1];
		for(int i = 0  ; i <= n ; i++ )
		{
			for(int j = 0 ; j <= n ; j++ )
			{
				dp[i][j] = -1 ;
			}
		}
		OptimalStrategyForAGame obj =new OptimalStrategyForAGame();
		System.out.println(obj.myGame(1,n,a,dp));
	}
	public int myGame(int i,int j ,int[] a ,int[][] dp)
	{
		if( i == 0 || j==0 )
		{
			return 0;
		} 
		if(i==j)
		{
			return a[i-1];
		}
		if( j == i + 1 )
		{
			return Math.max(a[i-1], a[j-1]);
		}
		if(dp[i][j]>=0)
		{
			return dp[i][j];
		}
		dp[i][j] = Math.max(a[i-1] + Math.min(myGame(i+2, j, a, dp), myGame(i+1, j-1, a, dp)),
				            a[j-1] + Math.min(myGame(i, j-2, a, dp), myGame(i+1, j-1, a, dp)));
		return dp[i][j];
	}

}
