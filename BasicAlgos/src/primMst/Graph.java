package primMst;

public class Graph {

	public static int V = 9 ;
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
		 primMst(graph);

	}
	public static int minKey(int[] key, boolean[] mstSet)
	{
		int minIndex = -1;
		int min = Integer.MAX_VALUE;
		for(int v = 0 ; v < V ; v++ )
		{
			if( mstSet[v] == false && key[v] < min )
			{
				min = key[v];
				minIndex = v;
			}
		}
		return minIndex;
	}
	public static void primMst(int[][] graph)
	{
		int[] key = new int[V];
		boolean[] mstSet = new boolean[V];
		int parent[] = new int[V];
		for(int v = 0 ; v < V; v++ )
		{
			key[v] = Integer.MAX_VALUE;
			mstSet[v] = false;
		}
		parent[0] = -1;
		key[0] = 0;
		for(int count = 0 ; count < V - 1 ; count++ )
		{
			int u = minKey(key, mstSet);
			mstSet[u] = true;
			for(int v = 0 ;v < V ; v++ )
			{
				if(graph[u][v] != 0 && mstSet[v] == false  && graph[u][v] < key[v]  )
				{
					key[v] = graph[u][v];
					parent[v] = u;
				}
			}
		}
		printPrimMST(parent,graph);
	}
	static void printPrimMST(int[] parent, int[][] graph)
	{
		System.out.println("EDGE  WEIGHT");
		for(int i = 1 ; i < V ; i++ )
		{
			System.out.println(parent[i] + " - "+ i + "   "  + graph[i][parent[i]]);
		}
	}
}
