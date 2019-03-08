package p222;
import java.lang.reflect.Array;
import java.util.*;
public class PerfectSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int ans = numPrimes(n);
		System.out.println(ans);
	}
	public static int numPrimes(int n)
	{
		int max = (int) Math.sqrt(n);
		int[] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		//ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1 ; i <= n ; i++ )
		{
			for(int j = 1; j <= max ; j++)
			{
				if(( j * j ) == i )
				{
					dp[i] = 1;
				}
				if( i > ( j * j ) )
				{
					dp[i] = Math.min( dp[i], dp[i-(j*j)] + 1 );
				}
			}
		}
		//System.out.println(list);
		return dp[n];
	}

}
