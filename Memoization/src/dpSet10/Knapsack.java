package dpSet10;
import java.util.*;
public class Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int val[] = new int[n];
		int wt[] = new int[n];
		for(int i = 0 ; i < n ; i++ )
		{
			val[i] = in.nextInt();
		}
		for(int i = 0 ; i < n ; i++ )
		{
			wt[i] = in.nextInt();
		}
		int W = in.nextInt();
		int dp[][] = new int[n+1][W+1];
		for(int i = 0 ; i <= n ; i++ )
		{
			for(int j = 0 ; j <= W; j++ )
			{
				dp[i][j] = -1;
			}
		}
		Knapsack obj = new Knapsack();
		System.out.println(obj.zeroOneKnap(n,val,wt,W,dp));
		
	}

	public int zeroOneKnap(int n, int[] val, int[] wt, int w, int[][] dp) {
		// TODO Auto-generated method stub
		if(n == 0 || w == 0)
		{
			return 0;
		}
		if(wt[n-1]>w)
		{
			return zeroOneKnap(n-1, val, wt, w, dp) ;
		}
		if(dp[n][w] >= 0)
		{
			return dp[n][w];
		}
		else
		{
			dp[n][w] =  Math.max( val[n-1] + zeroOneKnap(n-1,val,wt,w-wt[n-1],dp) , zeroOneKnap(n-1,val,wt,w,dp) );
		}
//		for(int i = 0 ; i <= n ; i++ )
//		{
//			for(int j = 0 ; j <= w; j++ )
//			{
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		return dp[n][w];
	}

}
