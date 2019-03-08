package objectHashMapTest;
import java.util.*;
public class TestHashMapObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		Point[] point1 = new Point[n];
		ArrayList<Point> point2 = new ArrayList<>();
		for(int i = 0 ; i < n ; i++)
		{
			x[i] = in.nextInt();
			y[i] = in.nextInt();
			point1[i] = new Point( x[i] , y[i] );
			point2.add( new Point( x[i] , y[i] ));
		}
		HashMap<Point,Integer> map = new HashMap<>();
		HashSet<Point> set = new HashSet<>();
		set.addAll(point2);
		
		
	}
	static class Point
	{
		int x,y ;
		Point(int x,int y)
		{
			this.x = x;
			this.y = y;
		}
		public boolean equals(Object obj)
		{
			if(!(obj instanceof Point))
				return false;
			if(this == obj)
				return true;
			return this.x == ((Point) obj).x 
					&&	this.y == ((Point) obj).y;
		}
		public int hashCode()
		{
			int result = 0;
			result = (x * 31) + y ;
			return result;
		}
		
	}

}
