package ethanTraversesATree;
import java.util.*;
public class Solution {
    static ArrayList<Integer> preOrder;
    static ArrayList<Integer> postOrder;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int m = 1 ;
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
        	int k = in.nextInt();
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
        	preOrder = new ArrayList<>();
        	postOrder = new ArrayList<>();
        	preOrderGen(tree[1]);
        	postOrderGen(tree[1]);
        	//System.out.println(postOrder);
        	//System.out.println(preOrder);
        	Pair[] map = new Pair[n];
        	HashMap<Integer,Integer> map1 = new HashMap<>();
        	for(int  i = 0 ; i < n ; i++ )
        	{
        		map[i]=new Pair(postOrder.get(i), preOrder.get(i));
        		map1.put(postOrder.get(i), preOrder.get(i));
        	}
        	HashMap<Integer, Integer> check = new HashMap<>();
        	boolean[] ans = new boolean[n+1];
        	int[] ans2 = new int[n+1];
        	int count = 1 ;
        	int flag = 0;
        	int flag2 = 0;
        	for(int i = 0 ; i < n ; i++)
        	{
        		int c = map[i].x;
        		int d = map[i].y;
        		while(!check.containsKey(c) && check.size() <= n )
        		{
        			ans[c] = true;
        			ans2[c]=count;
        			
        			ans[d] = true;
        			ans2[d] = count;
        			
        			check.put(c, d);
        			
        			c = d;
        			d = map1.get(c);
        			flag = 1 ;
        		}
        		if(flag == 1)
        		{
        			count++;
        			flag = 0;
        		}
        		if( count == k + 1 )
        		{
        			count = 1;
        			flag2 = 1;
        		}
        	}
        	//System.out.println(count);
        	for(int i = 1 ; i < n + 1 ; i++)
        	{
        		if(ans[i] == false || ans2[i]==0 || ans2[i] > k )
        		{
        			flag2 = 0;
        		}
        	}
        	if(flag2 ==0 )
        	{
        		System.out.println("Case #"+m+": "+"Impossible");
        	}
        	else
        	{
        		System.out.print("Case #"+m+": ");
        		for(int i = 1 ; i < n + 1 ; i++)
        		{
        			System.out.print(ans2[i]+" ");
        		}
        		System.out.println();
        	}
        	m++;
        }
        
    }
	public static void preOrderGen(TreeNode root)
	{
		if(root == null)
		{
			return; 
		}
		preOrder.add(root.label);
		preOrderGen(root.left);
		preOrderGen(root.right);
	}
	public static void postOrderGen(TreeNode root)
	{
		if(root == null)
		{
			return; 
		}
		postOrderGen(root.left);
		postOrderGen(root.right);
		postOrder.add(root.label);
	}
	static class TreeNode
	{
		int label;
		TreeNode left;
		TreeNode right;
		TreeNode(int label)
		{
			this.label = label;
			this.left = null;
			this.right = null;
		}
	}
	static class Pair
	{
		int x,y;
		Pair(int x, int y)
		{
			this.x = x; 
			this.y = y;
		}
	}

}
