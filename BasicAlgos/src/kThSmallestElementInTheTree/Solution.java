package kThSmallestElementInTheTree;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		TreeNode root = new TreeNode(5);

		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);

		root.right = new TreeNode(10);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(12);

		System.out.println(kSmall(root, k));

	}

	public static int kSmall(TreeNode node, int k) {
		ArrayList<Integer> inorder = morrisInorder(node);
		System.out.println(inorder);
		if (k < inorder.size()) {
			return inorder.get(--k);
		} else {
			return -1;
		}

	}

	public static ArrayList<Integer> morrisInorder(TreeNode root) {
		ArrayList<Integer> inorder = new ArrayList<>();
		TreeNode curr = root;
		while (curr != null) {
			if (curr.left == null) {
				inorder.add(curr.val);
				curr = curr.right;
			} else {
				TreeNode pre = curr.left;
				while (pre.right != null && pre.right != curr) {
					pre = pre.right;
				}
				if (pre.right == curr) {
					inorder.add(curr.val);
					pre.right = null;
					curr = curr.right;
				} else {
					pre.right = curr;
					curr = curr.left;
				}
			}
		}
		return inorder;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}
}
