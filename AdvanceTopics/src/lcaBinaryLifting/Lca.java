package lcaBinaryLifting;
import java.util.*;
public class Lca 
{
	static int n, l;
	static ArrayList<Integer>[] adj;
	static int timer;
	static int[] tin, tout;
	static int[][] up;
	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		adj = new ArrayList[n];
		for(int i = 0 ; i < n ; i++)
		{
			adj[i] = new ArrayList<>();
		}
		int m = in.nextInt();
		for(int i = 0 ; i < m ; i++ )
		{
			int u = in.nextInt();
			int v = in.nextInt();
			adj[u].add(v);
			adj[v].add(u);
		}
		preprocess(0);
//		for(int i = 0 ;  i < up.length ; i++ )
//		{
//			for(int j = 0 ; j < up[0].length ; j++ )
//			{
//				System.out.print( up[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println();
		int q = in.nextInt();
		for(int i = 0 ; i <  q ; i++)
		{
			int x = in.nextInt();
			int y = in.nextInt();
			System.out.println(lca(x, y));
		}
	}
	static void preprocess(int root) {
	    tin = new int[n];
	    tout = new int[n];
	    timer = 0;
	    l = (int)Math.ceil((Math.log(n) / Math.log(2)));
	    up = new int[n][l+1];
	    dfs(root, root);
	}
	static void dfs(int v, int p)
	{
	    tin[v] = ++timer;
	    up[v][0] = p;
	    for (int i = 1; i <= l; ++i)
	        up[v][i] = up[up[v][i-1]][i-1];

	    for (int u : adj[v]) 
	    {
	        if (u != p)
	            dfs(u, v);
	    }
	    tout[v] = ++timer;
	}
	static boolean is_ancetor(int u, int v)
	{
	    return tin[u] <= tin[v] && tout[u] >= tout[v];
	}
	static int lca(int u, int v)
	{
	    if (is_ancetor(u, v))
	        return u;
	    if (is_ancetor(v, u))
	        return v;
	    for (int i = l ; i >= 0 ; --i)
	    {
	        if (!is_ancetor(up[u][i], v))
	            u = up[u][i];
	    }
	    return up[u][0];
	}
}
