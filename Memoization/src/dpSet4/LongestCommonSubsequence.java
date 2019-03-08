package dpSet4;

import java.util.*;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			String x = in.next();
			String y = in.next();
			int m = x.length();
			int n = y.length();
			LongestCommonSubsequence obj = new LongestCommonSubsequence();
			int dp[][] = new int[m + 1][n + 1];
			for (int i = 0; i <= m; i++) {
				for (int j = 0; j <= n; j++) {
					dp[i][j] = -1;
				}
			}
			int ans = obj.lcs(x, y, m, n, dp);
			System.out.println(ans);
		}
	}

	public int lcs(String x, String y, int m, int n, int[][] dp) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (dp[m][n] >= 0) {
			return dp[m][n];
		}
		if (x.charAt(m - 1) == y.charAt(n - 1)) {
			dp[m][n] = 1 + lcs(x, y, m - 1, n - 1, dp);
		} else {
			dp[m][n] = Math.max(lcs(x, y, m, n - 1, dp), lcs(x, y, m - 1, n, dp));
		}
		return dp[m][n];
	}

}
