package dijkstraPQ;

import java.util.*;

public class Dijkstra {
	static class Edge {
		int src, dest, weight;

		Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	}

	static class Pair {
		int dis, index;

		Pair(int x, int y) {
			dis = x;
			index = y;
		}
	}

	static class Graph {
		int v;
		LinkedList<Edge> adj[];

		Graph(int v) {
			this.v = v;
			adj = new LinkedList[v];
			for (int i = 0; i < v; i++) {
				adj[i] = new LinkedList<>();
			}
		}

		public void addEdge(int src, int dest, int weight) {
			Edge edge1 = new Edge(src, dest, weight);
			adj[src].add(edge1);
			Edge edge2 = new Edge(src, dest, weight);
			adj[dest].add(edge2);
		}

		public void dijkstra(int src) {
			boolean[] sptSet = new boolean[v];
			int[] distance = new int[v];
			for (int i = 0; i < v; i++)
				distance[i] = Integer.MAX_VALUE;
			distance[src] = 0;
			PriorityQueue<Pair> pq = new PriorityQueue<>(v, new Comparator<Pair>() {
				public int compare(Pair p1, Pair p2) {
					return p1.dis - p2.dis;
				}
			});
			pq.add(new Pair(distance[src], src));
			while (!pq.isEmpty())
			{
				Pair curr = pq.poll();
				if (sptSet[curr.index] == false) {
					sptSet[curr.index] = true;
				}
				LinkedList<Edge> spt = adj[curr.index];
				for (Edge e : spt) {
					int u = e.dest;
					if(!sptSet[u] && distance[curr.index] + e.weight < distance[u])
					{
						distance[u] = distance[curr.index] + e.weight;
						pq.add(new Pair(distance[u],u));
					}
					
				}
			}
			printDijkstra(distance,src);
		}
		public void printDijkstra(int[] distance, int src){
            System.out.println("Dijkstra Algorithm: (Adjacency List + Priority Queue)");
            for (int i = 0; i <v ; i++) {
                System.out.println("Source Vertex: " + src + " to vertex " +   + i +
                        " distance: " + distance[i]);
            }
        }
	}

	public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        graph.dijkstra(0);
    }

}
