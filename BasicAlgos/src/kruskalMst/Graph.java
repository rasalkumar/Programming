package kruskalMst;

import java.util.*;

public class Graph {

	static class Edge implements Comparable<Edge>
	{
		int src, dest, weight ;
		public int compareTo(Edge compareEdge)
		{
			return (this.weight-compareEdge.weight);
		}
		
	}
	static class subset
	{
		int parent, rank;
	}
	public static void addEdge(int u , int v)
	{
		
	}
	Edge edge[];
	int v;
	int e;
	Graph(int V, int E)
	{
		this.v = V;
		this.e = E;
		Edge[] edge = new Edge[E];
		for(int  i = 0 ; i < E ; i++)
		{
			edge[i] = new Edge();
		}
	}
	public int find(subset[] subsets , int i)
	{
		if(subsets[i].parent != i)
		{
			subsets[i].parent = find(subsets, subsets[i].parent);
		}
		return subsets[i].parent;		
	}
	 void union(subset[] subsets , int x , int y )
	{
		int xroot = find(subsets , x);
		int yroot = find(subsets , y);
		if(subsets[xroot].rank < subsets[yroot].rank)
		{
			subsets[xroot].parent = yroot;
		}
		else if(subsets[xroot].rank > subsets[yroot].rank)
		{
			subsets[yroot].parent = xroot;
		}
		else
		{
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}
	void kruskal(int V , int E)
	{
		Edge[] result = new Edge[V];
		subset subsets[] = new subset[V];
		for(int  i = 0 ; i < V ; i++ )
		{
			result[i] = new Edge();
		}
		for(int  i = 0 ; i < V ; i++ )
		{
			subsets[i] = new subset();
		}
		Arrays.sort(edge);
		int i = 0 ;
		int e = 0 ;
		while( e < V-1 )
		{
			Edge nextEdge = new Edge();
			nextEdge = edge[i++];
			int x = find( subsets , nextEdge.src );
			int y = find( subsets , nextEdge.dest );
			if(x!=y)
			{
				result[e++] = nextEdge;
				union(subsets, x, y);
			}
		}
		System.out.println("Following are the Edges in the constructed MST");
		for(i=0;i<e;i++)
		{
			System.out.println(result[i].src+"--"+result[i].dest+"=="+result[i].weight);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int V = 4;  // Number of vertices in graph
	        int E = 5;  // Number of edges in graph
	        Graph graph = new Graph(V, E);
	 
	        // add edge 0-1
	        graph.edge[0].src = 0;
	        graph.edge[0].dest = 1;
	        graph.edge[0].weight = 10;
	 
	        // add edge 0-2
	        graph.edge[1].src = 0;
	        graph.edge[1].dest = 2;
	        graph.edge[1].weight = 6;
	 
	        // add edge 0-3
	        graph.edge[2].src = 0;
	        graph.edge[2].dest = 3;
	        graph.edge[2].weight = 5;
	 
	        // add edge 1-3
	        graph.edge[3].src = 1;
	        graph.edge[3].dest = 3;
	        graph.edge[3].weight = 15;
	 
	        // add edge 2-3
	        graph.edge[4].src = 2;
	        graph.edge[4].dest = 3;
	        graph.edge[4].weight = 4;
	 
	        graph.kruskal(V, E);

	}
	
}
