package absDifference;
import java.util.*;
public class Solution {
	public int solve(ArrayList<Integer> A, ArrayList<Integer> B,
			ArrayList<Integer> C) {

		int i = A.size() - 1;
		int j = B.size() - 1;
		int k = C.size() - 1;
		int a, b, c, absmin, counter;
		counter = 0;
		absmin = Math.abs(max(i, j, k) - min(i, j, k));
		ArrayList<Integer> e = new ArrayList<Integer>();
		while (i >= 0 && j >= 0 && k >= 0) {
			a = A.get(i);
			b = B.get(j);
			c = C.get(k);

			int d = Math.abs(max(a, b, c) - min(a, b, c));
			e.add(d);
			if (d < absmin) {
				absmin = d;
			}
			int f = max(a, b, c);
			if (f == a) {
				i--;
			}
			if (f == b) {
				j--;
			}
			if (f == k) {
				k--;
			}

		}
		for (int p = 0; p < e.size(); p++) {
			if (e.get(p) == absmin) {
				counter = counter + 1;
			}
		}
		return counter;

	}

	private int max(int a, int b, int c) {
		// TODO Auto-generated method stub
		int max = a;
		int[] array = { a, b, c };
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	private int min(int a, int b, int c) {
		// TODO Auto-generated method stub
		int min = a;
		int[] array = { a, b, c };
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;

	}
//	public static void main(String args[])
//	{
//		ArrayList<Integer>
//	}
}