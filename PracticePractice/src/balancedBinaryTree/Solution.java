package balancedBinaryTree;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			TreeNode root = new TreeNode(5);
			if(heightBalanced(root)== -1)
			{
				System.out.println("Not height balanced");
			}
			else
			{
				System.out.println("Height balanced");
			}
		}
	}
	public static int heightBalanced(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		int left = heightBalanced(root.left);
		int right = heightBalanced(root.right);
		if(left == -1 || right == -1)
		{
			return -1;
		}
		if(Math.abs(left - right) > 1)
		{
			return -1;
		}
		return Math.max(left, right) + 1;
	}
	static class TreeNode
	{
		TreeNode left,right;
		int val;
		TreeNode(int val)
		{
			this.val = val;
			left= null;
			right = null;
		}
	}

}
