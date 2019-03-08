package identicalBinaryTrees;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root1 = new TreeNode(5);
		
		root1.left = new TreeNode(3);
		root1.left.left = new TreeNode(2);
		root1.left.right = new TreeNode(4);
		
		root1.right = new TreeNode(10);
		root1.right.left =new TreeNode(8);
		root1.right.right = new TreeNode(12);
		
		TreeNode root2 = new TreeNode(5);
		
		root2.left = new TreeNode(3);
		root2.left.left = new TreeNode(2);
		root2.left.right = new TreeNode(4);
		
		root2.right = new TreeNode(10);
		root2.right.left =new TreeNode(8);
		root2.right.right = new TreeNode(12);
		
		System.out.println(isIdentical(root1, root2));
		
	}
	public static boolean isIdentical(TreeNode root1 ,TreeNode root2)
	{
		if(root1 == null && root2 == null)
		{
			return true;
		}
		if(root1 == null || root2 == null)
		{
			return false;
		}
		if(root1.val != root2.val)
		{
			return false;
		}
		return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
	}
	static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val)
		{
			this.val = val ;
		}
	}
}
