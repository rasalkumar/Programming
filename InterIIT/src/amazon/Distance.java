package amazon;
import java.util.*;
public class Distance {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int totalRestaurants = in.nextInt();
		int x = in.nextInt();
		
		List<List<Integer>> allocations = new ArrayList<>();
		for(int i = 0 ; i < totalRestaurants ;i++)
		{
			List<Integer> p = new ArrayList<>();
			p.add(in.nextInt());
			p.add(in.nextInt());
			allocations.add(p);
		}
		List<List<Integer>> ans = nearestVegeterianRestaurant(totalRestaurants, allocations,x);
		for(List<Integer> p : ans)
		{
			System.out.println(p);
		}
	}
	public static List<List<Integer>> nearestVegeterianRestaurant(int totalRestaurants,
			List<List<Integer>> allocations, int restaurants)
	{
		long dist[] = new long[totalRestaurants];
		PriorityQueue<Point> pq = new PriorityQueue<>(totalRestaurants, new Comparator<Point>()
		{
			public int compare(Point p1, Point p2)
			{
				return (int)(p1.value - p2.value);
			}
		});
		for(int i = 0 ; i < allocations.size() ;i++)
		{
			dist[i] = (long)(Math.pow(allocations.get(i).get(0), 2)) +
					(long)(Math.pow(allocations.get(i).get(1), 2));
			pq.add(new Point(dist[i],i));
		}
		List<List<Integer>> ans = new ArrayList<>();
		int i = 0;
		while(i < restaurants)
		{
			Point p = pq.poll();
			ans.add(allocations.get(p.index));
			i++;
		}
		return ans;
	}
	static class Point
	{
		long value;
		int index;
		Point(long value, int index)
		{
			this.value = value;
			this.index = index; 
		}
	}

}
