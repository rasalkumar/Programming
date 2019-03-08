package vrticalOrder;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		Queue<Wrapper> q = new LinkedList<>();
		q.add(new Wrapper(root, 0));
		map.put(0, new ArrayList<>(root.val));
		while (!q.isEmpty()) {
			Wrapper curr = q.poll();
			if (map.containsKey(curr.level)) {
				map.get(curr.level).add(curr.t.val);
			} else {
				ArrayList<Integer> arr = new ArrayList<>();
				arr.add(curr.t.val);
				map.put(curr.level, arr);
			}
			if (curr.t.left != null) {
				q.add(new Wrapper(curr.t.left, curr.level - 1));
			}
			if (curr.t.right != null) {
				q.add(new Wrapper(curr.t.right, curr.level + 1));
			}

		}
		for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			res.add(entry.getValue());
		}
		return res;
	}

	static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}

	static class Wrapper {
		TreeNode t;
		int level;

		Wrapper(TreeNode t, int level) {
			this.level = level;
			this.t = t;
		}
	}
}
