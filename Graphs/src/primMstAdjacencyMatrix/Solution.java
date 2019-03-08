package primMstAdjacencyMatrix;
//import java.util.*;

public class Solution {

	private static final int V = 5;
	// Function to find the vertex with minimum key value
	// from the set of vertices not yet included in the MST

	int minKey(int key[], Boolean mstSet[]) {
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		for (int v = 0; v < V; v++) {
			if (mstSet[v] == false && key[v] < min) {
				min_index = v;
				min = key[v];
			}
		}
		return min_index;
	}

	// Function for primMST suing adjacency matrix representation
	void primMST(int graph[][]) {
		// Array to store constructed MST
		int parent[] = new int[V];

		// Key values used to pick minimum weight edge in cut
		int key[] = new int[V];

		// To represent set of Vertices not yet included in MST
		Boolean mstSet[] = new Boolean[V];

		// Initialize all the keys as Infinite
		for (int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		// Always include first vertex in MST
		// Make Key 0 so that this vertex is picked as First Vertex
		key[0] = 0;
		parent[0] = -1; // First Node is always root of MST
		for (int count = 0; count < V - 1; count++) {
			// Pick the minimum key vertex from the set of vertices not yet
			// included in the mst
			int u = minKey(key, mstSet);

			// Add the picked vertex to the MST set
			mstSet[u] = true;

			// Update key value and parent index of the adjacent
			// vertices of the picked vertex. Consider only those vertices which
			// are
			// not yet included in the MST
			for (int v = 0; v < V; v++) {
				if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
					key[v] = graph[u][v];
					parent[v] = u;
				}
			}
		}
		// print the constructed MST
		printMST(parent, V, graph);

	}

	private void printMST(int[] parent, int v2, int[][] graph) {
		// TODO Auto-generated method stub
		System.out.println("Edge   Weight");
		for (int i = 1; i < V; i++) {
			System.out.println(parent[i] + " - " + i + "   " + graph[i][parent[i]]);
		}
	}

	public static void main(String[] args) {
		/*
		 * Let us create the following graph 2 3 (0)--(1)--(2) | / \ | 6| 8/ \5
		 * |7 | / \ | (3)-------(4) 9
		 */
		Solution t = new Solution();
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
				{ 0, 5, 7, 9, 0 }, };

		// Print the solution
		t.primMST(graph);
	}
}
