package binaryTreeFromInOrderAndPreOrderTraversal;

import java.util.ArrayList;

public class Solution {
	static int pIndex = 0;
	public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> preorder) {
	    int len = inorder.size();
	    pIndex = 0;
	    return createTree(0, len-1, inorder, preorder);
	}
	
	public TreeNode createTree(int start, int end, ArrayList<Integer> inorder, ArrayList<Integer> preorder){
	    
	    if(start > end)
	        return null;
	        
	    TreeNode node = new TreeNode(preorder.get(pIndex++));
	    
	    //pIndex--;
	    if(start == end)
	        return node;
	    
	    int inIndex = search(node.val, inorder, start, end);
	   
	    
	    node.left = createTree(start, inIndex-1, inorder, preorder);
	    node.right = createTree(inIndex+1, end, inorder, preorder);
	    return node;
	}
	
	public int search(int num, ArrayList<Integer> inorder, int start, int end){
	    int i;
	    for(i = start; i<= end; i++){
	        if(inorder.get(i) == num)
	            return i;
	    }
	    return i;
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