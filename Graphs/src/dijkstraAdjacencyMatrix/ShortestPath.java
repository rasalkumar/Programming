package dijkstraAdjacencyMatrix;

public class ShortestPath {
	static final int V=9;
	//sptSet means Shortest Path Set
    int minDistance(int distance[], boolean[] sptSet)
    {
    	int min=Integer.MAX_VALUE;
    	int min_index=-1;
    	for(int i=0 ; i < V ; i++)
    	{
    		if( sptSet[i] == false && distance[i] < min)
    		{
    			min = distance[i];
    			min_index=i;
    		}
    	}
    	return min_index;
    }
    void dijksta(int graph[][],int src)
    {
    	int distance[]=new int[V];
    	boolean sptSet[]=new boolean[V];
    	for(int i = 0 ; i < V ; i++)
    	{
    		distance[i] = Integer.MAX_VALUE;
    		sptSet[i] = false;
    	}
    	
    	distance[src] = 0;
    	for(int count = 0; count < V-1; count++)
    	{
    		int u = minDistance(distance, sptSet);
    		sptSet[u]=true;
    		for(int v=0;v<V;v++)
    		{
    		    if(graph[u][v]!=0 && sptSet[v]==false && distance[u]+graph[u][v]<distance[v])
    		    {
    		    	distance[v]=distance[u]+graph[u][v];
    		    }
    	    }
    	}
    	printSolution(distance, V);
    }
    void printSolution(int distance[], int n)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i+" tt "+distance[i]);
    }
    public static void main (String[] args)
    {
        /* Let us create the example graph discussed above */
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
        ShortestPath t = new ShortestPath();
        t.dijksta(graph, 0);
    }
}
