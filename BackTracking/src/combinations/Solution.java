package combinations;

import java.util.ArrayList;

public class Solution {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (n <= 0 || n < k)
			return result;

		ArrayList<Integer> item = new ArrayList<Integer>();
		dfs(n, k, 1, item, result); // because it need to begin from 1

		return result;
	}

	private void dfs(int n, int k, int start, ArrayList<Integer> item,
			ArrayList<ArrayList<Integer>> res) {
		if (item.size() == k) {
			res.add(new ArrayList<Integer>(item));
			return;
		}

		for (int i = start; i <= n; i++) {
			item.add(i);
			dfs(n, k, i + 1, item, res);
			item.remove(item.size() - 1);
		}
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		int n = 4;
		int k = 2;
		ArrayList<ArrayList<Integer>> result = obj.combine(n, k);
		for (ArrayList<Integer> list : result)
			System.out.println(list);
	}

}
