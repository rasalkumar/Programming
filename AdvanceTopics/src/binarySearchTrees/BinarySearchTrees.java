package binarySearchTrees;
public class BinarySearchTrees {

	class TreeNode
	{
		int key;
		TreeNode left,right;
		TreeNode(int key)
		{
			this.key = key ;
			left = null;
			right = null;
		}
	}
	TreeNode root;
	BinarySearchTrees()
	{	
		root = null;
	}
	public void put(int key)
	{
		root = putHelper(root,key);
	} 
	public TreeNode putHelper(TreeNode root, int key)
	{
		if(root == null)
		{
			root = new TreeNode(key);
			return root;
		}
		if(key < root.key)
			root.left =  putHelper(root.left , key);
		if(key > root.key)
			root.right = putHelper(root.right , key);
		return root;
	}
	public TreeNode get(int key)
	{
		return getHelper( root , key);
	}
	public TreeNode getHelper(TreeNode root, int key)
	{
		if(root == null || root.key == key)
		{
			return root;
		}
		if(key < root.key)
			return getHelper(root.left , key);
		if(key > root.key)
			return getHelper(root.right , key);
		return root;
	}
	public void inOrder()
	{
		inOrderHelper(root);
	}
	public void inOrderHelper(TreeNode root)
	{
		if(root == null ) 
			return;
		inOrderHelper(root.left);
		System.out.println(root.key);
		inOrderHelper(root.right);
	}
	public static void main(String[] args) 
	{
		BinarySearchTrees t = new BinarySearchTrees();
		t.put(10);
		t.put(20);
		t.put(30);
		t.put(40);
		t.put(50);
		
		t.inOrder();
	}

}
