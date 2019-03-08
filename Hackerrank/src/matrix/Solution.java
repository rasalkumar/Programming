package matrix;
import java.util.*;
public class Solution {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		Edge[] edge = new Edge[n-1];
		for(int i = 0 ; i < n - 1 ; i++ )
		{
			int x = in.nextInt();
			int y = in.nextInt();
			int z = in.nextInt();
			edge[i].src = x ;
			edge[i].dest = y;
			edge[i].weight = z ;
		}
		int[] red =new int[k];
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0 ; i < k ; i++ )
		{
			red[i] = in.nextInt();
			set.add(red[i]);
		}
		Arrays.sort(edge,Collections.reverseOrder(new Comparator<Edge>() {
			public int compare(Edge e1 , Edge e2)
			{
				return e1.weight - e2.weight;
			}
		}));
		Subset[] subsets =new Subset[n];
		for( int i = 0 ;i < n ; i++ )
		{
			subsets[i] = new Subset(); 
		}
		Edge[] result =new Edge[n];
		for( int i = 0 ;i < n ; i++ )
		{
			result[i] = new Edge(); 
		}
		int i = 0;
		int e = 0;
		while(e < n - 1)
		{
			Edge nextEdge = new Edge();
			nextEdge = edge[i++];
			int x = find( subsets , nextEdge.src );
			int y = find( subsets , nextEdge.dest );
			if(x!=y )
			{
				result[e++] = nextEdge;
				union(subsets, x, y);
			}
		}
		
		
	}
	static class Edge
	{
		int src,dest,weight;
		
	}
	static class Subset
	{
		int parent,rank;
	}
	public static int find(Subset[] subset ,int i)
	{
		if(subset[i].parent != i)
		{
			subset[i].parent = find(subset, subset[i].parent);
		}
		return subset[i].parent;
	}
	public static void union(Subset[] subsets,int x,int y)
	{
		int xroot = find(subsets,x);
		int yroot = find(subsets,y);
		if(subsets[xroot].rank < subsets[yroot].rank )
		{
			subsets[xroot].parent = yroot;
		}
		if(subsets[xroot].rank > subsets[yroot].rank )
		{
			subsets[yroot].parent = xroot;
		}
		else
		{
			subsets[yroot].parent = xroot;
			subsets[yroot].rank++;
		}
	}
	
}
