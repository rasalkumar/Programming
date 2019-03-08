package maxProdSubArray;

import java.util.*;

public class Solution {

	private static ArrayList<Integer> leftSpecialV(ArrayList<Integer> A) {

		ArrayList<Integer> r = new ArrayList<>();
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < A.size(); i++) {
			while (!s.empty() && A.get(s.peek()) <= A.get(i)) {
				s.pop();
			}

			if (s.empty()) {
				r.add(0);
			} else {
				r.add(s.peek());
			}
			s.push(i);
		}

		return r;
	}

	private static ArrayList<Integer> rightSpecialV(ArrayList<Integer> A) {

		ArrayList<Integer> r = new ArrayList<>();
		Stack<Integer> s = new Stack<>();
		for (int i = A.size() - 1; i >= 0; i--) {
			while (!s.empty() && A.get(s.peek()) <= A.get(i)) {
				s.pop();
			}

			if (s.empty()) {
				r.add(0, 0);
			} else {
				r.add(0, s.peek());
			}
			s.push(i);
		}

		return r;
	}

	public static int maxSpecialProduct(ArrayList<Integer> A) {
		ArrayList<Integer> l = leftSpecialV(A);
		ArrayList<Integer> r = rightSpecialV(A);

		long product = 0, res = 0;

		for (int i = 0; i < A.size(); i++) {
			res = (long) l.get(i) * (long) r.get(i);
			if (product < res) {
				product = res;
			}
		}

		return (int) (product % 1000000007);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<>();
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			a.add(in.nextInt());
		}
		System.out.println(maxSpecialProduct(a));
	}

}
