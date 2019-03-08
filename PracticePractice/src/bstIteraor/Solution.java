package bstIteraor;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {

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

	static class BstIterator {
		Stack<TreeNode> stack;

		BstIterator(TreeNode root) {
			stack = new Stack<TreeNode>();
			while (root != null) {
				stack.push(root);
				root = root.left;
			}

		}

		public boolean hasNext() {
			return !stack.isEmpty();
		}

		public int next() {
			TreeNode node = stack.pop();
			int result = node.val;
			if (node.right != null) {
				node = node.right;
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
			return result;
		}
	}

}
