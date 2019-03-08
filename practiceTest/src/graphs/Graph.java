package graphs;
import java.util.*;
public class Graph {
	static Scanner in = new Scanner(System.in);
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		n = in.nextInt();
	}
	public static void jumping()
	{
		for(int i = 1 ; i <= 9 && i <= n ; i++ )
		{
			bfs(n,i);
		}
	}
	public static void bfs(int x , int i)
	{
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		while(!q.isEmpty())
		{
			i = q.poll();
			if(i <= x)
			{
				int last_dig = i % 10 ;
				if( last_dig == 0 )
					q.add((i * 10) + (last_dig + 1));
				else if( last_dig == 9 )
					q.add((i * 10) + (last_dig - 1));
				else
				{
					q.add((i * 10) + (last_dig - 1));
					q.add((i * 10) + (last_dig + 1));
				}
			}
		}
	}
}
