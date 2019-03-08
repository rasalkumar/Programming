package invertTree;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			
		}
	}
	public static TreeNode invert(TreeNode root)
	{
		if(root != null)
			helper(root);
		return root;
	} 
	public static void helper(TreeNode root)
	{
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		if(root.left != null)
			helper(root.left);
		if(root.right != null)
			helper(root.right);
	
	}
	static class TreeNode
	{
		TreeNode left,right;
		int val;
		TreeNode(int val)
		{
			this.val = val;
			left = null;
			right = null;
		}
	}

}
