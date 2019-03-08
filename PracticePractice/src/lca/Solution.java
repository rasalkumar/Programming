package lca;

import java.util.*;

public class Solution {
	static ArrayList<Integer> path1 = new ArrayList<>();
	static ArrayList<Integer> path2 = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		path1.clear();
		path2.clear();
		System.out.println(path(root,5 , 15));
	}
	public static int path(TreeNode root, int target1, int target2) {
		if ( root == null ) {
			return 0;
		}
		if( !findPath(root, target1, path1) || !findPath(root, target2, path2) )
		{
			System.out.println("**");
			return -1;
		}
		 int ans = -1 ; 
		for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) 
		{ 
			if (path1.get(i) != path2.get(i)) {
				ans = path1.get(i - 1);
				break;
			}
		}
		System.out.println(path1);
		System.out.println(path2);
		return ans;
	}

	public static boolean findPath(TreeNode root, int target, ArrayList<Integer> path) {
		if (root == null) {
			return false;
		}
		path.add(root.val);
		if (root.val == target) {
			return true;
		}
		if (root.left != null && findPath(root.left, target, path)) {
			return true;
		}
		if (root.right != null && findPath(root.right, target, path)) {
			return true;
		}
		path.remove(path.size() - 1);
		return false;
	}

	static class TreeNode {
		TreeNode left, right;
		int val;

		TreeNode(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}

}
