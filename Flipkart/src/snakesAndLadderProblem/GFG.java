package snakesAndLadderProblem;
import java.util.*;
public class GFG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			
			int a[] = new int[n];
			int b[] = new int[n];
			for(int i = 0 ; i < n ;i++)
			{
				a[i] = in.nextInt();
				b[i] = in.nextInt();
			}
		}
	}
    public static int bfs(int source)
    {
    	Queue<Integer> queue = new LinkedList<Integer>();
    	int dist[] = new int[40];
    	boolean vis[] = new boolean[40];
    	while(!queue.isEmpty())
    	{
    		queue.poll();
    	}
    	queue.add(source);
    	dist[source] = 0 ;
    	vis[source] = true;
    	while( !queue.isEmpty() )
    	{
    		int curr_node = queue.poll();
    		for( int  i = 1 ; i <= 6 ; i++ )
    		{
    			
    		}
    	}
    	return 0;
    }
}
