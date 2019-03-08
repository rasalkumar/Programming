package dpSet5;

import java.util.Scanner;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int m = in.nextInt();
			int n = in.nextInt();
			String x = in.next();
			String y = in.next();
			// int m = x.length();
			// int n = y.length();
			EditDistance obj = new EditDistance();
			int dp[][] = new int[m + 1][n + 1];
			for (int i = 0; i <= m; i++) {
				for (int j = 0; j <= n; j++) {
					dp[i][j] = -1;
				}
			}
			int ans = obj.editDist(x, y, m, n, dp);
			System.out.println(ans);
		}
	}

	public int editDist(String x, String y, int m, int n, int[][] dp) {
		if (m == 0) {
			return n;
		}
		if (n == 0) {
			return m;
		}
		if (dp[m][n] >= 0) {
			return dp[m][n];
		}
		if (x.charAt(m - 1) == y.charAt(n - 1)) {
			dp[m][n] = editDist(x, y, m - 1, n - 1, dp);
		} else {
			dp[m][n] = 1 + Math.min(editDist(x, y, m, n - 1, dp),
					Math.min(editDist(x, y, m - 1, n, dp), editDist(x, y, m - 1, n - 1, dp)));
		}
		return dp[m][n];
	}

}
