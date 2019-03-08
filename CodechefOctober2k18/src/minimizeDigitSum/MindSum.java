package minimizeDigitSum;
import java.util.*;
public class MindSum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			long n = in.nextLong();
			long d = in.nextLong();
			long count = 0 ;
			Queue<Point> queue = new LinkedList<>();
			queue.add(new Point(n,0));
			long minNum = Long.MAX_VALUE;
			long minCount = Long.MAX_VALUE;
			while(count < 100005)
			{
				Point p = queue.poll();
				if( p.num < minNum )
				{
					minNum = p.num;
					minCount = p.count;
				}
				queue.add(new Point(digitSum(p.num) , p.count + 1 ));
				
				queue.add(new Point(p.num + d,p.count + 1 ));
				count++;
			}
			System.out.println(minNum + " " + minCount);
		
			
		}	
		
	}
	static class Point
	{
		long num;
		long count;
		Point(long num,long count)
		{
			this.num = num;
			this.count = count;
		}
	}
	public static int digitSum(long n)
	{
		long z = n;
		int sum = 0 ;
		while(z != 0)
		{
			long d = z % 10;
			sum += d;
			z = z/ 10;
		} 
		return sum;
	}

}
