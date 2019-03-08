package twoSumBinaryTree;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int k = in.nextInt();
		TreeNode root = new TreeNode(5);

		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);

		root.right = new TreeNode(10);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(12);
		
		System.out.print(twoSumBST(root,k));

		
	}
	public static boolean twoSumBST(TreeNode root, int k)
	{
		ArrayList<Integer>	inorder = morrisInorder(root);
		System.out.println(inorder);
		int i = 0 ;
		int j = inorder.size()-1;
		while(i<j)
		{
			if(inorder.get(i)+inorder.get(j)<k)
			{
				i++;
			}
			if(inorder.get(i)+inorder.get(j)>k)
			{
				j--;
			}
			if(inorder.get(i)+inorder.get(j) == k)
			{
				return true;
			}
		}
		return false;
	} 
	public static ArrayList<Integer> morrisInorder( TreeNode root)
	{
		ArrayList<Integer> inorder = new ArrayList<>();
		TreeNode curr = root;
		while(curr != null)
		{
			if(curr.left == null)
			{
				inorder.add(curr.val);
				curr = curr.right;
			}
			else
			{
				TreeNode pre = curr.left;
				while( pre.right != null && pre.right != curr )
				{
					pre = pre.right;
				}
				if( pre.right == curr )
				{
					inorder.add(curr.val);
					pre.right = null;
					curr = curr.right;
				}
				else
				{
					pre.right = curr ;
					curr = curr.left ;
				}
			}
		}
		return inorder;
	}
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

}
