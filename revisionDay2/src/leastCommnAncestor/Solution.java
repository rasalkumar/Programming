package leastCommnAncestor;
import java.util.*;
public class Solution {

	static TreeNode[] tree;
	static int n;
	static ArrayList<Integer> path1;
	static ArrayList<Integer> path2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			n = in.nextInt();
			tree = new TreeNode[n];
			for(int i = 0 ; i < n ; i++ )
			{
				int x = in.nextInt();
				int y = in.nextInt();
				int z = in.nextInt();
				tree[i] = new TreeNode(x);
				tree[i].left = tree[y];
				tree[i].right = tree[z];
			}
			int x = in.nextInt();
			int y = in.nextInt();
			path1 = new ArrayList<>();
			path2 = new ArrayList<>();
			
			int ans = lca(tree[0],x,y);
			System.out.println(ans);
		}
	}
	//For least common ancestor we have to find the path from root to 
	//both the nodes and check which nodes in both the paths coincide first
	//since the path is from the root it will be the deepest path.
	
	static int lca(TreeNode root,int n1,int n2)
	{
		if(!findPath(root,n1,path1) && !findPath(root,n2,path2))
			return -1;
		int i ;
		for( i = 0 ; i < path1.size() && i < path2.size() ; i++)
			if(!path1.get(i).equals(path2.get(i)))
				break;
		return path1.get(i-1); 
		
	}
	// DFS method to find all root to node paths.
	// DO NOT FORGET to  remove the last element of the ArrayList 
	// at end of each iteration because we want different paths.
	
	static boolean findPath(TreeNode root,int n,ArrayList<Integer> path)
	{
		if(root==null)
			return false;
		path.add(root.val);
		if(root.val == n)
			return true;
		if(root.left != null && findPath(root.left,n,path) )
			return true;
		if(root.right != null && findPath(root.right,n,path) )
			return true;
		path.remove(path.size()-1);
		return false;
	}
	static class TreeNode
	{
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int val)
		{
			this.val = val;
			left = null;
			right = null;
		}
	}
}
