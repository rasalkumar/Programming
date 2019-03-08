package kTHSmallestElementInBST;
import java.util.*;

public class Solution {
	public int kthSmallest(TreeNode root,int k)
	{
		Stack<TreeNode> stack= new Stack<>();
		TreeNode p=root;
		int result=0;
		while(!stack.isEmpty()||p!=null)
		{
			if(p!=null)
			{
				stack.push(p);
				p=p.left;
			}
			else
			{
				TreeNode t=stack.pop();
				k--;
				if(k==0)
				{
					result=t.val;
					break;
				}
				p=t.right;
			}
		}
		return result;
	}

}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}