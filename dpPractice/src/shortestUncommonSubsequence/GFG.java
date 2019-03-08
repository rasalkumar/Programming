package shortestUncommonSubsequence;

import java.util.*;

public class GFG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int m = in.nextInt();
			int n = in.nextInt();
			String s1 = in.next();
			String s2 = in.next();
			int dp[][] = new int[m + 1][n + 1];
			for (int i = 0; i < m; i++) {
				dp[m][0] = 0;
			}
			for (int i = 0; i < n; i++) {
				dp[0][i] = 0;
			}
			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= n; j++) {
					if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
						dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
					}
					else
					{
						//dp[i][j] = 
					}
				}
			}
		}

	}

}
