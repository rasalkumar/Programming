package calc;

import java.io.*;
import java.util.*;

class Pair {
	long N;
	long B;

	Pair(long n2, long b2) {
		this.N = n2;
		this.B = b2;
	}
}

class Solution {

	public ArrayList<Long> calc(ArrayList<Pair> p) {
		ArrayList<Long> result = new ArrayList<Long>();

		if (p == null || p.size() == 0) {
			result.add((long) 0);
		}

		for (int k = 0; k < p.size(); k++) {
			long N = p.get(k).N;
			long B = p.get(k).B;
			if (B >= N) {
				result.add((long) 0);
				continue;
			}
			long x = N / 2;
			long clicks = x / B;
			if (B >= x) {
				clicks = 1;
				long val = N - B;
				result.add(val);
				continue;
			} else {
				if (N / B == 0) {
					x = B;
					long val = ((N / B) - 1) * x;
					result.add(val);
				} else {
					long r = N % B;
					long m = (N / B) + r;
					result.add(((N / B) - 1) * m);
				}

			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {

		long N, B;
		Scanner scanner = new Scanner(System.in);

		int T;

		Solution obj = new Solution();
		ArrayList<Pair> p = new ArrayList<Pair>();
		// System.out.println("Input Starts");
		T = scanner.nextInt();
		for (int i = 0; i < T; i++) {
			N = scanner.nextLong();
			B = scanner.nextLong();
			p.add(new Pair(N, B));
		}
		ArrayList<Long> result = obj.calc(p);
		// System.out.println("Output Starts");
		for (Long s : result) {
			System.out.println(s);
		}

	}

}
