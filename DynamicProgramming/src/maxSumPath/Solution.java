package maxSumPath;

//import java.util.*;
public class Solution {

	public int maxPathSum(TreeNode a) {
		int max[] = new int[1];
		max[0] = Integer.MIN_VALUE;
		calculateSum(a, max);

		return max[0];
	}

	public int calculateSum(TreeNode node, int[] max) {
		if (node == null) {
			return 0;
		}
		int left = calculateSum(node.left, max);
		int right = calculateSum(node.right, max);

		int current = Math.max(node.val,
				Math.max(left + node.val, right + node.val));
		max[0] = Math.max(max[0], Math.max(current, left + node.val + right));
		return current;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n2 = new TreeNode(2);
		TreeNode n1 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);

		n4.right = n5;
		n4.left = n2;
		n2.left = n1;
		n2.right = n3;
		Solution obj = new Solution();
		int x = obj.maxPathSum(n4);
		System.out.println(x);
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