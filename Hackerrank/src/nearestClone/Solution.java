package nearestClone;
import java.util.*;
public class Solution {
	static long max = 99999999;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		Graph g = new Graph(n);
		int[] from = new int[m];
		int[] to = new int[m];
		for(int i = 0 ; i < m ;i++)
		{
			from[i] = in.nextInt();
			to[i] = in.nextInt();
			g.addEdge(from[i] -1, to[i] - 1, 1);
			
		}
		int[] colors = new int[n];
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
		for(int i = 0 ; i < n ;i++)
		{
			colors[i] = in.nextInt();
			if(!map.containsKey(colors[i]-1))
			{
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(i);
				map.put(colors[i]-1,temp);
			}
			else
			{
				 map.get(colors[i]-1).add(i);
			}
		}
		int valId = in.nextInt();
		long min =  max;
		ArrayList<Integer> target = map.get(valId-1);
		if(target == null)
		{
			System.out.println("-1");
		}
		else{
		for(int i = 0 ; i < target.size() ; i++ )
		{
			min = Math.min( min , g.dijkstra(target.get(i),target) );
		}
		if(min >= max || min < 0)
			System.out.println("-1");
		else
			System.out.println(min);
	}}
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
		long dis;
		int index;
		Pair(long dis ,int index)
		{
			this.dis = dis;
			this.index = index;
		}
	}
	static class Graph
	{
		int v;
		LinkedList<Edge> adj[];
		Graph(int v)
		{
			this.v = v;
			adj = new LinkedList[v];
			for(int i = 0 ;i < v ; i++ )
				adj[i] = new LinkedList<>();
		}
		public void addEdge(int src, int dest,int weight)
		{
			Edge edge1 = new Edge(src,dest,weight);
			adj[src].add(edge1);
			
			Edge edge2 = new Edge(dest,src,weight);
			adj[dest].add(edge2);
		}
		public long dijkstra( int src, ArrayList<Integer> target )
		{
			boolean[] sptSet = new boolean[v];
			long[] distance = new long[v];
			for(int i = 0 ; i < v; i++ )
			{
				distance[i] = max;
			}
			distance[src] = 0;
			PriorityQueue<Pair> pq = new PriorityQueue<>(v, new Comparator<Pair>(){
				public int compare(Pair p1,Pair p2)
				{
					return (int)(p1.dis-p2.dis);
				}
			});
			pq.add(new Pair(distance[src],src));
			while(!pq.isEmpty())
			{
				Pair curr = pq.poll();
				if(sptSet[curr.index] == false)
					sptSet[curr.index] = true;
				LinkedList<Edge> link = adj[curr.index];
				for( Edge e : link )
				{
					int u = e.dest;
					if( !sptSet[u] && distance[curr.index] + e.weight < distance[u] )
					{
						distance[u] = distance[curr.index] + e.weight;
						pq.offer(new Pair(distance[u],u));
						
					}
				} 
			}
//			for(int i = 0 ; i < distance.length ; i++)
//			{
//				System.out.println(distance[i]);
//			}
			long min = max;
			//System.out.println(target);
			for(int i = 0 ; i < target.size() ;i++)
			{
				if(target.get(i) == src)
					continue;
				//System.out.println(distance[target.get(i)]);
				min = Math.min(min, distance[target.get(i)]);
			}
			
			//System.out.println(min);
			return min;
			////////////////////////////////////////////////////////
		}
	}
}
