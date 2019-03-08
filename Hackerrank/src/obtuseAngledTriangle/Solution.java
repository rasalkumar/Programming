package obtuseAngledTriangle;
import java.util.*;
public class Solution {
	static int dx[] = { -1 , 0 , 1 , -1 , 1 , -1 , 0 , 1 };
	static int dy[] = { 1 , 1 , 1 ,  0 , 0 , -1 , -1 , -1};
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int r = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int n = in.nextInt();
		Point point1 = axisRotate1(a,b);
		Point point2 = axisRotate2(a,b,n);
		//System.out.println(point1.x + " " + point1.y);
		//System.out.println(point2.x + " " + point2.y);
		HashSet<Point> set = new HashSet<>();
		Queue<Point> queue = new LinkedList<>();
		set.add(new Point(r,0));
		queue.add(new Point(r,0));
		long count = 0;
		int flag = 0 ;
		while(queue.size() != 0)
		{
			Point curr = queue.poll();
			
			double x = dist(curr.x, point1.x , curr.y, point1.y);
			double y = dist(curr.x, point2.x , curr.y, point2.y);
			double z = dist(point1.x, point2.x , point1.y, point2.y);
			double x2 = Math.pow((curr.x - point1.x) , 2) + Math.pow((curr.y - point1.y) , 2) ;
			double y2 = Math.pow((curr.x - point2.x) , 2) + Math.pow((curr.y - point2.y) , 2) ;
			double z2 = Math.pow((point1.x - point2.x) , 2) + Math.pow((point1.y - point2.y) , 2) ;
			if( x2 - y2 - z2 > Math.pow(0.1, 6)  && x != 0 && y != 0 && z != 0 &&
					x + y - z > Math.pow(0.1, 6) && y + z - x > Math.pow(0.1, 6)
					&& x + z - y > Math.pow(0.1, 6) )
			{
				flag = 1 ;
				//System.out.println(curr.x + " " + curr.y + " " + flag);
				count++;
			}
			else if(y2 - x2 - z2 > Math.pow(0.1, 6)  && x != 0 && y != 0 && z != 0 &&
					x + y - z > Math.pow(0.1, 6)  && y + z - x > Math.pow(0.1, 6)  
					&& x + z - y > Math.pow(0.1, 6)	)
			{
				flag = 2 ;
				//System.out.println(curr.x + " " + curr.y + " " + flag + " " + z + " " + y + " " + x);
				count++;
			}
			else if(z2 - x2 - y2 > Math.pow(0.1, 6)  && x != 0 && y != 0 && z != 0 &&
					x + y - z > Math.pow(0.1, 6)  && y + z - x > Math.pow(0.1, 6) 
					&& x + z - y > Math.pow(0.1, 6) )
			{
				
				flag = 3 ; 
				//System.out.println(curr.x + " " + curr.y + " " + flag + " " + z + " " + y + " " + x);
				count++;
			}
			for(int i = 0 ; i < dx.length ;i++)
			{
					if(isSafe(curr.x + dx[i], curr.y + dy[i],r) && 
						!set.contains( new Point(curr.x + dx[i], curr.y + dy[i])))
				{
					queue.add(new Point(curr.x + dx[i], curr.y + dy[i]));
					set.add(new Point(curr.x + dx[i], curr.y + dy[i]));
				}
			}
		}
		System.out.println(count);

	}
	
	
	public static boolean isSafe(double x,double y,int r)
	{
		if(Math.abs(x) + Math.abs(y) <= r  )
		{
			return true;
		}
		return false;
	} 
	public static double dist(double x1,double x2,double y1,double y2)
	{
		return Math.sqrt(Math.pow((x1 - x2) , 2) + Math.pow((y1 - y2) , 2)) ;
	}
	public static Point axisRotate1(int a ,int b)
	{
		double a1 = a;
		double b1 = b;
		double x = (a1 / b1)  ;
		return new Point(x,x);
	}
	public static Point axisRotate2(int a ,int b, int n)
	{
		double a1 = a;
		double b1 = b;
		double n1 = n; 
		double x = ((2.0 * n1) - (a1 / b1));
		return new Point(x,x);
	}
	static class Point
	{
		double x , y;
		Point(double x , double y)
		{
			this.x = x;
			this.y = y;
 		}
		public boolean equals(Object obj) {
		    if (!(obj instanceof Point))
		      return false;
		    if (obj == this)
		      return true;
		    return  this.x == ((Point) obj).x &&
		            this.y == ((Point) obj).y;
		}
		public int hashCode()
		{
			int result = 0 ;
			result = (((int)x) * 31) + (int) y;
			return result ;
		}
		
	}

}


