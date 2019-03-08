package bstIterator;

import java.util.*;

public class Solution
{
	public static void main(String args[]){
	
	TreeNode root = new TreeNode(5);

	root.left=new TreeNode(3);
	root.left.left=new TreeNode(2);
	root.left.right=new TreeNode(4);

	root.right=new TreeNode(10);
	root.right.left=new TreeNode(8);
	root.right.right=new TreeNode(12);

	BSTIterator itr = new BSTIterator(root);
	while(itr.hasNext())
	{
		System.out.println(itr.next());
	}

	}
	
	static class BSTIterator
	{
		Stack<TreeNode> stack;
		public BSTIterator(TreeNode root) {
			stack = new Stack<>();
			while(root != null)
			{
				stack.add(root);
				root = root.left;
			}
	    }
		public boolean hasNext()
		{
			return !stack.isEmpty();
		}
		public int next()
		{
			TreeNode node = stack.pop();
			int result = node.val;
			if( node.right != null )
			{
				node = node.right;
				while(node != null )
				{
					stack.push(node);
					node = node.left;
				}
			}
			return result;
		}
		
	}

static class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}
}

}
