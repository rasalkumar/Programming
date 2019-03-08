package flipkart;

/*Flipkart IIT Kanpur 2018
Given two vectors of length n representing the x and y 
coordinates of cartesian points, find the minimum possible area 
of a rectangle which can be formed using four distinct points 
which has sides parallel to the x & y axis.
If non rectangle can be formed, return -1.
1 <= n <= 1000
 * 
 * */

import java.util.*;
public class MinRectangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int x[] = new int[n];
		int y[] = new int[n];
		for(int i = 0 ; i < n ; i++ )
			x[i] = in.nextInt();
		for(int i = 0 ; i < n ; i++ )
			y[i] = in.nextInt();
		
		HashMap<Pair, HashSet<Integer>> map =new HashMap<>();
		for(int i = 0 ; i < n ; i++ )
		{
			for( int j = 0 ; j < i ; j++ )
			{
				if( x[i] == x[j] )
				{
					Pair p = new Pair( Math.min(y[i], y[j]), Math.max(y[i], y[j] ));
					
					if(!map.containsKey(p))
					{
						HashSet<Integer> set = new HashSet<>();
						set.add(x[i]);
						map.put(p,set);
					}
					else
					{
						map.get(p).add(x[i]);
					}
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for(Map.Entry<Pair, HashSet<Integer>> entry : map.entrySet())
		{
			int a = entry.getKey().y - entry.getKey().x;
			ArrayList<Integer> xs = new ArrayList<>(entry.getValue());
			for(int i = 1 ; i < xs.size() ; i++ )
			{
				ans = Math.min(ans, a * (xs.get(i) - xs.get(i-1)));
			}
		}
		System.out.println(ans < Integer.MAX_VALUE ? ans : -1);
		
	}
	static class Pair
	{
		int x,y;
		Pair(int x , int y)
		{
			this.x = x;
			this.y = y;
		}
		public boolean equals(Object obj)
		{
			if(!(obj instanceof Pair))
				return false;
			if(obj == this)
				return true;
			return this.x == ((Pair)obj).x && this.y == ((Pair)obj).y ;
		}
		public int hashCode()
		{
			int result = 0;
			result = 31 * x + y ;
			return result;
		}
	}

}
