package maximumRootToLeafPath;
import java.util.*;
public class DpTrees {
    static int V = 14 ;
    static int dp[];
    static LinkedList<Integer>[] adj ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		adj = new LinkedList[V+1];
		for(int i = 0 ; i < V+1 ; i++ )
		{
			adj[i] = new LinkedList<Integer>();
		}
		addEdge(1,2); 
	    addEdge(3,1); 
	    addEdge(4,1); 
	    addEdge(5,2); 
	    addEdge(2,6); 
	    addEdge(3,7); 
	    addEdge(4,8); 
	    addEdge(4,9); 
	    addEdge(4,10);
	    addEdge(5,11);
	    addEdge(5,12);
	    addEdge(7,13);
	    addEdge(7,14);
	    int a[] = { 3, 2, 1, 10, 1, 3, 9, 1, 5, 3, 4, 5, 9, 8 };
	    dp = new int[100];
	    System.out.println(maxValue(a,adj));
	}
	public static int maxValue(int a[], LinkedList<Integer>[] adj)
	{
		dfs(a,adj,1,0);
		return dp[1];
	}
	public static void dfs(int[] a, LinkedList<Integer>[] adj,int u,int parent )
	{ 
		dp[u] = a[u-1];                       //Base condition
		int max =  0 ;
		for(int child : adj[u])
		{
			if(child==parent)                 //In case of loop so that it does not go in infinite recursion
				continue;
			dfs(a,adj,child,u);               //Recursion dfs
			max = Math.max(max, dp[child]);   //Opertation to be done one the leaf Nodes
		}
		dp[u] += max;                         // Memoization and final value of the leaf
	}
	public static void addEdge(int v,int w)
	{
		adj[v].add(w);
		adj[w].add(v);
	}
	

}
