package symmetricTree;



public class Solution {
	public int isSymmetric(TreeNode root) {
		if (root == null)
			return 1;
		int x;
		if(isSymmetric(root.left, root.right))
		{
			x=1;
		}else
		{
			x=0;
		}
		return x;
	}
	 
	public boolean isSymmetric(TreeNode l, TreeNode r) {
		if (l == null && r == null) {
			return true;
		} else if (r == null || l == null) {
			return false;
		}
	 
		if (l.val != r.val)
			return false;
	 
		if (!isSymmetric(l.left, r.right))
			return false;
		if (!isSymmetric(l.right, r.left))
			return false;
	 
		return true;
	}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }