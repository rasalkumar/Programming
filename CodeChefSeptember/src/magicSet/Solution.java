package magicSet;

import java.util.*;

class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
			}
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (a[i] % m == 0) {
					count = count + 1;
				}
			}
			long ans = (long) Math.pow(2, count) - 1;
			System.out.println(ans);
		}
	}

}
