package p148;
import java.util.*;
public class InvertBinaryTree {

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
		
		TreeNode ans = invert(root);
		
		System.out.println(root.val);
		
		System.out.println(root.left.val);
		System.out.println(root.right.val);
		
		System.out.println(root.left.left.val);
		System.out.println(root.left.right.val);
		
		System.out.println(root.right.left.val);
		System.out.println(root.right.right.val);
	}
	public static TreeNode invert(TreeNode root)
	{
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		if(root.left != null)
		{
			invert(root.left);
		}
		if(root.right != null )
		{
			invert(root.right);
		}
		return root;
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
