package minDepthOfABinaryTree;





public class Solution {
	public int minDepth(TreeNode a) {
	     if(a == null)
	     return 0;
	     if(a.left == null)
	         return minDepth(a.right) + 1;
	     if(a.right == null)
	         return minDepth(a.left) + 1;
	     return Math.min(minDepth(a.right) + 1, minDepth(a.left) + 1);
	     
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
		ans = obj.minDepth(n4);

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