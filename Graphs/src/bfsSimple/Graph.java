package bfsSimple;
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
	public void bfs(int s)
	{
		boolean visited[]=new boolean[v];
		LinkedList<Integer> queue = new LinkedList<>();
		
		visited[s]=true;
		queue.add(s);
		while(queue.size()!=0)
		{
			s=queue.poll();
			System.out.println(s+" ");
			
			Iterator<Integer> i=adj[s].listIterator();
			while(i.hasNext())
			{
				int n=i.next();
				if(visited[n]!=true)
				{
					visited[n]=true;
				    queue.add(n);
				}
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
	 
	        g.bfs(2);

	}

}
