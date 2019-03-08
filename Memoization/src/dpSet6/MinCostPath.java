package dpSet6;
import java.util.*;
public class MinCostPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
		int m  = in.nextInt();
		int n  = in.nextInt();
		int[][] dp = new int[m][n];
		int[][] a = new int[m][n];  
		for(int i = 0 ; i < m ; i++ )
		{
			for(int j = 0 ; j < n ;j++)
			{
				a[i][j] = in.nextInt(); 
				dp[i][j] = -1;
			}
		}
		MinCostPath obj = new MinCostPath();
		System.out.println(obj.minCost(m-1,n-1,dp,a));
		}
	}
	public int minCost(int m, int n, int[][] dp, int[][] a)
	{
		if(m==0 && n==0)
		{
			return a[0][0];
		}
		if(n==0)
		{
			return a[m][0] + minCost(m-1,0,dp,a);
		}
		if(m==0)
		{
			return a[0][n] + minCost(0,n-1,dp,a);
		}
		if(dp[m][n]>=0)
		{
			return dp[m][n];
		}
		else
		{
			dp[m][n] =a[m][n] + Math.min(minCost(m,n-1,dp,a), Math.min(minCost(m-1,n,dp,a), minCost(m-1,n-1,dp,a)));
		}
		return dp[m][n] ; 
	}

}
