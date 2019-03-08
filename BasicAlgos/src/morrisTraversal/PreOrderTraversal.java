package morrisTraversal;

import java.util.*;

public class PreOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in  = new Scanner(System.in);
		TreeNode root  = new TreeNode(5);
		
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		
		root.right = new TreeNode(10);
		root.right.left =new TreeNode(8);
		root.right.right = new TreeNode(12);
		
		 morrisPreorder(root);
		
	}
	public static void morrisPreorder(TreeNode root){
        TreeNode cur = root;
        while (cur != null ) {
            if (cur.left == null) {
                System.out.print(cur.val + " " );
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == cur) {
                		//System.out.print(cur.val + " ");
                        pre.right = null;
                        cur = cur.right;
                        } 
                else {
                		System.out.print(cur.val + " ");
                		pre.right = cur;
                        cur = cur.left;
                        
                    }
                }
            }
        }
	static class TreeNode
	{
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int val)
		{
			this.val = val;
		}
	}

}
