package longestCommonSubsequence;

import java.util.*;

public class Solution {
	static int dp[][];
	static int[] ans;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int a[] = new int[n];
		int b[] = new int[m];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		for (int i = 0; i < m; i++)
			b[i] = in.nextInt();
		dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				dp[i][j] = -1;
			}
		}
		int x = longestCommonSubsequence(a, b, n, m);
		ans = new int[x];
		int i = n, j = m;
		while (i > 0 && j > 0) {
			if (a[i - 1] == b[j - 1]) {
				ans[x - 1] = a[i - 1];
				i--;
				j--;
				x--;
			} else if (dp[i - 1][j] > dp[i][j - 1])
				i--;
			else
				j--;
		}
		for (int k = 0; k < ans.length; k++) {
			System.out.print(ans[k] + " ");
		}
		System.out.println();

	}

	public static int longestCommonSubsequence(int[] a, int[] b, int n, int m) {
		if (n == 0 || m == 0)
			return 0;
		if (a[n - 1] == b[m - 1]) {

			dp[n][m] = 1 + longestCommonSubsequence(a, b, n - 1, m - 1);
		} else {
			dp[n][m] = Math.max(longestCommonSubsequence(a, b, n, m - 1), longestCommonSubsequence(a, b, n - 1, m));
		}
		return dp[n][m];
	}

}
