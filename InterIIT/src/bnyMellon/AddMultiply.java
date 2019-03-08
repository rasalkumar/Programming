package bnyMellon;
import java.util.*;
public class AddMultiply {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			long count = 0;
			int k = in.nextInt();
			Queue<Point> q = new LinkedList<>();
			q.add(new Point(0,0));
			int x = Integer.MAX_VALUE;
			
			while(count < 1000005 && !q.isEmpty())
			{
				Point curr = q.poll();
				if(curr.num == k)
				{
					if(x > curr.numCount)
						x = curr.numCount  ;
				}
				if(curr.num + 1 <= k)
					q.add(new Point(curr.num + 1 , curr.numCount + 1));
				if(curr.num * 2 <= k)
					q.add(new Point(curr.num * 2 , curr.numCount + 1));
				count++;
			}
			System.out.println(x + " **");
			System.out.println(usingDp(k) + "*");
		}
	}
	public static int usingDp(int k)
	{
		int dp[] = new int[4 * k];
		dp[0] = 0;
		for(int i = 1 ; i <= k ; i++ )
		{
			dp[i] = dp[i-1] + 1;
			
			if( (i&1) == 1 )
			{
				dp[i] = dp[i] > dp[i >> 2] + 2 ? dp[i >> 2] + 2 : dp[i] ;
			}
			else
			{
				dp[i] = dp[i] > dp[i >> 2] + 1 ? dp[i >> 2] + 1 : dp[i];
			}
			dp[ i << 1 | 1] = dp[i] + 2;
			dp[ i << 1] = dp[i] + 1;
		}
		return dp[k];
		
	}
	static class Point
	{
		int num;
		int numCount;
		Point(int num,int numCount)
		{
			this.num = num;
			this.numCount = numCount;
		}
	}

}
