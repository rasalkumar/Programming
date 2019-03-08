package validPath;

import java.util.*;
public class Solution {
	int[] dx = { -1 , -1 , -1 , 0 , 0 , 1 , 1 , 1 };
    int[] dy = { 1 , 0 , -1 , 1 , -1  , 1 , 0 , -1 };
    public String solve(int x, int y, int N, int R, ArrayList<Integer> E, ArrayList<Integer> F) {
      boolean answer = validPath(x, y , N , R , E, F);
      if(answer==true)
      {
          return "YES";
      }
      return "NO";  
    }
    public boolean validPath(int x, int y, int N, int R, ArrayList<Integer> E, ArrayList<Integer> F)
    {
    	boolean visited[][] = new boolean[x+1][y+1];
    	Queue<Point> q = new LinkedList<Point>();
    	q.add(new Point(0,0));
    	while( q.size() != 0 )
    	{
    		Point curr = q.poll();
    		visited[curr.x][curr.y] = true;
    		if(curr.x == x && curr.y==y)
    		{
    			return true;
    		}
    		else
    		{
    			for(int  i = 0 ; i < 8 ; i++ )
    			{
    				if ( ( !visited[curr.x+dx[i]][curr.y+dy[i]] ) && isSafe( curr.x+dx[i], curr.y+dy[i], N, R, E, F, x, y) )
    				{
    					q.add(new Point(curr.x+dx[i], curr.y+dy[i]));
    				}
    			}
    		}
    	}
    	return false;
    }
    public boolean isSafe(int x, int y , int N ,int R, ArrayList<Integer> E , ArrayList<Integer> F, int xDest, int yDest)
    {
    	if(x < 0 || x > xDest || y < 0 || y > yDest)
    	{
    		return false;
    	}
    	for(int  i =  0 ; i < N ; i++)
    	{
    		if( (Math.sqrt( Math.pow(E.get(i) - x , 2) + Math.pow(F.get(i) - y , 2) ) <= R) )
            {
            	return false;
            }
    	}
    	return true;
    }
    class Point
    {
    	int x , y ;
    	Point(int x , int y)
    	{
    		this.x = x;
    		this.y = y;
    	}
    }
}
