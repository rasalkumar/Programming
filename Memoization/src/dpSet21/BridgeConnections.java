package dpSet21;
import java.util.*;
public class BridgeConnections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String a = in.next();
		int m = a.length();
		String b = in.next();
		int n = b.length();
		int dp[][] = new int[m+1][n+1];
		for(int i = 0 ; i <= m ; i++ )
		{
			for(int j = 0 ; j <= n ; j++ )
			{
				dp[i][j] = -1;
			}
		}
		BridgeConnections obj = new BridgeConnections();
		System.out.println(obj.lcsBridges(a,b,m,n,dp));
	}
	public int lcsBridges(String a,String b,int m,int n,int[][] dp)
	{
		if(n==0)
		{
			return 0;
		}
		if(m==0)
		{
			return 0;
		}
		if(dp[m][n] >= 0)
		{
			return dp[m][n];
		}
		if(a.charAt(m-1) == b.charAt(n-1))
		{
			dp[m][n] = 1 + lcsBridges(a,b,m-1,n-1,dp);
		}else
		{
			dp[m][n] =  Math.max(lcsBridges(a,b,m,n-1,dp) ,lcsBridges(a,b,m-1,n,dp));
		}
		return dp[m][n];
	}

}
