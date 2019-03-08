package postOrderTraversal;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {

	public ArrayList<Integer> postorderTraversal(TreeNode a) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(a == null)
            return result;
        TreeNode node = a;
        while(!stack.isEmpty() || node != null){
            while(node != null){
                if(node.right != null)
                    stack.push(node.right);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            
            if(node.right != null && !stack.isEmpty() && node.right == stack.peek()){
                TreeNode rightNode = stack.pop();
                stack.push(node);
                node = rightNode;
            }
            else{
                result.add(node.val);
                node = null;
            }
        }
        return result;
	}
	 void recursivePostOrderTraversal(TreeNode node)
	{
		if (node==null)
		{
			return;
		}
		recursivePostOrderTraversal(node.left);
		recursivePostOrderTraversal(node.right);
		System.out.println(node.val);
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
		
		
		ArrayList<Integer> result= new ArrayList<>();
		result=obj.postorderTraversal(n4);
		
		
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