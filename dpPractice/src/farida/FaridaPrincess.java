package farida;
import java.util.*;
class FaridaPrincess {
	static long a[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int m = 1;
		while (t-- > 0) 
		{
			int n = in.nextInt();
			if (n == 0)
				System.out.println("Case " + m++ + ": " + 0);
			else 
			{
				a = new long[n];
				for (int i = 0; i < n; i++) 
					a[i] = in.nextLong();
				long dp[] = new long[n + 1];
				for (int i = 0; i < n + 1; i++)
					dp[i] = -1;
				dp[0] = 0;
				long ans = farida(dp, n);
				System.out.println("Case " + m++ + ": " + ans);
			}
		}
	}
	public static long farida(long[] dp, int n) {

		if (n == 1)                    //Base Case
			return a[0];
		if (dp[n] >= 0)                //Memoization
			return dp[n];
		dp[n] = Math.max(farida(dp, n - 1), farida(dp, n - 2) + a[n - 1]);  //Recursive Step
		return dp[n];
	}

}
