package amazon;
import java.util.*;
public class VerticalOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void VerticalLevelOrder(TreeNode root)
	{
		Queue<Wrapper> q = new LinkedList<>();
		q.add(new Wrapper(root,0));
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
		while(!q.isEmpty())
		{
			Wrapper curr = q.poll();
			if(map.get(curr.level) == null)
			{
				ArrayList<Integer> a = new ArrayList<>();
				a.add(curr.t.val);
			}
			else
			{
				map.get(curr.level).add(curr.t.val);
			}
			if(curr.t.left != null)
			{
				q.add(new Wrapper(curr.t.left,curr.level - 1));
			}
			if(curr.t.right != null)
			{
				q.add(new Wrapper(curr.t.right,curr.level + 1));
			}
		}
	}
	static ArrayList<Integer> p1;
	static ArrayList<Integer> p2;
	static int lca(TreeNode root, int v1, int v2)
	{
		if(!findPath(root,v1,p1) || !findPath(root, v2, p2))
		{
			return -1;
		}
		int i = 0;
		for(i = 0 ; i < Math.min(p1.size(), p2.size()) ; i++)
		{
			if(p1.get(i) != p2.get(i))
			{
				break;
			}
		}
		return p1.get(i-1);
	}
	static boolean findPath(TreeNode root,int val,ArrayList<Integer> path)
	{
		if( root.left == null && root.right == null )
			return false;
		path.add(root.val);
		if(root.left != null && findPath(root.left, val, path))
		{
			return true;
		}
		if(root.right != null && findPath(root.right, val, path))
		{
			return true;
		}
		path.remove(path.size()-1);
		return false;
	}
	static class TreeNode
	{
		int val;
		TreeNode left,right;
		TreeNode(int val)
		{
			this.val = val;
			left = right = null ;
		}
	}
	static class Wrapper
	{
		TreeNode t;
		int level;
		Wrapper(TreeNode t, int level)
		{
			this.t = t;
			this.level = level;
		}
	}
	public static void MorrisInorder(TreeNode root)
	{
		TreeNode curr = root;
		while(curr != null)
		{
			if(curr.left == null)
			{
				System.out.println(curr.val);
				curr = curr.right;
			}
			else
			{
				TreeNode pre = curr.right;
				while(pre.right != null && pre.right == curr)
				{
					pre = pre.right;
				}
				if(pre.right == curr)
				{
					System.out.println(curr.val);
					pre.right = null;
					curr = curr.right;
				}
				else
				{
					pre.right = curr;
					curr = curr.left;
				}
			}
		}
	}
	public static void MorrisPreOrder(TreeNode root)
	{
		TreeNode curr = root;
		while(curr != null)
		{
			if(curr.left == null)
			{
				System.out.println(curr.val);
				curr = curr.right;
			}
			else
			{
				TreeNode pre = curr.right;
				while(pre.right != null && pre.right == curr)
				{
					pre = pre.right;
				}
				if(pre.right == curr)
				{
					pre.right = null;
					curr = curr.right;
				}
				if(pre.right == null)
				{
					System.out.println(curr.val);
					pre.right = null;
					curr = curr.left;
				}
			}
		}
	}
	public static ArrayList<Integer> recoverBST(TreeNode root)
	{
		TreeNode node1, node2, first,second;
		node1 = node2 = first = second = null;
		TreeNode curr = root;
		while (curr != null)
		{
            if (curr.left == null) 
            {
                if (node1 == null)
                	node1 = curr;
                else if (node2 == null) 
                	node2 = curr;
                else 
                { 
                    node1 = node2; 
                    node2 = curr;
                }
                curr = curr.right;
            }
            else 
            {
                TreeNode pre = curr.left;
                while (pre.right != null && pre.right != curr) 
                	pre = pre.right;
                if(pre.right == curr)
                {
                    pre.right = null;
                    if (node2 == null)
                    	node2 = curr;
                    else 
                    {
                        node1 = node2; 
                        node2 = curr;
                    }
                    curr = curr.right;
                }
                if (pre.right == null) 
                {
                    pre.right = curr;
                    curr = curr.left;
                    continue;
                }
            }
            if (node1 != null && node2 != null && node1.val > node2.val) {

                if (first == null)
                	first = node1;
                second = node2;
            }
        }
        /* Now lets return the answer */
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(Math.min(first.val, second.val));
        ans.add(Math.max(first.val, second.val));
        return ans;
	}
	public static int getHeight(TreeNode root)
	{
		if(root == null)
			return 0;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
	public static boolean isBalanced(TreeNode root)
	{
		if(root == null)
			return true;
		int lh = getHeight(root.left);
		int rh = getHeight(root.right);
		if(Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right))
		{
			return true;
		}
		return false;
	}
	public static boolean isSymmetric(TreeNode root)
	{
		if(root == null)
			return true;
		if(isSymmetric(root.left ,root.right))
			return true;
		return false;
	}
	public static boolean isSymmetric(TreeNode left ,TreeNode right)
	{
		if(left == null && right == null)
			return true;
		if(left == null || right == null)
			return false;
		if(left.val != right.val)
			return false;
		if(!isSymmetric(left.left,right.right))
			return false;
		if(!isSymmetric(left.right, right.left))
			return false;
		return true;
	}
	static class BstIterator
	{
		Stack<TreeNode> stack;
		public BstIterator(TreeNode root)
		{
			stack = new Stack<>();
			while(root != null)
			{
				stack.push(root);
				root = root.left;
			}
		}
		public boolean hasNext()
		{
			//System.gc
			return !stack.isEmpty();
		}
		public int next()
		{
			TreeNode node  = stack.pop();
			int result = node.val;
			if(node.right != null )
			{
				node = node.right;
				while(node != null)
				{
					stack.push(node);
					node = node.left;
				}
			}
			return result;
		}
	}

}
