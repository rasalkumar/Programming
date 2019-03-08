package dpTrees;
import java.util.*;
// Find maximum root to leaf sum path in O(n)
public class DpTrees {
	static int V = 14;
	static int dp[];
	static LinkedList<Integer> adj[] ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			int a[] = new int[n];
			for(int i = 0 ; i < n ; i++ )
			{
				a[i] = in.nextInt();
			}
			System.out.println(maxValue(a));
		}
	}
	public static int maxValue(int[] a )
	{
		dp = new int[a.length + 1 ];
		Arrays.fill(dp, 0);
		dfs(a,1,0);
		return dp[1];
	}
	public static void dfs(int[] a, int u,int parent)
	{
		dp[u] = a[u-1];
		int max = 0;
		for(int child : adj[u] )
		{
			if(child == parent)
				continue;
			dfs(a,child,u);
			max = Math.max(dp[child], max);
		}
		dp[u] = dp[u] + max;
	}
	public static void addEdge(int u,int v)
	{
		adj[u].add(v);
		adj[v].add(u);
	}

}
