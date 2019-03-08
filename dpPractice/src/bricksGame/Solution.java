package bricksGame;
import java.util.*;
public class Solution {
	static int[] dp;
	static int a[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			a = new int[100005];
			for( int i = 0 ; i < n ; i++ )
			{
				a[i] = in.nextInt();
			}
			dp =new int[n +1];
			Arrays.fill(dp , -1);
			int ans = helper( 0 , n );
			System.out.println(ans);
		}
	}
	
	public static int helper(int n,int size)
	{
		if(n >= size)
		{
			return 0;
		}
		if(dp[n] >= 0)
		{
			return dp[n];
		}
		dp[n] = Math.max(a[n] + Math.min(helper(n+2, size),Math.min(helper(n+3,size),helper(n+4,size))),
				Math.max(a[n] + a[n+1] + Math.min(helper(n+3,size),Math.min(helper(n+4,size),helper(n+5,size))),
						a[n] + a[n+1] + a[n+2] + Math.min(helper(n+4,size),Math.min(helper(n+5,size),helper(n+6,size)))));
		
		return dp[n];
	}
	
}
