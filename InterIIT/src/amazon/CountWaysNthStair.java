package amazon;
import java.util.*;
public class CountWaysNthStair {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int dp[] = new int[n+1];
		dp[0] = 1 ;
		dp[1] = 1 ;
		for(int i = 2 ; i <= n ; i++)
		{
			dp[i] = 0 ;
			for(int j = 1; j <= m && j <= i ;j++)
			{
				dp[i] += dp[i - j]; 
			}
		}
		System.out.println(dp[n]);

	}

}
