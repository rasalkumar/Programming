package amazon;
import java.util.*;
public class FloorAndCeilOfBST {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		

	}
	static int Ceil(TreeNode node, int input)
	{
		if(node == null)
		{
			return -1;
		}
		if(node.data == input)
		{
			return node.data;
		}
		if(node.data < input)
		{
			return Ceil(node.right,input);
		}
		int ceil = Ceil(node.left,input);
		return (ceil >= input) ? ceil:node.data;
			
	}
	static int floor(TreeNode node, int input)
	{
		if(node == null)
		{
			return -1;
		}
		if(node.data == input)
		{
			return node.data;
		}
		if(node.data > input)
		{
			return floor(node.left,input);
		}
		int floor = floor(node.right,input);
		return (floor >= input) ? floor : node.data;
	}
	static class TreeNode
	{
		int data;
		TreeNode left,right;
		TreeNode(int data)
		{
			this.data = data;
			left = right = null;
		}
	}

}
