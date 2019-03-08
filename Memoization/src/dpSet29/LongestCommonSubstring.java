package dpSet29;

import java.util.*;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String a = in.next();
		int m = a.length();
		String b = in.next();
		int n = b.length();
		int dp[][] = new int[m + 1][n + 1];
		LongestCommonSubstring obj = new LongestCommonSubstring();
		System.out.println(obj.lcs(a, m , b, n , dp));
	}

	public int lcs(String a, int m, String b, int n, int[][] dp) {
		int result = 0;
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = 0;
				}

			}
		}
		for(int i = 0 ;i <= m ; i++ )
		{
			for(int j = 0 ; j <= n ; j++ )
			{
				result = Math.max(result, dp[i][j]); 
			}
		}
		return result;
	}

}
