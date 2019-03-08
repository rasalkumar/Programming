package validBinarySearchTree;

public class Solution {
	
	    public int isValidBST(TreeNode A )
	    {
    	boolean flag=isBSTUtil(A, Integer.MIN_VALUE,Integer.MAX_VALUE);
    	if(flag==true)
    	{
    		return 1;
    	}
        return 0;
    }
 
    
     boolean isBSTUtil(TreeNode node, int min, int max)
    {
          if (node == null)
            return true;
               
        if (node.value < min || node.value > max)
            return false;
            
        return (isBSTUtil(node.left, min, node.value-1) && isBSTUtil(node.right, node.value+1, max));
    }
 
    
	
}

class TreeNode
{
    int value;
    TreeNode left, right;
 
    public TreeNode(int item)
    {
        value = item;
        left = right = null;
    }
}