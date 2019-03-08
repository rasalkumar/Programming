package lenghtOfLongestSequence;

import java.util.*;

public class Solution {
	public int longestSubsequenceLength(final List<Integer> a) {

		if (a == null || a.size() == 0)
			return 0;
		if (a.size() == 1)
			return 1;

		int[] lis = new int[a.size()];
		int[] lis2 = new int[a.size()];
		int n = a.size();
		for (int i = 0; i < n; i++) {
			lis[i] = 1;
			lis2[i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a.get(i) > a.get(j) && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;
			}

		}
		for (int i = n - 2; i >= 0; i--)
			for (int j = n - 1; j > i; j--)
				if (a.get(i) > a.get(j) && lis2[i] < lis2[j] + 1)
					lis2[i] = lis2[j] + 1;

		int max = lis[0] + lis2[0] - 1;
		for (int i = 1; i < n; i++) {
			if (lis[i] + lis2[i] - 1 > max)
				max = lis[i] + lis2[i] - 1;

		}
		return max;

	}

	public static void main(String args[]) {
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(3);
		a.add(5);
		a.add(6);
		a.add(4);
		a.add(8);
		a.add(4);
		a.add(3);
		a.add(2);
		a.add(1);
		Solution obj = new Solution();
		System.out.println(obj.longestSubsequenceLength(a));
	}

}
