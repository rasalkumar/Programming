package twoSumBst;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

	}

	static Stack<TreeNode> stack1;
	static Stack<TreeNode> stack2;

	public static int twoSumBST(TreeNode root, int target) {
		if (root == null) {
			return 0;
		}
		stack1 = new Stack<TreeNode>();
		stack2 = new Stack<TreeNode>();
		TreeNode A = root;
		TreeNode B = root;
		while (A != null) {
			stack1.push(A);
			A = A.left;
		}
		while (B != null) {
			stack2.push(B);
			B = B.right;
		}
		while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() != stack2.peek()) {
			if (stack1.peek().val + stack2.peek().val == target) {
				return 1;
			}
			if ((stack1.peek().val + stack2.peek().val) < target) {
				TreeNode node = stack1.pop();
				if (node.right != null) {
					node = node.right;
					while (node != null) {
						stack1.push(node);
						node = node.left;
					}
				}
			} else {
				TreeNode node = stack2.pop();
				if (node.left != null) {
					node = node.left;
					while (node != null) {
						stack2.push(node);
						node = node.right;
					}
				}

			}
		}
		return 0;
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
