package bipartite;
import java.util.Scanner;
public class BipartiteGraph {

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of vertices");
		int v = in.nextInt();
		int graph[][] = new int[v][v];
		for( int i = 0 ; i < v ; i++ )
		{
			for( int j = 0 ; j < v ; j++ )
			{
				graph[i][j] = 0;
			}
		}
		System.out.println("Enter number of Edges");
		int e = in.nextInt(); 
		for(int i = 0 ; i < e ; i++ )
		{
			int x = in.nextInt();
			int y = in.nextInt();
			graph[x-1][y-1] = 1;
			graph[y-1][x-1] = 1;
		}
		ArrayList a = bipartite(graph,0,v);
	//	System.out.println("******");
		for(int i = 0 ; i < a.size() ; i++ )
		{
			System.out.print(a.get(i)+ " ");
		}
	}
	public static ArrayList bipartite(int[][] graph, int src,int x)
	{
		ArrayList ans1 = new ArrayList();
		ArrayList ans2 = new ArrayList();
		ArrayList q = new ArrayList();
		int color[] = new int[x];
		for(int i = 0 ; i < x ; i++ )
		{
			color[i] = -1 ;
		}
		q.add(src);
		color[src] = 1;
		while( q.size() != 0 )
		{
			int u = q.poll();
			if( graph[u][u] == 1 )
			{
				ArrayList res =new ArrayList();
				res.add(-1);
				return res;
			}
			for(int v = 0 ; v < x ; v++ )
			{
				if( graph[u][v]==1  && color[v] == -1)
				{
					color[v] = 1-color[u];
					//System.out.println(q.size());
					q.add(v);
				}
				else if( graph[u][v] == 1 && color[u]==color[v])
				{
					ArrayList res =new ArrayList();
					res.add(-1);
					return res;
				}
			}
		}
		for(int i = 0 ; i < color.length;i++)
		{
			if( color[i] == 0 )
			{
				ans1.add(i);
			}else
			{
				ans2.add(i);
			}
		}
		return ans1;
	}
	static class ArrayList
	{
		int[] a;
		int actSize = 0 ;
		ArrayList()
		{
			a = new int[100];
		}
		public int get(int index)
		{
			if(index < actSize)
			{
				return a[index];
			}
			else
			{
				throw new ArrayIndexOutOfBoundsException();
			}
		}
		public void add(int x)
		{
			a[actSize++] = x;
		}
		public int size()
		{
			return actSize;
		}
		public int poll()
		{
			if(actSize != 0)
			{
				int temp = a[actSize-1];
				a[actSize-1] = 0;
				actSize--;
				return temp;
			}
			else
			{
				throw new ArrayIndexOutOfBoundsException();
			}
		}
		
	}
	
}
