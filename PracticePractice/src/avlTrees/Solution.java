package avlTrees;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	
	public static AvlTreeNode insert(AvlTreeNode node, int key)
	{
		if(node == null)
		{
			return new AvlTreeNode(key);
		}
		if(key < node.data)
		{
			node.left = insert(node.left,key);
		}
		else if( key > node.data )
		{
			node.right = insert(node.right,key);
		}
		else
		{
			return node;
		}
		
		node.height = 1+ Math.max(height(node.left), height(node.right));
		int balance = getBalance(node);
		if(balance > 1 && key < node.left.data)
		{
			return rotateRight(node);
		}
		if(balance > 1 && key > node.left.data)
		{
			node.left = rotateLeft(node.left);
			rotateRight(node);
		}
		if(balance < -1 && key > node.right.data)
		{
			return rotateLeft(node);
		}
		if(balance < -1 && key < node.right.data)
		{
			node.right = rotateRight(node.right);
			rotateLeft(node);
		}
		return node;
		
	}
	//Follow standard procedure of deleting a node from a BST
	public static AvlTreeNode deleteNode(AvlTreeNode root, int key)
	{
		if(root == null)
			return root;
		if( key < root.data )
		{
			root.left = deleteNode(root.left, key);
		}
		if( key > root.data )
		{
			root.right = deleteNode(root.right, key);
		}
		else
		{
			if(root.left == null || root.right == null)
			{
				AvlTreeNode temp = null;
				if( temp == root.left )
				{
					temp = root.right;
				}
				else
				{
					temp = root.left;
				}
				if( temp == null )
				{
					temp = root;
					root = null;
				}
				else
				{
					root = temp ;
				}
			}
			else
			{
				AvlTreeNode temp = minValueNode(root.right);
				root.data = temp.data;
				root.right = deleteNode(root.right, temp.data);
			}
		}
		if( root == null )
			return root;
		root.height = 1 + Math.max(height(root.left), height(root.right));
		int balance = getBalance(root);
		if(balance > 1 && getBalance(root.left) >= 0 )
		{
			 rotateRight(root);
		}
		if(balance > 1 && getBalance(root.left) < 0 )
		{
			root.left = rotateLeft(root);
			rotateRight(root);
		}
		if(balance < -1 && getBalance(root.right) >= 0 )
		{
			rotateRight(root.right);
			rotateLeft(root);
		}
		if(balance < -1 && getBalance(root.right) < 0 )
		{
			rotateLeft(root);
		}
		return root;
	} 
	public static AvlTreeNode minValueNode(AvlTreeNode node)
	{
		AvlTreeNode current = node;
		while( current.left != null )
		{
			current = current.left;
		}
		return current;
	}
	public static boolean isBalanced(AvlTreeNode node)
	{
		int lh = 0; 
		int rh = 0;
		if(node == null)
		{
			return true;
		}
		lh = height(node.left);
		rh = height(node.right);
		if( Math.abs(lh-rh) <= 1 && isBalanced(node.left) 
				&& isBalanced(node.right))
		{
			return true;
		}
		return false;
	}
	public static AvlTreeNode rotateLeft(AvlTreeNode h)
	{
		AvlTreeNode x = h.right;
		h.right = x.left;
		x.left = h;
		h.height = 1 + Math.max(height(h.left), height(h.right));
		x.height = 1 + Math.max(height(x.left), height(x.right));
		return x;
	}
	
	public static AvlTreeNode rotateRight(AvlTreeNode h)
	{
		AvlTreeNode x = h.left;
		h.left = x.right;
		x.right = h;
		h.height = 1 + Math.max(height(h.left), height(h.right));
		x.height = 1 + Math.max(height(x.left), height(x.right));
		return x;
	}
	
	public static int height(AvlTreeNode node)
	{
		if(node == null)
			return 0;
		return 1 + Math.max(height(node.left),height(node.right));
	}
	public static int getBalance(AvlTreeNode node)
	{
		if(node == null)
			return 0;
		return height(node.left) - height(node.right);
	}
	static class AvlTreeNode
	{
		AvlTreeNode left,right;
		int data,height;
		public AvlTreeNode(int key) 
		{
			data = key;
			height = 1 ;
		}
	}

}
