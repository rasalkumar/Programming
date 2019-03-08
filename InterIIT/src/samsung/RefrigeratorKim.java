package samsung;
import java.util.Scanner;
public class RefrigeratorKim {
	static Point[] point;
	static Point first;
	static Point last;
	static int min;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- > 0)
		{
			
			int n = in.nextInt();
			int x[] = new int[n+2];
			int y[] = new int[n+2];
			x[0] = in.nextInt();
			y[0] = in.nextInt();
			first = new Point(x[0], y[0]); 
			x[1] = in.nextInt();
			y[1] = in.nextInt();
			last = new Point(x[1], y[1]);
			point = new Point[n+2];
			point[0] = first;
			point[1] = last;
			for(int i = 2 ; i < n + 2 ; i++)
			{
				x[i] = in.nextInt();
				y[i] = in.nextInt();
				point[i] = new Point(x[i],y[i]);
			}
			min = Integer.MAX_VALUE;
			permute(0,n+2);
			System.out.println(min);
		}
	}
	public static void permute(int start, int n)
	{
		if(point.length == n)
		{
			if( point[0] == first && point[n-1] == last )
			{
				int ans = 0;
				for(int i = 1 ; i < n ; i++ )
				{
					ans += Math.abs(point[i].x - point[i-1].x) + Math.abs(point[i].y - point[i-1].y);
				}
				if(ans < min)
					min = ans;
			}
		}
		for(int i = start ; i < n ; i++ )
		{
			swap(start,i);
			permute( start + 1 , n );
			swap(start,i);
		}
	}
	static void swap(int x, int y)
	{
		Point temp = point[x];
		point[x] = point[y];
		point[y] = temp;
	}
	static class Point
	{
		int x, y ;
		Point(int x,int y)
		{
			this.x = x ;
			this.y = y ;
		}
		
	}

}
