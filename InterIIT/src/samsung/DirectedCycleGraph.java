package samsung;
import java.util.Scanner;
public class DirectedCycleGraph {
static int V;
static ArrayList[] adj; 
static boolean[] recStack;
static boolean[] visited;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while ( t-- > 0 )
		{
			V = in.nextInt();
			adj = new ArrayList[V];
			for(int i = 0 ; i < V ; i++ )
			{
				adj[i] = new ArrayList();
			}
			int e = in.nextInt();
			for(int i = 0 ; i < e ; i++ )
			{
				int u = in.nextInt();
				int w = in.nextInt();
				adj[u-1].add(w-1);
			}
			directedDfs();
		}

	}
	static ArrayList res;
	public static void directedDfs()
	{
		recStack = new boolean[V];
		visited = new boolean[V];
		res = new ArrayList();
		int flag = 0 ;
		for(int i = 0 ; i < V ; i++ )
		{
			if( !visited[i] && cycle(i) )
			{
				flag = 1;
				int curr = res.get(res.size() -1);
				int[] ans = new int[V+1];
				ans[curr] = curr;
				for(int j = res.size() - 2 ; j >= 0 ;j--)
				{
					if(res.get(j) != curr)
					{
						ans[res.get(j)] = res.get(j);
					}
					else
						break;
				}
				for(int j = 1 ; j < V + 1 ;j++ )
				{
					if(ans[j] != 0 )
						System.out.print(ans[j] +" ");
				}
				flag = 1;
				break;
			}
		}
		if(flag == 0)
		{
			System.out.println("No Cycle");
		}
		
		
	}
	public static boolean cycle(int i)
	{
		if(recStack[i])
		{
			res.add(i + 1);
			return true;
		}
		if(visited[i])
			return false;
		visited[i] = true;
		recStack[i] = true;
		for(int j = 0 ; j < adj[i].size(); j++)
		{
			int c = adj[i].get(j);
			res.add(i + 1);
			if(cycle(c))
			{
				return true;
			}
		}
		recStack[i] = false;
		res.remove(res.size() - 1);
		return false;
	}
	static class ArrayList
	{
		int[] a;
		int s;
		ArrayList()
		{
			a = new int[100000];
			//s = 0 ;
		}
		public void add(int x)
		{
			a[s++] = x;
		}
		public int get(int index)
		{
			return a[index];
		}
		public int size()
		{
			return s;
		}
		public void remove(int index)
		{
			while(index < s - 1)
			{
				a[index] = a[index + 1];
				index++;
			}
			s--;
		}
	}

}
