package catalanNumbers;

import java.util.*;

public class GFG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			if (n == 0) {
				System.out.println(1);
			} else {
				int[] dp = new int[n];
				for (int i = 0; i < n; i++) {
					dp[i] = 0;
				}
				GFG obj = new GFG();
				System.out.println(obj.catalan(n , dp));
			}
		}
	}

	public int catalan(int j, int[] dp) {
		if (j <= 1) {
			return 1;
		}
		if (dp[j - 1] > 0) {
			return dp[j - 1];
		}
		dp[j - 1] = 0;
		for (int i = 0; i < j; i++) {
			dp[j - 1] += (catalan(i, dp) * (catalan(j - i - 1, dp)));
		}
		return dp[j - 1];
	}

}
