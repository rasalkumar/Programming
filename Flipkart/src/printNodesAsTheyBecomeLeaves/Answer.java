package printNodesAsTheyBecomeLeaves;
import java.util.*;
public class Answer {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		printLeafNodes();
		
	}
	static void printLeafNodes()
	{
		TreeNode root = new TreeNode(100);
		root.left = new TreeNode(50);
		root.right = new TreeNode(150);
		root.left.left = new TreeNode(25);
		helper(root);
		inOrder(root);
	}
	public static void inOrder(TreeNode root)
	{
		if(root == null) return;
		inOrder(root.left);
		if(root.height <= 2)
			System.out.print(root.val  + " ");
		inOrder(root.right);
	}
	public static TreeNode helper(TreeNode root)
	{
		if(root.left == null && root.right == null)
		{
			root.height = 1;
			return root;
		}
		else if( root.left != null && root.right == null )
		{
			root.height = 1 + helper(root.left).val;
			return root;
		}
		else if( root.right != null && root.left == null )
		{
			root.height = 1 + helper(root.right).val;
			return root;
		}
		else
		{
			root.height = 1 + Math.max(helper(root.right).val, helper(root.right).val);
			return root;
		}
	}
	static class TreeNode
	{
		int val;
		int height;
		TreeNode left,right;
		TreeNode(int val)
		{
			this.val = val;
			left = right = null;
		}
	}
}
