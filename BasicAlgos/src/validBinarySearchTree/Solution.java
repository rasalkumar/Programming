package validBinarySearchTree;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		
		root.right = new TreeNode(10);
		root.right.left =new TreeNode(8);
		root.right.right = new TreeNode(12);
		
		System.out.println(isValidBST(root));
		

	}
	public static boolean isValidBST(TreeNode root)
	{
		if(root == null)
		{
			return false;
		}
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public static boolean isValidBST(TreeNode node, int min , int max)
	{
		if(node == null)
		{
			return true;
		}
		
		if(node.val > max || node.val < min)
		{
			return false;
		}
		return isValidBST(node.left, min, node.val-1) || isValidBST(node.right, node.val + 1, max );
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
