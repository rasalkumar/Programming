package romaji;

import java.util.*;

class Solution {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int flag = 0;
		// System.out.println(s.charAt(s.length()-1));
		if (s.charAt(s.length() - 1) != 'a' && s.charAt(s.length() - 1) != 'e' && s.charAt(s.length() - 1) != 'i'
				&& s.charAt(s.length() - 1) != 'o' && s.charAt(s.length() - 1) != 'u'
				&& s.charAt(s.length() - 1) != 'n') {
			flag = 1;
			// System.out.println("***");
		}
		if (flag == 0 && s.length() >= 2) {
			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i - 1) != 'a' && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'i' && s.charAt(i - 1) != 'o'
						&& s.charAt(i - 1) != 'u' && s.charAt(i - 1) != 'n') {
					if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
							|| s.charAt(i) == 'u') {
						continue;
					} else {
						flag = 1;
						// System.out.println("##"+" "+i);
						break;
					}
				}
			}
		}
		if (flag == 1) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}

	}
}
