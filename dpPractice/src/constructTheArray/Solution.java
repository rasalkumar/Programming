package constructTheArray;
import java.util.*;
public class Solution {
	static long[] dp;
	static long mod = 1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int x = in.nextInt();
		long ans = countArray(n, k, x);
		System.out.println(ans);
			
	}
	public static long countArray(int n,int k, int x)
	{
		dp = new long[n];
		dp[0] = 1;
		for( int i = 1 ; i < n - 2  ; i++ )
		{
			if(i == n - 3)
				dp[i] = (dp[i-1] % mod) * ( ( (((k - 2) * (k-2)) % mod) + (k-1) )  % mod)%mod;
			else
				dp[i] = ((dp[i-1] % mod) * (k - 1)) % mod;
		}
		return dp[n-3] % mod ;
	}
}
