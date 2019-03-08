package bfs;
import java.util.*;
public class Graph {
	int v;
	LinkedList<Integer> adj[];  
    Graph(int v)
    {
    	this.v = v;
    	adj = new LinkedList[v];
    	for(int i = 0 ; i < v ; i++ )
    	{
    		adj[i] = new LinkedList<>();
    	}
    }
    public void addEdge( int u , int v )
    {
    	adj[u].add(v);
    }
    public void bfs(int s)
    {
    	boolean visited[] = new boolean[v];
    	LinkedList<Integer> queue = new LinkedList<>();
    	queue.add(s);
    	while(queue.size() != 0)
    	{
    		int v = queue.poll();
    		ListIterator<Integer> itr = adj[v].listIterator();
    		while(itr.hasNext())
    		{
    			int p = itr.next();
    			if( visited[p] == false )
    			{
    				visited[p] = true;
    				queue.add(p);
    			}
    		}	
    	}
    }
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
//public class Graph
//{
//	int V ;
//	LinkedList<Integer> adj[];
//	Graph(int v)
//	{
//		this.V = v;
//		adj = new LinkedList[v];
//		for(int i = 0 ;i < v ; i++ )
//			adj[i] = new LinkedList<>();
//	}
//	public void addEdge(int u ,int v)
//	{
//		adj[u].add(v);
//	}
//	public void bfs(int s)
//	{
//		boolean visited[] = new boolean[V];
//		Queue<Integer> queue = new LinkedList<>();
//		queue.add(s);
//		visited[s] = true;
//		while( queue.size() != 0 )
//		{
//			int v = queue.poll();
//			ListIterator<Integer> itr = adj[v].listIterator();
//			while(itr.hasNext())
//			{
//				int p = itr.next();
//				if(visited[p] == false)
//				{
//					visited[p] = true;
//					queue.add(p);
//				}
//			}
//		}
//	}
//	public void dfs()
//	{
//		boolean visited[] = new boolean[V];
//		for(int i = 0 ; i < V ; i++ )
//		{
//			dfsUtil(visited,i);
//		}
//	}
//	public void dfsUtil(boolean[] visited, int v)
//	{
//		visited[v] = true;
//		ListIterator<Integer> itr = adj[v].listIterator();
//		while(itr.hasNext())
//		{
//			int i = itr.next();
//			dfsUtil(visited,i);
//		}
//	}
//}