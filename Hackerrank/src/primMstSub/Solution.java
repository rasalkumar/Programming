package primMstSub;

import java.util.*;

public class Solution {
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int m = in.nextInt();
		int[] x = new int[m];
		int[] y = new int[m];
		int[] r = new int[m];
		int graph[][] = new int[n][n];
		for (int i = 0; i < m; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
			r[i] = in.nextInt();
			if(graph[x[i] - 1][y[i] - 1] == 0)
			{
				graph[x[i] - 1][y[i] - 1] = r[i];
				graph[y[i] - 1][x[i] - 1] = r[i];
			}else
			{
				graph[x[i] - 1][y[i] - 1] = Math.min( graph[x[i] - 1][y[i] - 1] , r[i] );
				graph[y[i] - 1][x[i] - 1] = graph[x[i] - 1][y[i] - 1];
			}
		}
		int src = in.nextInt();
		System.out.println(primMst(graph, src - 1));
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(graph[i][j] + " ");
//			}
//			System.out.println();
//		}
	}

	public static int primMst(int[][] graph, int src) {
		int[] parent = new int[n];
		int[] distance = new int[n];
		boolean mstSet[] = new boolean[n];
		for (int i = 0; i < n ; i++) {
			distance[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		distance[src] = 0;
		parent[src] = -1;
		for (int count = 0; count < n - 1; count++) {
			int u = minKey(distance, mstSet);
			mstSet[u] = true;
			for (int v = 0; v < n; v++) {
				if (!mstSet[v] && graph[u][v] != 0 && graph[u][v] < distance[v]) {
					distance[v] = graph[u][v];
					parent[v] = u;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (parent[i] != -1) {
				//System.out.println(parent[i] + 1 + " - " + (int) (i + 1) + " - " + graph[i][parent[i]]);
				count += graph[i][parent[i]];
			}
		}
		return count;
	}

	public static int minKey(int[] distance, boolean[] mstSet) {
		int minIndex = -1;
		int minKey = Integer.MAX_VALUE;
		for (int v = 0; v < n; v++) {
			if (mstSet[v] == false && distance[v] < minKey) {
				minKey = distance[v];
				minIndex = v;
			}
		}
		return minIndex;
	}

}
