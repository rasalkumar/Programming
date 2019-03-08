package lowestCommonAncestor;

import java.util.*;

public class Solution {

	
	private List<Integer> path1 = new ArrayList<>();
	private List<Integer> path2 = new ArrayList<>();

	public int lca(TreeNode a, int n1, int n2) {
		TreeNode root = a;
		path1.clear();
		path2.clear();
		return findLCAInternal(root, n1, n2);
	}

	private int findLCAInternal(TreeNode root, int n1, int n2) {

		if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
//			System.out.println((path1.size() > 0) ? "n1 is present"
//					: "n1 is missing");
//			System.out.println((path2.size() > 0) ? "n2 is present"
//					: "n2 is missing");
			return -1;
		}

		int i;
		for (i = 0; i < path1.size() && i < path2.size(); i++) {
			// System.out.println(path1.get(i) + " " + path2.get(i));
			if (!path1.get(i).equals(path2.get(i)))
				break;
		}

		return path1.get(i - 1);
	}

	private boolean findPath(TreeNode root, int n, List<Integer> path) {
		if (root == null) {
			return false;
		}

		path.add(root.val);

		if (root.val == n) {
			return true;
		}

		if (root.left != null && findPath(root.left, n, path)) {
			return true;
		}

		if (root.right != null && findPath(root.right, n, path)) {
			return true;
		}

		path.remove(path.size() - 1);

		return false;
	}

	public static void main(String args[]) {
		TreeNode n0 = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);

		n3.left = n5;
		n3.right = n1;
		n5.left = n6;
		n5.right = n2;
		n2.left = n7;
		n2.right = n4;
		n1.left = n0;
		n1.right = n8;

		Solution obj = new Solution();
		int ans = obj.lca(n3, 5, 4);
		System.out.println(ans);

	}
}

class TreeNode {
	int val;
	TreeNode left, right;

	public TreeNode(int item) {
		val = item;
		left = right = null;
	}
}