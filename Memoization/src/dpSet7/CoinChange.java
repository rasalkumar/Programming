package dpSet7;

import java.util.*;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] s = new int[m];
		for (int i = 0; i < m; i++) {
			s[i] = in.nextInt();
		}
		Arrays.sort(s);
		int[] dp = new int[n + 1];
		for (int j = 0; j < n + 1; j++) {
			dp[j] = Integer.MIN_VALUE;
		}

		CoinChange obj = new CoinChange();
		System.out.println(obj.coins(m , n, dp, s));
	}

	public int coins(int m, int n, int[] dp, int[] s)
	{
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}
		if (m <= 0 && n >= 1) {
			return 0;
		}
		if (dp[n] > 0) {
			return dp[n];
		} else {
			if(s[m-1]>n)
			{
				return coins(m-1,n,dp,s);
			}
			else{
			for(int i  = s[m-1] ; i <= n ;i++)
					dp[i] = coins(m-1, n , dp, s) + coins(m, n - s[m-1], dp, s);

			}
		}
		return dp[n];
		
	}

}
