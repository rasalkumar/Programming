package verticalOrderTraversal;

import java.util.*;

public class Solution {
	public ArrayList<ArrayList<Integer>> verticalOrder(TreeNode root)
	{
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		if(root==null)
		{
			return result;
		}
		LinkedList<Wrapper> queue= new LinkedList<Wrapper>();
		queue.offer(new Wrapper(root, 0));
		TreeMap<Integer, ArrayList<Integer>> map= new TreeMap<Integer,ArrayList<Integer>>();
		while(!queue.isEmpty())
		{
			Wrapper w=queue.poll();
			TreeNode node= w.node;
			int level=w.level;
			if(map.containsKey(level))
			{
				map.get(level).add(node.val);
			}
			else
			{
				ArrayList<Integer> t = new ArrayList<Integer>();
				t.add(node.val);
				map.put(level, t);
			}
			if(node.left!=null)
			{
				queue.offer(new Wrapper(node.left,level-1));
			}
			if(node.right!=null)
			{
				queue.offer(new Wrapper(node.right,level+1));
			}
		}
		for(Map.Entry<Integer, ArrayList<Integer>> entry:map.entrySet())
		{
			result.add(entry.getValue());
		}
		return result;
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
class Wrapper
{
	TreeNode node;
	int level;
	public Wrapper(TreeNode n,int l)
	{
		node=n;
		level=l;
	}
	}