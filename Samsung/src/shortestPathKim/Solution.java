package shortestPathKim;
import java.util.Scanner;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int x[] = new int[n+2];
		int y[] = new int[n+2];
		for(int i = 0 ; i < n + 2 ; i++ )
		{
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}
		int x1 = x[0];
		int y1 = y[0];
		int x2 = x[1];
		int y2 = y[1];
		
		int ans = solve(x1,y1,x2,y2,x,y,n+2);
		System.out.println(ans);
	}
	static int min = Integer.MAX_VALUE;
	public static int solve(int x1,int y1,int x2,int y2,int[] x, int[] y,int n)
	{
		ArrayList temp = new ArrayList();
		for(int i = 0 ; i < n ; i++ )
		{
			temp.add(new Point(x[i],y[i]));
		}
		
		solve(x1,y1,x2,y2,x,y,0, n,temp);
		return min;
		
	}
	public static void solve(int x1 ,int y1, int x2, int y2, int[] x ,int[] y,int start, int n,ArrayList temp)
	{
		if(temp.size() == n )
		{
			if( temp.get(0).x == x1 && temp.get(0).y == y1 && temp.get(n-1).x == x2 && temp.get(n-1).y == y2 )
			{
				int sum = 0;
				for(int i = 1 ; i < n; i++)
				{
					int a = Math.abs(temp.get(i).x-temp.get(i-1).x) + Math.abs(temp.get(i).y-temp.get(i-1).y);
					sum += a;
				}
				if(sum < min)
				{
					min = sum;
				}
			}
		}
		for(int i = start; i < n ; i++ )
		{
			swap(temp,start,i);
			solve(x1,y1,x2,y2,x,y,start+1,n,temp);
			swap(temp,start,i);
		}
	}
	public static void swap(ArrayList temp, int i, int j)
	{
		Point c = temp.get(i);
		temp.set(i, temp.get(j));
		temp.set(j, c);
	}
	static class Point
	{
		int x;
		int y;
		Point(int x,int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	public static class ArrayList
	{
		Point a[];
		int actSize = 0;
		ArrayList()
		{
			a = new Point[100];
//			for(int i = 0 ; i < 10 ; i++)
//			{
//				a[i] = new Point(0,0);
//			}
		}
		public int size()
		{
			return actSize;
		}
		public void add(Point p)
		{
			a[actSize++] = new Point(p.x,p.y);
		}
		public Point get(int index)
		{
			if(index < actSize)
			{
				return a[index];
			}
			else
			{
				throw new ArrayIndexOutOfBoundsException();
			}
			
		}
		public void set(int index,Point p)
		{
			if(index < actSize)
			{
				a[index] = new Point(p.x,p.y);
			}
			else
			{
				throw new ArrayIndexOutOfBoundsException();
			}
		}
	}

}
