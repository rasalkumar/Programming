package ethanSearchesForString;

import java.util.*;

public class Solution {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int m = 1;
		while (t-- > 0) {
			String s = in.next();
			int i = 0;
			int j = 1;
			int flag = 0;
			while (i < s.length() && j < s.length() && i < j) {
				if (s.charAt(i) == s.charAt(j)) {
					StringBuilder p = new StringBuilder(s.substring(0, j));
					p.append(s);
					// System.out.println(String.valueOf(p));
					if (!contains(s, String.valueOf(p), 0, 0)) {
						flag = 1;
						System.out.println("Case #" + m + ": " + String.valueOf(p));
						break;
					}
				}
				j = j + 1;

			}
			if (flag == 0) {
				System.out.println("Case #" + m + ": " + "Impossible");
			}
			m = m + 1;
		}
		
	}

	public static boolean contains(String a, String b, int i, int j) {
		if (i > a.length() - 1) {
			return true;
		}
		if (j > b.length() - 1) {
			return false;
		}
		if (a.charAt(i) == b.charAt(j)) {
			i += 1;
			j += 1;
			return contains(a, b, i, j);
		}
		if (i == 0) {
			j += 1;
			return contains(a, b, i, j);
		}
		i = 0;
		return contains(a, b, i, j);
	}
}
