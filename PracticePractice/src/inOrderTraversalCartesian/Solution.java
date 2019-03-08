package inOrderTraversalCartesian;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {

		}
	}

	public static TreeNode buildTree(ArrayList<Integer> a) {
		if (a == null || a.size() == 0) {
			return null;
		}
		TreeNode root = inOrder(a, 0, a.size() - 1);
		return root;
	}

	public static TreeNode inOrder(ArrayList<Integer> a, int start, int end) {
		if (start > end) {
			return null;
		}
		int maxIndex = 0;
		int max = Integer.MIN_VALUE;
		for (int i = start; i <= end; i++) {
			if (a.get(i) >= maxIndex) {
				maxIndex = i;
				max = a.get(i);
			}
		}
		TreeNode root = new TreeNode(max);

		root.left = inOrder(a, start, maxIndex - 1);
		root.right = inOrder(a, maxIndex + 1, end);

		return root;
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
