package dfs;
import java.util.*;
public class Graph {
	int v;
	LinkedList<Integer> adj[];

	Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	public void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
	public void dfs() {
		boolean visited[] = new boolean[v];
		for (int i = 0; i < v; i++) {
			if (visited[i] == false) {
				dfsUtil(visited, i);
			}
		}
	}
	public void dfsUtil(boolean[] visited, int s) {
		visited[s] = true;
		System.out.print(v + " ");
		ListIterator<Integer> itr = adj[s].listIterator();
		while (itr.hasNext()) {
			int t = itr.next();
			if (visited[t] == false) {
				dfsUtil(visited, s);
			}
		}
	}
//	public static void main(String args[])
//	{
//		Scanner in = new Scanner( System.in );
//		
//	}
}
