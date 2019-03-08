package invertBinaryTree;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		TreeNode root  = new TreeNode(5);
		
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		
		root.right = new TreeNode(10);
		root.right.left =new TreeNode(8);
		root.right.right = new TreeNode(12);
		
		TreeNode x = invertMain(root);
		System.out.println(root.val);
		
		
	}
	public static TreeNode invertMain(TreeNode root)
	{
		if(root != null)
		{
			invert(root);
		}
		return root;
	}
	public static void invert(TreeNode root)
	{
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		if(root.left != null)
		{
			invert(root.left);
		}
		if(root.right != null)
		{
			invert(root.right);
		}
		
	}
	static class TreeNode
	{
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int x)
		{
			val = x ;
		}
	}
}
