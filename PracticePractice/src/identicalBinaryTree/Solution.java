package identicalBinaryTree;
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
	public static int identicalTrees(TreeNode p ,TreeNode q)
	{
		if( p == null && q == null )
			return 1;
		if( p == null || q == null )
			return 0;
		return helper(p,q);
	} 
	public static int helper(TreeNode p ,TreeNode q)
	{
		if( p == null && q == null )
		{
			return 1;
		}
		if( p == null || q == null )
		{
			return 0;
		}
		if( p.val == q.val )
		{
			int left = helper(p.left, q.left);
			int right = helper(p.right, q.right);
			if(left == 1 && right == 1)
				return 1;
			else
				return 0;
		}
		else
			return 0;
		
	}
	static class TreeNode
	{
		TreeNode left,right;
		int val;
		TreeNode(int val)
		{
			this.val = val;
		}
	}

}
