package maximumNumberOfZeros;

import java.util.*;

public class GFG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			String str[] = new String[n];
			int dp[] = new int[n];
			for (int i = 0; i < n; i++)
				str[i] = in.next();
			for (int j = 0; j < n; j++) {
				String s = str[j];
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == '0') {
						dp[j]++;
					}
				}
			}
			int ans = -1;
			for (int i = 0; i < dp.length; i++) {
				ans = Math.max(ans, dp[i]);
			}
			if (ans == 0)
				System.out.println(-1);
			else {
				ArrayList<String> a = new ArrayList<>();

				for (int i = 0; i < dp.length; i++) {
					if (dp[i] == ans) {
						a.add(str[i]);
					}
				}
				Collections.sort(a, new Comparator<String>() {
					public int compare(String p, String q) {
						if (p.length() == q.length()) {
							for (int i = 0; i < Math.min(p.length(), q.length()); i++) {
								int cmp = Integer.compare(p.charAt(i), q.charAt(i));
								if (cmp != 0)
									return cmp;
							}
						}
						return Integer.compare(p.length(), q.length());
					}
				});
				System.out.println(a.get(a.size() - 1));
			}
		}
	}

}
