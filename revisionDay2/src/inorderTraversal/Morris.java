package inorderTraversal;
import java.util.*;

public class Morris {
	static TreeNode[] tree;
	static int n;
	static ArrayList<Integer> inOrder;
	static ArrayList<Integer> preOrder;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
        	TreeNode[] tree = new TreeNode[n+1];
        	tree[0] = null;
        	for(int i = 1 ; i <= n ; i++ )
        	{
        		tree[i] = new TreeNode(i);
        	}
        	//int k = in.nextInt();
        	int a[] = new int[n+1];
        	int b[] = new int[n+1];
        	for(int i = 1; i <= n ; i++)
        	{
        		a[i] = in.nextInt();
        		b[i] = in.nextInt();
        		if(a[i] == 0)
				{
					tree[i].left = null;
				}
				else
				{
					tree[i].left = tree[a[i]];
				}
        		if(b[i]==0)
        		{
        			tree[i].right = null;
        		}
        		else
        		{
        			tree[i].right = tree[b[i]];
        		}
        	}
			inOrder = new ArrayList<>();
			preOrder = new ArrayList<>();
			morrisInOrder(tree[1]);
			System.out.println("InOrder : " + inOrder );
			System.out.println("PreOrder : " + preOrder );
		}
	}
	static void morrisInOrder(TreeNode root)
	{
		TreeNode curr = root;
		while(curr != null )
		{
			if(curr.left == null)
			{
				inOrder.add(curr.val);
				preOrder.add(curr.val);
				curr = curr.right;
			}
			else
			{
				TreeNode pre = curr.left;
				while(pre.right != null && pre.right != curr )
					pre = pre.right;
				if(pre.right != curr)
				{
					inOrder.add(curr.val);
					pre.right = null;
					curr = curr.right;
				}
				else
				{
					preOrder.add(curr.val);
					pre.right = curr;
					curr = curr.left;		
				}
			}
		}
	}
	static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val)
		{
			this.val = val;
			left = null;
			right = null;
		}
	}

}
