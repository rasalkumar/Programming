package summingPieces;
import java.util.*;
public class Solution {
	static int mod = 1000000007;
	static long dp[][];
	static int[] a;
	static long ans = 0;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		a = new int[n]; 
		for(int i = 0 ; i < n ;i++ )
			a[i] =in.nextInt();
		dp = new long[n+1][n+1];
		for(int i = 0 ; i <= n ; i++ )
		{
			for( int j = 0 ;j <= n ; j++ )
			{
				dp[i][j] = 0 ; 
			}
		}
		ans = 0;
		System.out.println(cost(0 , n - 1));
	}
	public static long cost(int i,int j)
	{
		if(i > j)
			return 0;
		if(i == j)
			return a[i];
		if(dp[i][j] > 0)
			return dp[i][j];
		for(int k = i ; k < j ;k++ )
		{
			dp[i][j] += (cost(i , k) + cost(k + 1 , j) + 
					(sum(i,k)*(k-i)) + (sum(k+1,j)*(j - k - 1)))%mod;
			//ans = ans + dp[i][j];
		}
		return dp[i][j] % mod ;
	}
	public static long sum(int i ,int j)
	{
		long sum =0 ;
		for( int k = i ; k <= j ; k++ )
			sum +=a[k];
		return sum;
	} 
}
