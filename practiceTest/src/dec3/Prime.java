package dec3;

import java.util.*;

public class Prime {
	static int n;
	static boolean[] r;
	static boolean[] visit;
	static LinkedList<Integer> adj[];
	static int graph[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
			

	}
	public static int largestRectangle(int[] height)
	{
		if(height == null)
			return 0;
		int i = 0 , max = 0;
		Stack<Integer> stack = new Stack<>();
		while( i < height.length )
		{
			if( stack.isEmpty() || stack.peek() <= height[i]  )
			{
				stack.push(i++);
			}
			else
			{
				int p = stack.pop();
				int h = height[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max( max , h * w );
			}
		}
		while(!stack.isEmpty())
		{
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(max, h * w);
		}
		return max;
	}
	public static boolean prime(int n)
	{
		if(n == 1)return false;
		if(n == 2)return true;
		if(n == 3)return true;
		if(n == 4) return false;
		int i = 5 ;int k =2;
		while( i * i <= n)
		{
			if( n % i == 0) return false;
			i = i + k;
			k = 6 - k;
		}
		return true;
	}
	public static void seiveOfEratosthenes()
	{
		boolean[] primes = new boolean[n+1];
		
		for(int i = 2 ;i <= n ; i++ )
		{
			primes[i] = true;
		}
		for(int i = 2 ; i * i <= n ; i++ )
		{
			if(primes[i])
			{
				for(int j = 2 * i ; j <= n ;j += i )
				{
					primes[i] = false;
				}
			}
		}
	}
	static class UnionFind
	{
		static HashMap<Integer,Integer> parent;
		static HashMap<Integer,Integer> size;
		static int max = 0;
		UnionFind()
		{
			parent = new HashMap<>();
			size = new HashMap<>();
			
		}
		public static void union(int v1,int v2)
		{
			if(!parent.containsKey(v1))
			{
				parent.put(v1, v1);
				size.put(v1, 1);
			}
			if(!parent.containsKey(v2))
			{
				parent.put(v2,v2);
				size.put(v2, 1);
			}
			int p1 = find(v1);
			int p2 = find(v2);
			int s1 = size.get(p1);
			int s2 = size.get(p1);
			if(s1 < s2)
			{
				parent.put(p1,p2);
				size.put(p2,s1+s2);
				if(s1 + s2 > max)
					max = s1 +s2;
			}else
			{
				parent.put(p2,p1);
				size.put(p1,s1+s2);
				if(s1 + s2 > max)
					max = s1 +s2;
			}
			
		}
		
		public static int find(int v)
		{
			while(v != parent.get(v))
			{
				parent.put(v, parent.get(parent.get(v)));
			}
			return v;
		}

	}
	
	// Dijsktra Algorithm
	public static int dijkstra(int src) {
		boolean sptSet[] = new boolean[n];
		int dist[] = new int[n];
		graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		dist[src] = 0;
		for (int count = 0; count < n - 1; count++) {
			int u = minKey(dist, sptSet);
			sptSet[u] = true;
			for (int v = 0; v < n; v++) {
				if (!sptSet[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
					dist[v] = dist[u] + graph[u][v];
				}
			}
		}
		return dist[n - 1];
	}
	static class DijkstraAdjacencyList
	{
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
		static class Pair
		{
			int dist, src;
			Pair(int dist,int src)
			{
				this.dist = dist;
				this.src = src;
			}
		}
		static LinkedList<Edge> adj[] ;
		public DijkstraAdjacencyList() {
			adj = new LinkedList[n];
			for(int i = 0 ; i < n ; i++ )
				adj[i] = new LinkedList<>();
		}
		public void addEdge(int src,int dest,int weight)
		{
			Edge e1 = new Edge(src,dest,weight);
			adj[src].add(e1);
			Edge e2 = new Edge(dest,src,weight);
			adj[dest].add(e2);
		}
		public static int dijkstra(int src)
		{
			int []dist = new int[n];
			boolean []sptSet = new boolean[n];
			for(int i = 0  ; i <  n ; i++)
			{
				dist[i] = Integer.MAX_VALUE;
				sptSet[i] = false;
			}
			dist[src] = 0 ;
			for(int count = 0 ; count < n - 1 ; count++ )
			{
				PriorityQueue<Pair> pq = new PriorityQueue<>(n, new Comparator<Pair>(){
					public int compare(Pair p1,Pair p2)
					{
						return p1.dist - p2.dist;
					}
				}); 
				pq.add(new Pair(dist[src],src));
				while(!pq.isEmpty())
				{
					Pair curr = pq.poll();
					sptSet[curr.src] = true;
					LinkedList<Edge> spt = adj[curr.src];
					for(Edge e : spt)
					{
						int u = e.dest;
						if(!sptSet[u] && dist[curr.src] + e.weight < dist[u] )
						{
							dist[u] = dist[curr.src] + e.weight ;
							pq.add(new Pair(dist[u],u));
						}
					}
				}
			}
			return dist[n-1];
		}
		
	}
	public static int minKey(int dist[], boolean[] sptSet) {
		int minKey = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int v = 0; v < n; v++) {
			if (!sptSet[v] && dist[v] < minKey) {
				minKey = dist[v];
				minIndex = v;
			}
		}
		return minIndex;
	}

	// DFS ACYCLIC
	public static boolean dfs() {
		visit = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visit[i])
				if (isCyclic(i, -1))
					return true;
		}
		return false;
	}

	public static boolean isCyclic(int v, int p) {
		visit[v] = true;
		for (int i = 0; i < adj[v].size(); i++) {
			if (!visit[adj[v].get(i)]) {
				if (isCyclic(adj[v].get(i), v))
					return true;
			} else if (adj[v].get(i) != v)
				return true;
		}
		return false;
	}

	// DFS CYCLIC
	public static boolean dfs2() {
		r = new boolean[n];
		visit = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (isCyclic2(i)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isCyclic2(int i) {
		if (r[i])
			return true;
		if (visit[i])
			return false;
		visit[i] = true;
		r[i] = true;
		for (int v = 0; v < adj[i].size(); i++) {
			if (isCyclic2(adj[i].get(v)))
				return true;
		}
		r[i] = false;
		return false;
	}

}
