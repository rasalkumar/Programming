package seats;

public class Solution {

	private static final int MOD = 10000003;

	public int seats(String A) {
		int n;
		int i;
		int first, last;
		int countLeft[];
		int total = 0;
		int midVal;

		if (A == null || A.length() == 0)
			return 0;

		n = A.length();
		countLeft = new int[n];
		first = last = -1;

		for (i = 0; i < n; i++) {
			countLeft[i] = i > 0 ? countLeft[i - 1] : 0;

			if (A.charAt(i) == 'x') {
				if (first == -1)
					first = i;
				last = i;
				countLeft[i]++;
				total++;
			}
		}

		midVal = (total + 1) / 2;

		if (first == -1 || first == last)
			return 0;

		int mid;

		for (i = first; i <= last; i++) {
			if (countLeft[i] == midVal)
				break;
		}

		mid = i;

		long res = 0;
		int count = 0;

		for (i = mid; i >= first; i--) {
			if (A.charAt(i) == 'x') {
				res += (mid - i - count);
				res %= MOD;
				count++;
			}
		}

		count = 0;

		mid++;
		for (i = mid; i <= last; i++) {
			if (A.charAt(i) == 'x') {
				res += (i - mid - count);
				res %= MOD;
				count++;
			}
		}

		return (int) res;
	}

	public static void main(String[] args) {
		String a = "....x..xx...x..";
		Solution obj = new Solution();
		System.out.println(obj.seats(a));
	}

}
