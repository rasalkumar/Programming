package morrisTraversal;


import java.util.*;

public class RecoverBinaryTree {
	static TreeNode pre = null;
	static TreeNode first  = null;
	static TreeNode second = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in  = new Scanner(System.in);
		TreeNode root  = new TreeNode(5);
		
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(2);
		
		root.right = new TreeNode(10);
		root.right.left =new TreeNode(8);
		root.right.right = new TreeNode(12);
		
		recover(root);
		System.out.println(first.val);
		System.out.println(second.val);
		
		morrisInorderRecover(root);
		
	}
	public static void recover(TreeNode node)
	{
		if( node == null )
		{
			return;
		}
		else
		{
			recover(node.left);
			if(pre == null)
			{
				pre = node;
			}
			else
			{
				if(pre.val>node.val)
				{
					if( first == null )
					{
						first = pre;
					}
					second = node;
				}
				pre = node ;
			}
			recover(node.right);
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
	public static void morrisInorderRecover(TreeNode root)
	{
		TreeNode curr = root;
		while( curr != null )
		{
			if( curr.left == null )
			{
				//System.out.print(curr.val + " ");
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
					//System.out.print(curr.val+" ");
					pre.right = null;
					if (second == null)
					{
						second = curr;
					} 
					else
					{
						first = second ; 
						second = curr;
					}
					curr = curr.right ;
				}
				else
				{
					pre.right = curr ;
					//System.out.print(curr.val+" ");
					curr = curr.left;
				}
			}
			if(first != null && second != null && first.val > second.val)
			{
				System.out.println(first.val);
				System.out.println(second.val);
				break;
				
			}
		}
	}

}
