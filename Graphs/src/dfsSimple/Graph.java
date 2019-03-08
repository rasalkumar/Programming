package dfsSimple;

import java.util.*;

public class Graph {
	
	int v;
	LinkedList<Integer> adj[];

	public Graph(int V) {
		// TODO Auto-generated constructor stub
		v=V;
		adj=new LinkedList[V];
		for(int i=0;i<V;i++)
		{
			adj[i]=new LinkedList<Integer>();
		}
		
	}
	public void addEdge(int v,int w)
	{
		adj[v].addFirst(w);
	}
	public void dfsUtil(int v,boolean[] visited)
	{
		visited[v]=true;
		System.out.println(v+" ");
		Iterator<Integer> i = adj[v].listIterator();
		while(i.hasNext())
		{
			int n=i.next();
			if(!visited[n])
			{
			     dfsUtil(n, visited);
			}
		}
	}
	public void dfs()
	{
		boolean visited[]=new boolean[v];
		for(int i=0;i<v;i++)
		{
			if(visited[i]==false)
			{
			    dfsUtil(i,visited);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Graph g = new Graph(4);
		 
	        g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 2);
	        g.addEdge(2, 0);
	        g.addEdge(2, 3);
	        g.addEdge(3, 3);
	 
	        System.out.println("Following is Breadth First Traversal "+
	                           "(starting from vertex 2)");
	 
	        g.dfs();

	}

}