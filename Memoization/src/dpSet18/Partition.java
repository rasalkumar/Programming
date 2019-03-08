package dpSet18;
import java.util.*;
public class Partition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		int sum = 0; 
		for( int i = 0 ; i < n ; i++ )
		{
			a[i] = in.nextInt();
			sum += a[i]; 
		}
		if(sum % 2 != 0)
		{
			System.out.println("false");
		}
		else
		{
			boolean dp[][] = new boolean[n+1][(sum/2)+1];
			for(int i = 0 ; i <= n ; i++)
			{
				for(int j = 0 ; j <= (sum / 2) ; j++)
				{
					dp[i][j] = false;
				}
			}
			Partition obj = new Partition();
			System.out.println(obj.sumEqual( n-1, a, sum/2 ,dp));
		}
	}
	public boolean sumEqual(int n,int[]a,int sum,boolean[][] dp)
	{
		if(sum==0)
		{
			return true;
		}
		if(n==0 && sum != 0)
		{
			return false;
		}
		if(a[n-1]>sum)
		{
			dp[n][sum] =  sumEqual(n-1,a,sum,dp);
			return dp[n][sum];
		}
		dp[n][sum] =  sumEqual(n-1,a,sum,dp)||sumEqual(n-1, a, sum-a[n],dp);
		if(dp[n][sum])
		{
			return true;
		}
		return false;
	}

}
