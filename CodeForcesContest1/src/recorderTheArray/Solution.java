package recorderTheArray;

import java.util.*;

public class Solution {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextLong();
		}
		S
		long dp[][] = new long[n+1][n+1];
		for(int i = 0 ; i <n ; i++ )
		{
			dp[i][0] = 0;
			dp[0][i] = 0;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i] > a[j]) {
					long diff = a[i] - a[j];
					//if(diff)
				}
			}
		}
		long count = 0;
		for (int i = 0; i < n; i++) {
			//if (dp[i] > 0) {
				count++;
			//}
		}
		//System.out.println(count);
	}
}
