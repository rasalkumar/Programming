package kruskalMst;

import java.util.*;

public class Graph {

	// A class to represant a graph Edge
	class Edge implements Comparable<Edge> {
		int src, dest, weight;

		// Comparator used for sorting the edges according to their weight
		@Override
		public int compareTo(Edge compareEdge) {
			// TODO Auto-generated method stub
			return this.weight - compareEdge.weight;
		}

	};

	// A class to represent a Subset for Union-Find
	class subset {
		int parent, rank;
	};

	int V, E; // No of vertices and No. of Edges
	Edge edge[]; // Collection of all Edges

	// Create a Graph with V vertices and E edges
	Graph(int v, int e) {
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i = 0; i < e; i++) {
			edge[i] = new Edge();
		}
	}

	// To find set of an Element i using Path Compression Technique
	int find(subset subsets[], int i) {
		if (subsets[i].parent != i) {
			subsets[i].parent = find(subsets, subsets[i].parent);
		}
		return subsets[i].parent;
	}

	// A function that does union of two sets X and Y
	// Uses union by Rank
	void Union(subset subsets[], int x, int y) {
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);
		// Attach smaller rank tree under higher rank tree
		// Union by Rank
		if (subsets[xroot].rank < subsets[yroot].rank) {
			subsets[xroot].parent = yroot;
		} else if (subsets[xroot].rank > subsets[yroot].rank) {
			subsets[yroot].parent = xroot;
		} else // If ranks are same, then make one as root and increment its
				// rank by one
		{
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}

	// The main function to construct MST using Kruskal's Algorithm
	void KruskalMST() {
		Edge result[]=new Edge[V];
		int e=0;  //A local variable used for result
		int i=0;  //A local variable used for sorted edges
		for(i=0;i<V;i++)
		{
			result[i]=new Edge();
		}
		Arrays.sort(edge);
		
		// Allocate memory for creating V subsets
		subset subsets[]=new subset[V];
		for(i=0;i<V;i++)
		{
			subsets[i]=new subset();
		}
		// Create V subsets with single elements
		for(int v=0;v<V;v++)
		{
			subsets[v].parent=v;
			subsets[v].rank=0;
		}
		i = 0;
		while( e < V - 1 )
		{
			//Pick the smallest edge and increment it's index for next iteration
			Edge next_edge=new Edge();
			next_edge=edge[i++];
			
			int x=find(subsets,next_edge.src);
			int y=find(subsets,next_edge.dest);
			
			//If this edge dosen't cause a cycle include this edge in the result
			//Increment the index of result for the next page.
			
			if(x!=y)
			{
				result[e++]=next_edge;
				Union(subsets, x, y);
			}
			
		}
		System.out.println("Following are the Edges in the constructed MST");
		for(i=0;i<e;i++)
		{
			System.out.println(result[i].src+"--"+result[i].dest+"=="+result[i].weight);
		}

	}
	public static void main (String[] args)
    {
 
        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
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
 
        graph.KruskalMST();
    }

}
