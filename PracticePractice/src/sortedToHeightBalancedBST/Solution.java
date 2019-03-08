package sortedToHeightBalancedBST;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
	}
	public static TreeNode sortedToBst(ArrayList<Integer> a)
	{
		if(a == null || a.size() == 0)
		{
			return null;
		}
		return sortedToBst(a,0,a.size()-1);
	}
	public static TreeNode sortedToBst(ArrayList<Integer> a ,int start,int end)
	{
		int mid = ( start + end ) / 2 ;
		TreeNode root = new TreeNode(a.get(mid));
		root.left = sortedToBst(a,start,mid -1);
		root.right = sortedToBst(a,mid+1,end);
		return root;
	}
	static class TreeNode
	{
		TreeNode left,right;
		int val;
		TreeNode(int val)
		{
			this.val = val;
			left = null;
			right = null;
		}
	}

}
