package oracle;

public class AvlTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Node insert(Node node, int x) {
		if (node == null)
			return new Node(x);
		if (x < node.val) {
			node.left = insert(node.left, x);
		} else if (x > node.val) {
			node.right = insert(node.right, x);
		} else {
			return node;
		}
		node.height = 1 + Math.max(height(node.left), height(node.right));

		int balance = getBalance(node);

		if (balance > 1 && x < node.left.val) {
			return rotateRight(node);
		}
		if (balance > 1 && x > node.left.val) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}
		if (balance < -1 && x < node.right.val) {
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}
		if (balance < -1 && x > node.right.val) {
			return rotateLeft(node);
		}
		return node;
	}
	public static boolean isBalanced(Node node)
	{
		int lh = 0;
		int rh = 0;
		if(node == null)
			return true;
		lh = height(node.left);
		rh = height(node.right);
		if(Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right))
			return true;
		return false;
	}
	public static Node deleteNode(Node root,int key)
	{
		if(root == null)
			return root;
		if(key < root.val)
		{
			root.left = deleteNode(root.left, key);
		}
		if(key > root.val)
		{
			root.right = deleteNode(root.right, key);
		}
		else
		{
			if(root.left == null || root.right == null)
			{
				Node temp = null;
				if(temp == root.right)
					temp = root.left;
				else
					temp = root.right;
				if(temp == null)
				{
					root= null;
				}
				else
					root = temp; 
			}
			else
			{
				Node temp = minValueNode(root.right);
				root.val = temp.val;
				root.right = deleteNode(root.right,temp.val);
			}
		}
		if(root == null)
			return root;
		root.height = 1 + Math.max(height(root.left), height(root.right));
		int balance = getBalance(root);
		if(balance > 1 && getBalance(root.left) >= 0)
			rotateRight(root);
		if(balance > 1 && getBalance(root.left) < 0)
		{
			root.left = rotateLeft(root.left);
			rotateRight(root);
		}
		if(balance < -1 && getBalance(root.right) < 0)
		{
			rotateLeft(root);
		}
		if(balance < -1 && getBalance(root.right) > 0)
		{
			root.right = rotateRight(root.right);
			rotateLeft(root);
		}
		return root;
	}
	public static Node minValueNode(Node root)
	{
		Node curr =root;
		while(curr.left != null)
		{
			curr = curr.left;
		}
		return curr;
	}
	public static Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		h.height = 1 + Math.max(height(h.left), height(h.right));
		x.height = 1 + Math.max(height(x.left), height(x.right));
		return x;
	}

	public static Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		h.height = 1 + Math.max(height(h.left), height(h.right));
		x.height = 1 + Math.max(height(x.left), height(x.right));
		return x;
	}

	public static int getBalance(Node x) {
		if (x == null)
			return 0;
		return height(x.left) - height(x.right);
	}

	public static int height(Node x) {
		if (x == null)
			return 0;
		return 1 + Math.max(height(x.left), height(x.right));
	}

	static class Node {
		int val;
		Node left, right;
		int height;

		Node(int val) {
			this.val = val;
			left = right = null;
			height = 1;
		}
	}
}
