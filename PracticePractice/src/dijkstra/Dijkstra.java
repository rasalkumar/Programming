package dijkstra;

public class Dijkstra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static int V = 9;
	public static void dijkstra(int[][] graph,int src)
	{
		int dis[]= new int[V];
		boolean sptSet[] = new boolean[V];
		for(int i = 0 ; i < V ;i++)
		{
			dis[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		dis[0] = 0 ;
		for(int count = 0 ; count < V - 1 ; count++)
		{
			int u = minKey(dis,sptSet);
			sptSet[u] = true;
			for(int v = 0 ; v < V ; v++ )
			{
				if(sptSet[v] == false && graph[u][v] != 0 && 
						dis[u]!= Integer.MAX_VALUE && dis[u] +graph[u][v] < dis[v])
				{
					dis[v] = dis[u] +graph[u][v];
				}
			}
		}
	}
	public static void print(int dis[])
	{
		for(int i = 0 ; i < V ;i++)
		{
			System.out.println(i+ " " + dis[i]);
		}
	}
	public static int minKey(int[] dis, boolean[] sptSet )
	{
		int minIndex = -1;
		int minKey = Integer.MAX_VALUE;
		for(int v = 0 ; v < V ; v++)
		{
			if(!sptSet[v] && dis[v] < minKey)
			{
				minKey = dis[v];
				minIndex = v ;
			}
		}
		return minIndex;
	} 

}