// OLD WRONG SOLUTION

//public class Solution {
//	static int dx[] = {-1,0,1,-1,1,-1,0,1};
//	static int dy[] = {1,1,1,0,0,-1,-1,-1};
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int r = in.nextInt();
//		int n = in.nextInt();
//		int a = in.nextInt();
//		int b = in.nextInt();
//		
//		Point point1 = axisRotate1(a,b);
//		Point point2 = axisRotate2(a,b,n);
//		int limit = (int)Math.floor(Math.sqrt(2) * r);
//		boolean visited[][] = new boolean[ limit + 1 ][limit + 1 ];
//		Queue<Point> queue = new LinkedList<>();
//		visited[0][0] = true;
//		queue.add(new Point(0,0));
//		long count = 0;
//		while(queue.size() != 0)
//		{
//			Point curr = queue.poll();
//			double x = dist(curr.x, point1.x , curr.y, point1.y);
//			double y = dist(curr.x, point2.x , curr.y, point2.y);
//			double z = dist(point1.x, point2.x , point1.y, point2.y);
//			if(Math.pow(x, 2) > (Math.pow(y, 2) + Math.pow(z, 2)) && x < (y + z) && 
//					x != 0 && y!=0 && z != 0)
//			{
//				count++;
//			}
//			else if(Math.pow(y, 2) > (Math.pow(x, 2) + Math.pow(z, 2)) && y < (x + z) &&
//					x != 0 && y!=0 && z != 0)
//			{
//				count++;
//			}
//			else if(Math.pow(z, 2) > (Math.pow(x, 2) + Math.pow(y, 2)) && z < (x + y) &&
//					x != 0 && y!=0 && z != 0)
//			{
//				count++;
//			}
//			for(int i = 0 ; i < dx.length ;i++)
//			{
//				if(isSafe(curr.x + dx[i], curr.y + dy[i], limit) && 
//						!visited[(int)curr.x+dx[i]][(int)curr.y+dy[i]])
//				{
//					queue.add(new Point(curr.x + dx[i], curr.y + dy[i]));
//					visited[(int)curr.x+dx[i]][(int)curr.y+dy[i]] = true;
//				}
//			}
//		}
//		System.out.println(count);
//
//	}
//	public static boolean isSafe(double x,double y,int limit)
//	{
//		if(x >= 0 && x <= limit    && y >= 0 && y <= limit  )
//		{
//			return true;
//		}
//		return false;
//	} 
//	public static double dist(double x1,double x2,double y1,double y2)
//	{
//		return Math.sqrt(Math.pow((x1 - x2) , 2) + Math.pow((y1 - y2) , 2)) ;
//	}
//	public static Point axisRotate1(int a ,int b)
//	{
//		double a1 = a;
//		double b1 = b;
//		double x = (a1 / b1) * 2.0 ;
//		double y = 0;
//		return new Point(x,y);
//	}
//	public static Point axisRotate2(int a ,int b, int n)
//	{
//		double a1 = a;
//		double b1 = b;
//		double n1 = n; 
//		double x = ((2.0 * n1) - (a1 / b1)) * 2.0 ;
//		double y = 0;
//		return new Point(x,y);
//	}
//	static class Point
//	{
//		double x , y;
//		Point(double x , double y)
//		{
//			this.x = x;
//			this.y = y;
// 		}
//	}
//
//}

