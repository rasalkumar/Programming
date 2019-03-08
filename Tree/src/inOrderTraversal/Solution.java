package inOrderTraversal;

import java.util.ArrayList;
import java.util.Stack;



public class Solution {

	
	public ArrayList<Integer> inorderTraversal(TreeNode a) {
	    ArrayList<Integer> result=new ArrayList<Integer>();
    	Stack<TreeNode> stack=new Stack<TreeNode>();
    	if(a==null)
    	{
    		return result;
    	}
    	TreeNode node = a;
    	while(!stack.isEmpty() || node!=null)
    	{
    		if(node!=null)
    		{
    			stack.push(node);
    			node=node.left;
    		}
    		else
    		{
    			node=stack.pop();
    			result.add(node.val);
    			node=node.right;
    		}
    	}
    	return result;
	}
	private void recursiveInOrderTraversal(TreeNode node) {
		// TODO Auto-generated method stub
		if(node==null)
		{
			return;
		}
		recursiveInOrderTraversal(node.left);
		System.out.println(node.val);
		recursiveInOrderTraversal(node.right);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		obj.recursiveInOrderTraversal(n4);
		
		ArrayList<Integer> result= new ArrayList<>();
		result=obj.inorderTraversal(n4);
		
		
		for(int i=0;i<result.size();i++)
		{
			System.out.println("....."+result.get(i));
		}
	}
	

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}