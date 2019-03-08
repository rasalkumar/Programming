package symmetricBinaryTree;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		
		root.right = new TreeNode(3);
		root.right.left =new TreeNode(8);
		root.right.right = new TreeNode(4);
		
		System.out.println(isSymmetric(root));
	}
	public static boolean isSymmetric(TreeNode root)
	{
		if(root== null)
		{
			return true;
		}
		return isSymmetrical(root.left,root.right);
	}
	public static boolean isSymmetrical(TreeNode a , TreeNode b)
	{
		if( a == null && b == null )
		{
			return true;
		}
		if( a == null || b == null )
		{
			return false;
		}
		if(a.val != b.val)
		{
			return false;
		}
		return isSymmetrical(a.left, b.right) && isSymmetrical(a.right, b.left); 	
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
