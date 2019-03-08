package sortedArrayToBST;

import java.util.*;

public class Solution {

	public TreeNode sortedArrayToBST(final List<Integer> a) {
		if (a.size() == 0) {
			return null;
		}
		return sortedArrayToBST(a, 0, a.size() - 1);
	}

	private TreeNode sortedArrayToBST(List<Integer> a, int start, int end) {

		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(a.get(mid));
		root.left = sortedArrayToBST(a, start, mid - 1);
		root.right = sortedArrayToBST(a, mid + 1, end);
		return root;
	}

	public static void main(String args[]) {
		List<Integer> x = new ArrayList<Integer>();
		x.add(1);
		x.add(2);
		x.add(3);
		x.add(4);
		x.add(5);
		Solution obj = new Solution();
		TreeNode ans = obj.sortedArrayToBST(x);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result = obj.inorderTraversal(ans);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

	}

	public ArrayList<Integer> inorderTraversal(TreeNode a) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (a == null) {
			return result;
		}
		TreeNode node = a;
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				result.add(node.val);
				node = node.right;
			}
		}
		return result;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}