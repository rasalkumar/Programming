package stirlingApprox;
//Find the number of ways to partition a set into k subsets
import java.util.*;
public class StirlingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int [][]dp = new int[n+1][k+1];
		for(int i = 0  ; i <  n ; i++)
		{
			for(int j = 0  ; j < k ; j++ )
			{
				dp[n][k] = -1;
			}
		}
		System.out.println(stirling(n,k,dp));
	}
	public static int stirling(int n,int k, int dp[][])
	{
		if(n==0 || k == 0 || k > n)
			return 0;
		if( k == 1 || k == n )
			return 1;
		if(dp[n][k] >= 0)
			return dp[n][k];
		else
			dp[n][k] = (k * stirling(n-1,k,dp)) + stirling(n-1,k-1,dp);
		return dp[n][k];
	}

}
