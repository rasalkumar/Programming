package dpSet20;
import java.util.*;
public class ChainOfPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Pair[] pair = new Pair[n];
		for( int i = 0 ; i < n ; i++ )
		{
			int x = in.nextInt();
			int y = in.nextInt();
			pair[i] = new Pair(x,y);
		}
		ChainOfPairs obj = new ChainOfPairs();
		int dp[]= new int[n];
		Arrays.fill(dp, 1);
		System.out.println(obj.lisPair(pair,n,dp));
	}
	public int lisPair(Pair[] pair,int n,int[] dp)
	{
		for(int i = 1 ; i < n; i++ )
		{
			for(int j = 0 ; j < i ; j++ )
			{
				if( pair[i].x >= pair[j].y && dp[i] < dp[j] + 1 )
				{
					dp[i] = dp[j] + 1 ;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i =0 ; i < n; i++ )
		{
			max = Math.max(max, dp[i]);
		}
		return max;
	}
	static class Pair
	{
		int x;
		int y;
		Pair(int x,int y)
		{
			this.x = x;
			this.y = y;
		}
	}
}
