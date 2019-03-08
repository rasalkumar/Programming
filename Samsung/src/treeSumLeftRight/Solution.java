package treeSumLeftRight;
/*
 * Given a Binary Tree where each node has positive and negative values. 
 * Convert this to a tree where each node contains the sum of the left and 
 * right sub trees in the original tree. The values of leaf nodes are changed to 0.
 */
import java.util.Scanner;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		inOrder(root);
		System.out.println();
		sum(root);
		inOrder(root);
	}
	public static void inOrder(TreeNode root)
	{
		if(root == null)
			return ;
		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}
	public static int sum(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		int oldVal = root.val;
		root.val = sum(root.left) + sum(root.right);
		return root.val + oldVal;
	}
	static class TreeNode
	{
		int val;
		TreeNode left,right;
		TreeNode(int data)
		{
			val = data;
			left=right=null;
		}
	}

}
