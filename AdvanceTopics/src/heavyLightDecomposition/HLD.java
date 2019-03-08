package heavyLightDecomposition;
import java.util.*;
public class HLD
{
	static int maxn = 1000007;
	static int col[];
	static int cnt[];
	static boolean big[];
	static int[] sz;
	static ArrayList<Integer>[] adj;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		cnt = new int[maxn];
		big = new boolean[maxn];
		col = new int[maxn];
		int n = in.nextInt();
		adj = new ArrayList[n];
		for(int i = 0 ; i < n ; i++ )
		{
			adj[i] = new ArrayList<>();
		}
		
	}
	
	static void add(int v, int p, int x){
	    cnt[ col[v] ] += x;
	    for(int u: adj[v])
	        if(u != p && !big[u])
	            add(u, v, x);
	}
	static void dfs(int v, int p, boolean keep){
	    int mx = -1, bigChild = -1;
	    for(int u : adj[v])
	    {
	       if(u != p && sz[u] > mx)
	       {
	          mx = sz[u]; 
	          bigChild = u;
	       }
	    }
	    for(int u : adj[v])
	    {
	    	if(u != p && u != bigChild)
	            dfs(u, v, false);  // run a dfs on small childs and clear them from cnt
	    }
	    if(bigChild != -1)
	    {
	        dfs(bigChild, v, true);
	        big[bigChild] = true;  // bigChild marked as big and not cleared from cnt
	    }
	    add(v, p, 1);
	    //now cnt[c] is the number of vertices in subtree of vertex v that has color c. You can answer the queries easily.
	    if(bigChild != -1)
	        big[bigChild] = false;
	    if(keep == false)
	        add(v, p, -1);

	}
}