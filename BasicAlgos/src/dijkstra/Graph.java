package dijkstra;

public class Graph {
	public static int V = 9;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
             {4, 0, 8, 0, 0, 0, 0, 11, 0},
             {0, 8, 0, 7, 0, 4, 0, 0, 2},
             {0, 0, 7, 0, 9, 14, 0, 0, 0},
             {0, 0, 0, 9, 0, 10, 0, 0, 0},
             {0, 0, 4, 14, 10, 0, 2, 0, 0},
             {0, 0, 0, 0, 0, 2, 0, 1, 6},
             {8, 11, 0, 0, 0, 0, 1, 0, 7},
             {0, 0, 2, 0, 0, 0, 6, 7, 0}
            };
		 dijkstra(graph);

	}
	public static int minKey(boolean[] sptSet, int[] distance) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int v = 0; v < V; v++) {
			if (sptSet[v] == false && distance[v] < min) {
				min = distance[v];
				minIndex = v;
			}
		}
		return minIndex;
	}

	public static void dijkstra(int[][] graph) {
		int distance[] = new int[V];
		boolean sptSet[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			distance[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		distance[0] = 0;
		for (int count = 0; count < V; count++) {
			int u = minKey(sptSet, distance);
			sptSet[u] = true;
			for (int v = 0; v < V; v++) {
				if (graph[u][v] != 0 && sptSet[v] == false && distance[u] + graph[u][v] < distance[v]) {
					distance[v] = distance[u] + graph[u][v];
				}
			}
		}
		
	}

}
