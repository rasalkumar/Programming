package dec9;

import java.util.*;

public class TollGate {
	static int n;
	static int t[];
	static int cc[];
	static int min_cost = 1000000007;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		t = new int[n];
		cc = new int[n];
		for (int i = 0; i < n; i++) {
			t[i] = in.nextInt();
			cc[i] = in.nextInt();
		}
		dfs(0, 0, 0, 0, 0);
		System.out.println(min_cost);
	}

	public static void dfs(int p, int a, int b, int c, int cost) {
		int aSum = a + b + c;
		if (cost > min_cost)
			return;
		if (p == n - 1) {
			if (aSum < t[p]) {
				cost = cost + cc[p];
				if (cost > min_cost)
					return;
				if (cost < min_cost)
					min_cost = cost;
			}
		}
		dfs(p + 1, 0, a, b, cost + cc[p]);
		dfs(p + 1, a + t[p], a, b, cost + 2 * cc[p]);
		if (t[p] > b + c) {
			aSum = aSum - t[p];
		}
		if (t[p] > c) {
			b = t[p] - c >= b ? 0 : b - t[p] + c;
		}
		dfs(p + 1, 0, a, b, cost);
	}

}
