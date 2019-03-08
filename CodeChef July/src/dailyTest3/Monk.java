package dailyTest3;

import java.util.*;

public class Monk {
	static int m[][];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int k = in.nextInt();
			m = new int[n][n];
			long[] sum = new long[n];
			long[] sum2 = new long[n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					m[i][j] = in.nextInt();
					sum[i] += m[i][j];
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sum2[i] += m[j][i];
				}
			}
			long ans = 0;
			long res = 0;

			long min = Long.MAX_VALUE;
			long min2 = Long.MAX_VALUE;
			int y = -1;
			int z = -1;
			for (int i = 0; i < n; i++) {
				if (sum[i] < min) {
					min = sum[i];
					y = i;
				}
			}
			for (int i = 0; i < n; i++) {
				if (sum2[i] < min2) {
					min2 = sum2[i];
					z = i;
				}
			}
			for (int i = 0; i < k; i++) {
				res = Math.min(min, min2);
				ans += res;
				if (res == min) {
					sum[y] += n;
					for (int p = 0; p < n; p++) {
						sum2[p]++;
					}
				} else if(res == min2) {
					sum2[z] += n;
					for (int p = 0; p < n; p++) {
						sum[p]++;
					}
				}
				min = Long.MAX_VALUE;
				min2 = Long.MAX_VALUE;
				for (int j = 0; j < n; j++) {
					if (sum[j] < min) {
						min = sum[j];
						y = j;
					}
				}
				for (int j = 0; j < n; j++) {
					if (sum2[j] < min2) {
						min2 = sum2[j];
						z = j;
					}

				}
			}
			System.out.println(ans);
		}
	}
}
