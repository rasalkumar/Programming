package bstIterator;

import java.util.Stack;


public class Solution {
    Stack<TreeNode> stack;
    public Solution(TreeNode root) {
    	stack=new Stack<TreeNode>();
    	while(root!=null)
    	{
    		stack.push(root);
    		root=root.left;
    	}
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node=stack.pop();
        int result=node.val;
        if(node.right!=null)
        {
        	node=node.right;
        	while(node!=null)
        	{
        		stack.push(node);
        		node=node.left;
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
