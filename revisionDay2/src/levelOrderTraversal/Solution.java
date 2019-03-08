package levelOrderTraversal;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			
		}
	}
	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root)
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if(root == null)
			return result;
		int currentLevel = 1 ;
		int nextLevel = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		ArrayList<Integer> list = new ArrayList<>();
		while(!queue.isEmpty())
		{
			TreeNode node = queue.poll();
			list.add(node.val);
			currentLevel--;
			
			if(node.left != null)
			{
				queue.add(node.left);
				nextLevel++;
			}
			if(node.right != null)
			{
				queue.add(node.right);
				nextLevel++;
			}
			if(currentLevel==0)
			{
				nextLevel = currentLevel;
				nextLevel = 0;
				result.add(new ArrayList<>(list));
				list.clear();
			}
		}
		return result;
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
