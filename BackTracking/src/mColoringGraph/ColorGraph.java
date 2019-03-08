package mColoringGraph;
import java.util.*;
public class ColorGraph {
	static int V;
	static int colors[];
	static int m;
	static int graph[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		V = in.nextInt();
		m = in.nextInt();
		graph = new int[V][V];
		colors = new int[V];
		for(int i = 0 ; i < V ; i++ )
		{
			for(int j = 0 ; j < V ; j++ )
			{
				graph[i][j] = in.nextInt();
			}
		}
		for(int i =0 ; i < V ; i++ )
			colors[i] = 0 ;
		if(!helper(0))
			System.out.println("false");
		else
		{
			for(int i = 0; i < colors.length ; i++ )
				System.out.println(colors[i]);
			System.out.println(helper(0));
		}
	}
	public static boolean helper(int v)
	{
		if(v == V)
			return true;
		for(int c = 1 ; c <= m ; c++ )
		{
			if(isSafe(v,c))
			{
				colors[v] = c;
				if(helper(v+1))
					return true;
			}
			colors[v] = 0 ;
		}
		return false;
	}
	public static boolean isSafe(int v,int c)
	{
		for(int i = 0 ; i < colors.length ; i++ )
		{
			if (graph[v][i] == 1 && c == colors[i])
				return false;
		}
		return true;
	}

}
