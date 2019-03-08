package floydWarshall;

public class Graph {

	public static int v = 4;

	public void floydWarshal(int[][] graph) {
		int distance[][] = new int[v][v];
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				distance[i][j] = graph[i][j];
			}
		}
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				for (int k = 0; k < v; k++) {
					if (distance[i][k] + distance[k][j] < distance[i][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}
		for (int i=0; i < v; ++i)
        {
            for (int j=0; j < v; ++j)
            {
                if (distance[i][j]==Integer.MAX_VALUE)
                    System.out.print("INF ");
                else
                    System.out.print(distance[i][j]+"   ");
            }
            System.out.println();
        }
	}
	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	//
	// }

}
