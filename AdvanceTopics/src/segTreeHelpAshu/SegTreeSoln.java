package segTreeHelpAshu;

import java.util.Scanner;

public class SegTreeSoln {

	static int tree[];
	static int arr[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		tree = new int[300000];
		arr = new int[200000];
		for (int i = 1; i <= n; i++) {
			int g = in.nextInt();
			arr[i] = g % 2 == 0 ? 1 : 0;
		}

		build(1, 1, n);
		/*
		 * for(int k=1;k<2*n;k++) System.out.println( k + " " + tree[k] );
		 */

		int t = in.nextInt();
		while (t-- > 0) {
			int chk = in.nextInt();
			if (chk == 1) {
				int a = in.nextInt();
				int b = in.nextInt();
				System.out.println(query(1, 1, n, a, b));
			} else if (chk == 0) {
				int idx, val;
				idx = in.nextInt();
				val = in.nextInt();
				update(1, 1, n, idx, val % 2 == 0 ? 1 : 0);
			} else {
				int a, b;
				a = in.nextInt();
				b = in.nextInt();
				System.out.println(b - a + (b != a ? 1 : 0) - query(1, 1, n, a, b));
			}
		}
	}

	static void build(int i, int start, int end) {
		if (start == end) {
			tree[i] = arr[start]; // Leaf node will have a single element
		} else {
			int mid = (start + end) / 2;
			build(2 * i, start, mid);// Recurse on the left child
			build(2 * i + 1, mid + 1, end);// Recurse on the right child
			tree[i] = tree[2 * i] + tree[2 * i + 1];// Internal node will have
													// the sum of both of its
													// children
		}
	}

	static void update(int i, int st, int en, int idx, int val) {
		if (st == en) // Leaf node
		{
			tree[i] = tree[i] - arr[idx] + val;
			arr[idx] = val;
		} else {
			int mid = (st + en) / 2;
			if (st <= idx && idx <= mid) // If idx is in the left child, recurse
											// on the left child
			{
				update(2 * i, st, mid, idx, val);
			} else// if idx is in the right child, recurse on the right child
			{
				update(2 * i + 1, mid + 1, en, idx, val);
			}
			tree[i] = tree[2 * i] + tree[2 * i + 1];// Internal node will have
													// the sum of both of its
													// children
		}
	}

	static int query(int i, int start, int end, int l, int r) {
		if (r < start || end < l) // range represented by a node is completely
									// outside the given range
		{
			return 0;
		}
		if (l <= start && end <= r) // range represented by a node is completely
									// inside the given range
		{
			return tree[i];
		}
		// range represented by a node is partially inside and partially outside
		// the given range
		int mid = (start + end) / 2;
		int p1 = query(2 * i, start, mid, l, r);
		int p2 = query(2 * i + 1, mid + 1, end, l, r);
		return (p1 + p2);
	}
}