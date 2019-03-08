package motherVertex;

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
		//System.out.println(v+" ");
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
	public int findMother()
	{
		boolean[] visited = new boolean[v];
		int lvertex=0;
		//Do a DFS Traversal and Find Last Vertex
		for(int i=0;i<v;i++)
		{
			if(visited[i]==false)
			{
				dfsUtil(i, visited);
				lvertex=i;
			}
		}
		// If there exist mother vertex (or vetices) in given
	    // graph, then v must be one (or one of them)
	 
	    // Now check if v is actually a mother vertex (or graph
	    // has a mother vertex).  We basically check if every vertex
	    // is reachable from v or not.
	 
	    // Reset all values in visited[] as false and do 
	    // DFS beginning from v to check if all vertices are
	    // reachable from it or not.
		Arrays.fill(visited, false);
		dfsUtil(lvertex, visited);
		for(int i=0;i<v;i++)
		{
			if(visited[i]==false)
			{
				return -1;
			}
		}
		return lvertex;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Graph g = new Graph(7);
		 
		 
		    g.addEdge(0, 1);
		    g.addEdge(0, 2);
		    g.addEdge(1, 3);
		    g.addEdge(4, 1);
		    g.addEdge(6, 4);
		    g.addEdge(5, 6);
		    g.addEdge(5, 2);
		    g.addEdge(6, 0);
	 
	        
	        int p=g.findMother();
	        System.out.println("Mother Vertex is "+p);

	}

}
