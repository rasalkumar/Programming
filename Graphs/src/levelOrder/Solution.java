package levelOrder;

import java.util.*;

// Definition for binary tree
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		if (a == null)
			return result;

		int currentLevelNum = 1;
		int nextLevelNum = 0;
		queue.offer(a);
		ArrayList<Integer> levelList = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			currentLevelNum--;
			levelList.add(node.val);

			if (node.left != null) {
				queue.offer(node.left);
				nextLevelNum++;
			}

			if (node.right != null) {
				queue.offer(node.right);
				nextLevelNum++;
			}

			if (currentLevelNum == 0) {
				currentLevelNum = nextLevelNum;
				nextLevelNum = 0;
				result.add(new ArrayList<Integer>(levelList));
				levelList.clear();
			}

		}

		return result;

	}
}
