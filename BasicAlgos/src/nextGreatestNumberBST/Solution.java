package nextGreatestNumberBST;
import java.util.*;
public class Solution {
	static ArrayList<Integer> inorder = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		
		root.right = new TreeNode(10);
		root.right.left =new TreeNode(8);
		root.right.right = new TreeNode(12);
		
		int b = in.nextInt();
		inorder(root);
		int x = Collections.binarySearch(inorder, b);
		if(x == inorder.size()-1)
		{
			System.out.println("Largest element");
		}else{
		while(inorder.get(x)==b)
		{
			x++;
		}
		System.out.println(inorder.get(x));}
//		TreeMap<Integer,Integer> tmap = new TreeMap<>();
//		for( int i = 0 ; i < inorder.size() ; i++ )
//		{
//			if(!tmap.containsKey(inorder.get(i)))
//			{
//				tmap.put(inorder.get(i), 1);
//			}
//			else
//			{
//				tmap.put(inorder.get(i), tmap.get(inorder.get(i))+1);
//			}
//		}
//		System.out.println(tmap.ceilingEntry(b).getKey());
	}
	public static void inorder(TreeNode root)
	{
		if(root == null)
		{
			return;
		}
		inorder(root.left);
		inorder.add(root.val);
		inorder(root.right);
	}
	static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val)
		{
			this.val = val ;
		}
	}
}
