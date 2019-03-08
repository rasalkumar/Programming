package nextGreaterNumberBst;

import java.util.Stack;

public class Solution {
	public TreeNode getSuccessor(TreeNode A, int B) {
	    
	    Stack<TreeNode> stack = new Stack<>();
	    TreeNode node = A;
	        
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        
        boolean status = false;
	    
	    while (!stack.isEmpty()) {
	        
	        node = stack.pop();
	        
	        if (status)
	            return node;
	        
	        if (node.val == B) {
	            status = true;
	        }
	        
	        node = node.right;
	     
	        while (node != null) {
                stack.push(node);
                node = node.left;
            }   
	        
	    }
	    
	    return null;
	    
	}

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

