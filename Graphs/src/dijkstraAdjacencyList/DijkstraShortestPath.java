package dijkstraAdjacencyList;

import java.util.*;

class DijkstraShortestPath {

	class Graph {

		class Edge {
			int u;
			int v;
			int w;

			Edge(int u, int v, int w) {
				this.u = u;
				this.v = v;
				this.w = w;
			}

		};

		ArrayList<ArrayList<Edge>> adjList;
		private int V;
		private int E;

		public void initialize(int V, int E) {
			this.V = V;
			this.E = E;
			adjList = new ArrayList<ArrayList<Edge>>();
			for (int i = 0; i < V; i++) {
				adjList.add(new ArrayList<Edge>());
			}
		}

		public void addEdgeBi(int u, int v, int w) {
			ArrayList<Edge> al = adjList.get(u - 1);
			al.add(new Edge(u - 1, v - 1, w));
			al = adjList.get(v - 1);
			al.add(new Edge(v - 1, u - 1, w));
		}

		// DSP Related
		class KeyValue implements Comparable<KeyValue> {
			int value;
			int key;

			KeyValue(int v, int k) {
				this.key = k;
				this.value = v;
			}

			public int compareTo(KeyValue o) {
				if (o.key < this.key)
					return 1;
				else if (o.key > this.key)
					return -1;
				else
					return 0;
			}

			@Override
			public boolean equals(Object obj) {
				KeyValue kv = (KeyValue) obj;
				if (kv.value == this.value)
					return true;
				else
					return false;
			}
		}

		public int[] DSP(int src) {
			src--;
			PriorityQueue<KeyValue> minHeap = new PriorityQueue<KeyValue>();
			int shortestPath[] = new int[V];
			Arrays.fill(shortestPath, 0);
			minHeap.add(new KeyValue(0, 0));
			int[] key = new int[V];
			boolean[] MSTSet = new boolean[V];
			Arrays.fill(key, -1);
			key[0] = 0;
			while (!minHeap.isEmpty()) {
				KeyValue next = minHeap.poll();
				int curV = next.value;
				int curK = next.key;
				System.out.println("Value " + curV + " Key " + curK);
				MSTSet[curV] = true;
				shortestPath[curV] = curK;
				ArrayList<Edge> al = adjList.get(curV);
				for (Edge e : al) {
					if (!MSTSet[e.v]) {
						if ((key[e.v] != -1) && (key[e.v] > (curK + e.w)) && minHeap.contains(new KeyValue(e.v, 0))) {
							if (minHeap.remove(new KeyValue(e.v, 0)))
								System.out.println("Removed !");
							minHeap.add(new KeyValue(e.v, curK + e.w));
							System.out.println("Adding : " + e.v + " " + (curK + e.w));
							key[e.v] = curK + e.w;
						} else if (key[e.v] == -1) {
							key[e.v] = curK + e.w;
							minHeap.add(new KeyValue(e.v, curK + e.w));
							System.out.println("Adding : " + e.v + " " + (curK + e.w));
						}
					}
				}
			}
			return shortestPath;
		}

	}

	public static void main(String[] args) {
		DijkstraShortestPath dsp = new DijkstraShortestPath();
		Graph graph = dsp.new Graph();
		graph.initialize(9, 0);
		graph.addEdgeBi(0 + 1, 1 + 1, 4);
		graph.addEdgeBi(0 + 1, 7 + 1, 8);
		graph.addEdgeBi(1 + 1, 2 + 1, 8);
		graph.addEdgeBi(1 + 1, 7 + 1, 11);
		graph.addEdgeBi(2 + 1, 3 + 1, 7);
		graph.addEdgeBi(2 + 1, 8 + 1, 2);
		graph.addEdgeBi(2 + 1, 5 + 1, 4);
		graph.addEdgeBi(3 + 1, 4 + 1, 9);
		graph.addEdgeBi(3 + 1, 5 + 1, 14);
		graph.addEdgeBi(4 + 1, 5 + 1, 10);
		graph.addEdgeBi(5 + 1, 6 + 1, 2);
		graph.addEdgeBi(6 + 1, 7 + 1, 1);
		graph.addEdgeBi(6 + 1, 8 + 1, 6);
		graph.addEdgeBi(7 + 1, 8 + 1, 7);
		int[] arr = graph.DSP(1);
		for (int i = 0; i < arr.length; i++)
			System.out.println(i + " " + arr[i]);
	}
}
