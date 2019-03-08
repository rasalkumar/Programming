package identicalBinaryTrees;

import java.util.ArrayList;


public class Solution {

	public int isSameTree(TreeNode p, TreeNode q) {
		     if(p==null && q==null){
	        return 1;
	    }else if(p==null || q==null){
	        return 0;
	    }
	 
	    if(p.val==q.val){
	        int i=isSameTree(p.left, q.left);
	        int j=isSameTree(p.right, q.right);
	        if(i==1 && j==1){
	            return 1;
	        }
	        else
	        {
	            return 0;
	        }
	    }else{
	        return 0;
	    }
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
		
		int result=obj.isSameTree(n4,n4);
		System.out.print(result);
				
	}	
		
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }