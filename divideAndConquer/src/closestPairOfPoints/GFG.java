package closestPairOfPoints;

//Incorrect Difficult by DIVIDE AND CONQUER. USE BRUTE FORCe, EASY WAY.
import java.util.*;
public class GFG {
	static int n;
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			n = in.nextInt();
			Point[] points = new Point[n];
			for(int i = 0 ; i < n ; i++ )
				points[i] = new Point(in.nextInt(),in.nextInt());
			Arrays.sort(points);
			closestPoints(points);
		}
	}
	public static double closestPoints(Point[] points)
	{
		if( n <= 2 )
			return distance(points[0],points[1]);
		int mid = n/2;
		
		Point[] left = new Point[mid];
		Point[] right = new Point[n-mid];
		
		for(int i = 0 ; i < mid ;i++)
			left[i] = new Point(points[i].x,points[i].y);
		for(int i = mid ; i < n ; i++)
			right[i] = new Point(points[i].x,points[i].y);
		double dl = closestPoints(left);
		double dr = closestPoints(right);
		double d = Math.min(dl, dr);
		
		return 0;
	}
	static double distance(Point p1, Point p2)
	{
		return Math.sqrt((((p1.x- p2.x)*(p1.x- p2.x)) +((p1.y - p2.y)*(p1.y - p2.y))));
	}
	static class Point implements Comparable<Point>
	{
		int x; 
		int y;
		Point(int x,int y)
		{
			this.x = x;
			this.y = y;
		}
		public int compareTo(Point other)
		{
			return this.x - other.x;
		}
	}

}
