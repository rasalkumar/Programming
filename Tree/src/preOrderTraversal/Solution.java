package preOrderTraversal;

import java.util.*;




public class Solution {
	public ArrayList<Integer> preorderTraversal(TreeNode a) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(a == null)
            return result;
        stack.push(a);
        while(!stack.isEmpty()){
            TreeNode popped = stack.pop();
            result.add(popped.val);
            if(popped.right != null)
                stack.push(popped.right);
            if(popped.left != null)
                stack.push(popped.left);
        }
        return result;
	}
	
	void recursivePreOrderTraversal(TreeNode node)
	{
		if(node==null)
		{
			return;
		}
		System.out.println(node.val);
		recursivePreOrderTraversal(node.left);
		
		recursivePreOrderTraversal(node.right);
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
		obj.recursivePreOrderTraversal(n4);
		
		ArrayList<Integer> result= new ArrayList<>();
		result=obj.preorderTraversal(n4);
		
		
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
