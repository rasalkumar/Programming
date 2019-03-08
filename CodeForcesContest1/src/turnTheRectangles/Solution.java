package turnTheRectangles;

import java.util.*;

public class Solution {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int width[] = new int[n];
		int height[] = new int[n];
		for (int i = 0; i < n; i++) {
			width[i] = in.nextInt();
			height[i] = in.nextInt();
		}
		int dp[] = new int[n];
		if (width[0] >= height[0]) {
			dp[0] = 1;
		} else {
			dp[0] = 2;
		}
		int p;
		int flag = 0;
		for (int i = 1; i < n; i++) {
			if (dp[i - 1] == 1) {
				p = width[i - 1];
			} else {
				p = height[i - 1];
			}
			if (width[i] <= p && height[i] <= p) {
				if (width[i] >= height[i]) {
					dp[i] = 1;
				}
			} else if (width[i] > p && height[i] <= p) {
				dp[i] = 2;
			} else if (height[i] > p && width[i] <= p) {
				dp[i] = 2;
			} else {
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
