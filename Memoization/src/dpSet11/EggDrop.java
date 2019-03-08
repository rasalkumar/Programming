package dpSet11;
import java.util.*;
public class EggDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int dp[][] = new int[n+1][k+1];
		for(int i = 0  ; i <= n ; i++ )
		{
			for(int j = 0 ; j <= k ; j++ )
			{
				dp[i][j] = -1 ; 
			}
		}
		EggDrop obj = new EggDrop();
		System.out.println(obj.eggMystery(n,k,dp));
	}

	private int eggMystery(int n, int k, int[][] dp) {
		// TODO Auto-generated method stub
		if(k == 1 || k == 0)
		{
			return k;
		}
		if(n == 1)
		{
			return k ; 
		}
		if(dp[n][k] >= 0)
		{
			return dp[n][k];
		}
		dp[n][k] =Integer.MAX_VALUE;
		for(int i = 1  ; i <= k ; i++)
		{
			dp[n][k] = Math.min(dp[n][k],1 + Math.max(eggMystery(n-1,i-1, dp), eggMystery(n, k-i, dp)));
			
		}
		return dp[n][k];
	}
}
