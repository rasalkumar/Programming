package symmertricBinaryTree;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {

		}
	}

	public static int isSymmetric(TreeNode root) {
		if (root == null) {
			return 1;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		if (root.left == null || root.right == null) {
			return 0;
		}
		if (isSymmetric(root.left, root.right) == 1) {
			return 1;
		} else {
			return 0;
		}
	}

	public static int isSymmetric(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return 1;
		}
		if (p == null || q == null) {
			return 0;
		}
		if (p.val == q.val) {
			int left = isSymmetric(p.left, q.right);
			int right = isSymmetric(p.right, q.left);
			if (left == 1 && right == 1) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	static class TreeNode {
		TreeNode left, right;
		int val;

		TreeNode(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}

}
