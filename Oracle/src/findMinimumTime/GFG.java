package findMinimumTime;

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int s1 = in.nextInt();
			int s2 = in.nextInt();
			int n = in.nextInt();
			long dp[] = new long[n+1];
			Arrays.fill(dp, 0);
			System.out.println(helper(s1, s2, n, dp));
		}
	}
	public static long helper(int s1,int s2,int n,long[] dp)
	{
		for(int i = 0 ; i <= n ;i ++ )
		{
			dp[i] = Math.min( Math.max((s1 * (n - i)),(s2 * i)) ,
					Math.max((s1 * i) , (s2 * (n - i))) ); 
		}
		long min = Long.MAX_VALUE ;
		for(int i = 0 ; i < n + 1 ; i++)
		{
			min = Math.min(min, dp[i]);
		}
		return min;
	}
}