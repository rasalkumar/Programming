package invertBinaryTree;






public class Solution {
	
	 public TreeNode invertTree(TreeNode root) {
		 if(root!=null)
		 {
			 helper(root);
		 }
		 return root;
	    }

	private void helper(TreeNode p) {
		// TODO Auto-generated method stub
		TreeNode temp = p.left;
		p.left=p.right;
		p.right=temp;
		if(p.left!=null)
		{
			helper(p.left);
		}
		if(p.right!=null)
		{
			helper(p.right);
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
		
		
		TreeNode result;
		result=obj.invertTree(n4);
		
		
		
	}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
