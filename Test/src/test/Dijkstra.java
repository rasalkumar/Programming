package test;
import java.util.*;
public class Dijkstra {
static int n;
static LinkedList<Edge> adj[];
static int graph[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void dijkstraPq(int src)
	{
		int[] dist = new int[n];
		boolean[] sptSet = new boolean[n];
		for(int i = 0 ; i < n ;i++)
		{
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		PriorityQueue<Pair> pq = new PriorityQueue<>(n,new Comparator<Pair>()
		{
			public int compare(Pair p1, Pair p2)
			{
				return p1.distance -p2.distance;
			}
		});
		pq.add(new Pair(dist[src],src));
		while(!pq.isEmpty())
		{
			Pair curr = pq.poll();
			sptSet[curr.index] = true;
			LinkedList<Edge> p = adj[curr.index];
			for(Edge e : p)
			{
				int u = e.dest;
				if( !sptSet[u] && dist[curr.index] + e.weight < dist[u])
				{
					dist[u] = dist[curr.index] + e.weight;
					pq.add(new Pair(dist[u],u));
				}
			}
		}
	}
	static class Pair
	{
		int distance, index;
		Pair(int x,int y)
		{
			distance = x; 
			index = y;
		}
	}
	static class Edge
	{
		int src,dest,weight;
		Edge(int src,int dest,int weight)
		{
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	}
	public static void dijkstra(int src,int V)
	{
		boolean sptSet[] = new boolean[V];
		int dist[] = new int[V];
		for( int i = 0 ; i < V ; i++ )
		{
			sptSet[i] = false;
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src] = 0;
		for(int count = 0 ; count < V - 1 ; count++ )
		{
			int u = minKey(sptSet, dist,V);
			sptSet[u] = true;
			for( int v = 0 ; v < V ; v++ )
			{
				if( !sptSet[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v])
				{
					dist[v] = dist[u] + graph[u][v];
				}
			}
		}
		
	}
	public static int minKey(boolean[] sptSet,int[] dist,int V)
	{
		int minKey = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int v = 0 ; v < V ;v++)
		{
			if(!sptSet[v] && dist[v] < minKey)
			{
				minKey = dist[v];
				minIndex = v;
			}
		}
		return minIndex;
	}

}
