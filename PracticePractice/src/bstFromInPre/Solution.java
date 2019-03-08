package bstFromInPre;
import java.util.*;
public class Solution {
	static int pIndex = 0 ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static TreeNode inPre(ArrayList<Integer> inOrder,
			ArrayList<Integer> preOrder,int start,int end)
	{
		if(start > end)
		{
			return null;
		}
		int index = preOrder.get(pIndex++);
		int minIndex = 0 ;
		int minValue = Integer.MAX_VALUE;
		for(int i = start; i <= end ; i++ )
		{
			if(inOrder.get(i)== index)
			{
				minIndex = i;
				minValue = inOrder.get(i);
			}
		}
		TreeNode root = new TreeNode(minValue);
		root.left = inPre( inOrder, preOrder,start,minIndex - 1);
		root.right = inPre( inOrder, preOrder, minIndex + 1, end);
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
