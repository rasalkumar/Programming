package samsung;
import java.util.*;
public class Bipartite {
static int V;
static boolean visited[];
static int graph[][];
static int colors[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- >  0 )
		{
			V = in.nextInt();
			graph = new int[V][V];
			int e = in.nextInt();
			for(int i = 0 ; i < e ; i++ )
			{
				int u = in.nextInt();
				int w = in.nextInt();
				graph[u-1][w-1] = 1;
				graph[w-1][u-1] = 1;
			}
			colors = new int[V];
			for(int i = 0 ; i < V ; i++ )
				colors[i] = -1 ;
			ArrayList ans = bipartite(0);
			for(int i = 0 ;i < ans.size() ; i++ )
			{
				System.out.print(ans.get(i) + " ");
			}
			System.out.println();
		}
	
	}
	public static ArrayList bipartite(int src)
	{
		Queue q = new Queue();
		q.add(src);
		colors[src] = 1;
		while( !q.isEmpty() )
		{
			int u = q.poll();
			if(graph[u][u] == 1)
			{
				ArrayList res = new ArrayList();
				res.add(-1);
				return res;
			}
			for(int v = 0 ; v < V ;v++)
			{
				if(graph[u][v] == 1  && colors[v] == -1)
				{
					colors[v] = 1- colors[u];
					q.add(v);
				}
				else if(graph[u][v] != 0 && colors[v] == colors[u] )
				{
					ArrayList res = new ArrayList();
					res.add(-1);
					return res;
				}
			}
		}
		ArrayList ans = new ArrayList();
		for( int i = 0 ; i < V ; i++ )
		{
			if( colors[i] == 0 )
			{
				ans.add(i + 1);
			}
		}
		return ans;
		
	}
	static class ArrayList
	{
		int a[];
		int s;
		ArrayList()
		{
			a = new int[1000000];
			s = 0;
		}
		public void add(int element)
		{
			a[s++] = element;
		}
		public int get(int index)
		{
			return a[index];
		}
		public int size()
		{
			return s;
		}
	}
	static class Queue
	{
		int front,rear;
		int a[];
		Queue()
		{
			a = new int[1000000];
			front = rear = 0;
		}
		public void add(int element)
		{
			a[rear++] = element;
		}
		public int poll()
		{
			return a[front++];
		}
		public boolean isEmpty()
		{
			return front >= rear;
		}
	}

}
