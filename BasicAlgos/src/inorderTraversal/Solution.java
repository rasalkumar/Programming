package inorderTraversal;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ArrayList<Integer> inorder(TreeNode a)
	{
		TreeNode root = a; 
		ArrayList<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if( a == null )
		{
			return result;
		}
		while(stack.size()!=0 || root != null )
		{
			if(root.left != null)
			{
				stack.add(root);
				root = root.left;
			}
			else
			{
				root = stack.pop();
				result.add(root.val);
				root = root.right;
			}
		} 
		return null;
	}
	class TreeNode
	{
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int x)
		{
			val = x;
		}
	}

}
