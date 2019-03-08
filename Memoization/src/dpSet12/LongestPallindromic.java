package dpSet12;

import java.util.*;

public class LongestPallindromic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String a = in.next();
		int dp[][] = new int[a.length() + 1][a.length() + 1];
		for (int i = 0; i < a.length() + 1; i++) {
			for (int j = 0; j < a.length() + 1; j++) {
				dp[i][j] = -1;
			}
		}
		LongestPallindromic obj = new LongestPallindromic();
		System.out.println(obj.pal(a, 0, a.length() - 1, dp));
	}

	public int pal(String x, int i, int j, int[][] dp) {
		if (i == j)
			return 1;

		// Base Case 2: If there are only 2 characters and both are same
		if (x.charAt(i) == x.charAt(j) && i + 1 == j)
			return 2;
		if (dp[i][j] >= 0) {
			return dp[i][j];
		}

		// If the first and last characters match
		if (x.charAt(i) == x.charAt(j))
			dp[i][j] = pal(x, i + 1, j - 1, dp) + 2;

		else {// If the first and last characters do not match
			dp[i][j] = Math.max(pal(x, i, j - 1, dp), pal(x, i + 1, j, dp));
		}
		return dp[i][j];
	}

}
