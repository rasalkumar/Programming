package maxDepthOfABinaryTree;

import java.util.ArrayList;

public class Solution {

	private int maxDepth(TreeNode a) {
		// TODO Auto-generated method stub
		if(a==null)
		{
			return 0;
		}
		
		return Math.max(maxDepth(a.left)+1, maxDepth(a.right)+1);
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

		int ans;
		ans = obj.maxDepth(n4);

		System.out.println(ans);

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