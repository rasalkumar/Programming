package rockClimbing;

import java.util.*;
public class RockClimbing {

	/*
	 * QUESTION: FIND THE DIFFICULTY OF THE CLIMB. Given a grid( nXm matrix)
	 * containing values 0,1,2 and 3. 0 represents no path. 1 represent an
	 * existing path. 2 is the starting point. 3 is the destination. Starting
	 * point is always at left bottom matrix[n,1]. Destination can be anywhere
	 * in the matrix. It is assured that a path exist. A rockclimber can move
	 * right or left if the adjacent element is also 1. The rockclimber however
	 * climb up or down skip any number of rows the more rows he skip the
	 * greater will the difficulty.
	 */
	static int a[][];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		// di,dj is the destination indices
		// h is the height for the jump or the difficulty
		int  di, dj,  h, ans = -1;
		

		System.out.println("Enter no of testcases");
		int T = in.nextInt();

		for (int t = 1; t <= T; t++) {
			di = dj = 0;
			a = new int[1000][1000];
			System.out.println("Enter Dimensions");
			int n = in.nextInt();
			int m = in.nextInt();
			h = n - 1;
			System.out.println("Enter Elements");
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					a[i][j] = in.nextInt();
					if (a[i][j] == 3) {
						di = i;
						dj = j;
					}
				}
			}

			for (int i = 1; i <= h; i++) {
				ans = traverse( n, m, di, dj, i);
				if (ans >= 1)
					break;
			}
			System.out.println("#" + t + " " + ans);
		}
	}
	static int traverse(int n, int m, int i, int j, int h) {
		int ans, k;
		if (i <= 0 || j <= 0 || i > n || j > m)
			return -1;
		if (a[i][j] == 1 || a[i][j] == 3) {
			int temp = a[i][j];
			a[i][j] = -1;
			
			ans = traverse(n, m , i , j - 1, h);
			if (ans >= 1) {
				return ans;
			}
			for (k = 1; k <= h; k++) {
				ans = traverse( n, m, i + k , j , h);
				if (ans >= 1) {
					return ans;
				}
			}
			ans = traverse( n, m, i , j + 1 , h);
			if (ans >= 1) {
				return ans;
			}
			for (k = 1; k <= h; k++) {
				ans = traverse( n, m, i - k , j , h);
				if (ans >= 1) {
					return ans;
				}
			}
			a[i][j] = temp;
			return ans;
		} else if (a[i][j] <= 0) {
			return -1;
		} else if (a[i][j] == 2)
			return h;
		else
			return -1;
	}
}
