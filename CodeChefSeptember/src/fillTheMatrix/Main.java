package fillTheMatrix;
import java.util.*;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;
import java.util.HashMap;

/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author Rasal
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		FillTheMatrix solver = new FillTheMatrix();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}

	static class FillTheMatrix {
		// public static final MAXM=20005;
		public void solve(int testNumber, Scanner in, PrintWriter out) {
			int N=in.nextInt();
			int Q=in.nextInt();
			Graph g1=new Graph(N);
			
			for(int i=1;i<=N;i++)
			{
				int p=in.nextInt();
				int q=in.nextInt();
				int r=in.nextInt();
				g1.addEdge(p, q, r);
	
			}
		}

		class Pair {
			int i;
			int j;

			Pair(int i, int j) {
				this.i = i;
				this.j = j;
			}
			public int hashCode(){
				//System.out.println("In hashcode");
				int hashcode = 0;
				hashcode = j*20;
				hashcode += String.valueOf(i).hashCode();
				return hashcode;
			}
			
			public boolean equals(Object obj){
			//	System.out.println("In equals");
				if (obj instanceof Pair) {
					Pair pp = (Pair) obj;
					return (pp.i==(this.i) && pp.j == this.j);
				} else {
					return false;
				}
			}
			
			public int getI() {
				return i;
			}
			public void setI(int item) {
				this.i = item;
			}
			public int getJ() {
				return j;
			}
			public void setPrice(int price) {
				this.j = price;
			}
			
			public String toString(){
				return "item: "+i+"  price: "+j;
			}
		}
		class Graph
		{
			private int V;   // No. of vertices
		    private LinkedList<Integer> adj[]; // Adjacency List Represntation
	        HashMap<Pair,Integer> map= new HashMap<Pair,Integer>();	 
		    // Constructor
		    Graph(int v) {
		        V = v;
		        adj = new LinkedList[v];
		        for(int i=0; i<v; ++i)
		            adj[i] = new LinkedList();
		    }
		 
		    // Function to add an edge into the graph
		    void addEdge(int v,int w,int weight) {
		    	map.put(new Pair(v,w),weight);
		        adj[v].add(w);
		        adj[w].add(v);
		    }
		 
		    // A recursive function that uses visited[] and parent to detect
		    // cycle in subgraph reachable from vertex v.
		    Boolean isCyclicUtil(int v, Boolean visited[], int parent)
		    {
		        // Mark the current node as visited
		        visited[v] = true;
		        Integer i;
		 
		        // Recur for all the vertices adjacent to this vertex
		        Iterator<Integer> it = adj[v].iterator();
		        while (it.hasNext())
		        {
		            i = it.next();
		 
		            // If an adjacent is not visited, then recur for that
		            // adjacent
		            if (!visited[i])
		            {
		                if (isCyclicUtil(i, visited, v))
		                    return true;
		            }
		 
		            // If an adjacent is visited and not parent of current
		            // vertex, then there is a cycle.
		            else if (i != parent)
		                return true;
		        }
		        return false;
		    }
		 
		    // Returns true if the graph contains a cycle, else false.
		    Boolean isCyclic()
		    {
		        // Mark all the vertices as not visited and not part of
		        // recursion stack
		        Boolean visited[] = new Boolean[V];
		        for (int i = 0; i < V; i++)
		            visited[i] = false;
		 
		        // Call the recursive helper function to detect cycle in
		        // different DFS trees
		        for (int u = 0; u < V; u++)
		            if (!visited[u]) // Don't recur for u if already visited
		                if (isCyclicUtil(u, visited, -1))
		                    return true;
		 
		        return false;
		    }
			
		}
	}
}