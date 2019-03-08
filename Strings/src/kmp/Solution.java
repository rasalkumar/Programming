package kmp;

public class Solution {
	static int F[] = new int[8];

	public static void main(String args[]) {
		String text = "bacbababababacaca";
		String pattern = "ababaca";
		char[] c1 = text.toCharArray();
		char[] c2 = pattern.toCharArray();
		Solution obj1 = new Solution();
		int noOfShifts = obj1.patternMatchingKMP(c1, c1.length, c2, c2.length);
		if (noOfShifts < 0) {
			System.out.println("Pattern not found");
		}
	}

	private int patternMatchingKMP(char[] T, int m, char[] P, int n) {
		Solution obj = new Solution();
		obj.prefixTable(P, n);
		int i = 0, j = 0;
		while (i < m) {
			if (T[i] == P[j]) {
				if (j == n - 1) {
					System.out.println("Pattern Exists");
					return i - j;
				} else {
					i++;
					j++;
				}
			} else if (j > 0) {
				j = F[j - 1];
			} else {
				i++;
			}
		}
		return -1;
	}

	private void prefixTable(char[] P, int n) {
		int i = 1;
		int j = 0;
		F[0] = 0;
		while (i < n) {
			if (P[i] == P[j]) {
				F[i] = j + 1;
				i++;
				j++;
			} else if (j > 0) {
				j = F[j - 1];
			} else {
				F[i] = 0;
				i++;
			}
		}

	}

}
