package morrisTraversal;

import java.util.*;

public class InorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in  = new Scanner(System.in);
		TreeNode root  = new TreeNode(5);
		
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		
		root.right = new TreeNode(10);
		root.right.left =new TreeNode(8);
		root.right.right = new TreeNode(12);
		
		 morrisInorder(root);
		
	}
	public static void morrisInorder(TreeNode root)
	{
		TreeNode curr = root;
		while( curr != null )
		{
			if( curr.left == null )
			{
				System.out.print(curr.val + " ");
				curr = curr.right;
			}
			else
			{
				TreeNode pre = curr.left;
				while(pre.right != null && pre.right != curr )
				{
					pre = pre.right;
				}
				if(pre.right == curr)
				{
					System.out.print(curr.val+" ");
					pre.right = null;
					curr = curr.right ;
				}
				else
				{
					pre.right = curr ;
					//System.out.print(curr.val+" ");
					curr = curr.left;
				}
			}
		}
	}
	static class TreeNode
	{
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int val)
		{
			this.val = val;
		}
	}

}
