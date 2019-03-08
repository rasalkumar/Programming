package flattenBinaryTreeToLinkList;

import java.util.Stack;

public class Solution {

	public TreeNode flatten(TreeNode a)
	{
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode node=a;
		while(node!=null || !stack.isEmpty())
		{
			if(node.right!=null)
			{
				stack.push(node.right);
			}
			if(node.left!=null)
			{
				node.right=node.left;
				node.left=null;
			}else if(!stack.isEmpty())
			{
				TreeNode temp=stack.pop();
				node.right=temp;
			}
			node=node.right;
		}
		return a;
	}
	
	public static void main(String args[])
	{
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n2 = new TreeNode(2);
		TreeNode n1 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		
		n4.right= n5;
		n4.left = n2;
		n2.left = n1;
		n2.right = n3;
		
		Solution obj = new Solution();
		TreeNode p=obj.flatten(n4);
		while(p!=null)
		{
			System.out.println(p.val);
			p=p.right;
		}
		
	}
	
}
 class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	  }
	 