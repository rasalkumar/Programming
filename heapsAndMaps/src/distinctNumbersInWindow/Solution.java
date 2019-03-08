package distinctNumbersInWindow;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<>();
		int[] A = { 1, 2, 1, 3, 4, 2, 3 };
		for (int i = 0; i < A.length; i++) {
			a.add(A[i]);
		}
		int k = 4;
		Solution obj = new Solution();
		System.out.println(obj.distinct(a, k));

	}

	public ArrayList<Integer> distinct(ArrayList<Integer> a, int k) {

		ArrayList<Integer> ans = new ArrayList<>();
		if (k <= 0 || k > a.size()) {
			return ans;
		}
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

		int dist_count = 0;

		for (int i = 0; i < k; i++) {
			if (hM.get(a.get(i)) == null) {
				hM.put(a.get(i), 1);
				dist_count++;
			} else {
				int count = hM.get(a.get(i));
				hM.put(a.get(i), count + 1);
			}
		}
		ans.add(dist_count);

		for (int i = k; i < a.size(); i++) {

			// Remove first element of previous window
			// If there was only one occurrence, then
			// reduce distinct count.
			if (hM.get(a.get(i - k)) == 1) {
				hM.remove(a.get(i - k));
				dist_count--;
			} else // reduce count of the removed element
			{
				int count = hM.get(a.get(i - k));
				hM.put(a.get(i - k), count - 1);
			}

			// Add new element of current window
			// If this element appears first time,
			// increment distinct element count
			if (hM.get(a.get(i)) == null) {
				hM.put(a.get(i), 1);
				dist_count++;
			} else // Increment distinct element count
			{
				int count = hM.get(a.get(i));
				hM.put(a.get(i), count + 1);
			}

			// Print count of current window
			ans.add(dist_count);
		}
		return ans;
	}
}
