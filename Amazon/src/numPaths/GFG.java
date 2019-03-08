package numPaths;

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	static int count;

	static void solve(int arr[][], int a, int b, int n, int sum, int k) {
		sum += arr[a][b];
		if (a == n - 1 && b == n - 1 && sum == k) {
			count++;
			return;
		}
		if (a == n - 1 && b == n - 1)
			return;

		if (a < n - 1) {
			solve(arr, a + 1, b, n, sum, k);
		}

		if (b < n - 1) {
			solve(arr, a, b + 1, n, sum, k);
		}

	}

	public static void main(String[] args) {
		// code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- != 0) {
			count = 0;
			int k = in.nextInt();
			int n = in.nextInt();
			int arr[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					arr[i][j] = in.nextInt();
			}
			solve(arr, 0, 0, n, 0, k);
			System.out.println(count);
		}
	}
}