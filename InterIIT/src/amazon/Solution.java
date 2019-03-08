package amazon;
import java.util.*;
public class Solution {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int deviceCapacity = in.nextInt();
		deviceCapacity = in.nextInt();
		List<List<Integer>> foregroundAppList = new ArrayList<>();
		List<List<Integer>> backgroundAppList = new ArrayList<>();
		int n = in.nextInt();
		for(int i = 0 ; i < n ; i++ )
		{
			List<Integer> a = new ArrayList<>();
			a.add(in.nextInt());
			a.add(in.nextInt());
			foregroundAppList.add(a);
		}
		int m = in.nextInt();
		for(int i = 0 ; i < m ; i++ )
		{
			List<Integer> a = new ArrayList<>();
			a.add(in.nextInt());
			a.add(in.nextInt());
			backgroundAppList.add(a);
		}
		List<List<Integer>> ans = optimalUtilization(deviceCapacity,foregroundAppList,backgroundAppList); 
		for(List<Integer> p : ans)
		{
			System.out.println(p);
		}
	}

	public static List<List<Integer>> optimalUtilization(int deviceCapacity, 
			List<List<Integer>> foregroundAppList,
			List<List<Integer>> backgroundAppList) {
		Pair pair1[] = new Pair[foregroundAppList.size()];	
		for( int i = 0 ; i  < foregroundAppList.size() ; i++ )
		{
			List<Integer> p = foregroundAppList.get(i);
			pair1[i] = new Pair(p.get(0),p.get(1));
		}
		Arrays.sort(pair1);
		
		Pair pair2[] = new Pair[backgroundAppList.size()];	
		for( int i = 0 ; i  < backgroundAppList.size() ; i++ )
		{
			List<Integer> p = backgroundAppList.get(i);
			pair2[i] = new Pair(p.get(0),p.get(1));
		}
		Arrays.sort(pair2);
		int i = 0;
		int j = 0;
		TreeMap<Integer,Integer> tmap = new TreeMap<>();
		for(int k = 0 ; k < pair2.length ; k++ )
		{
			tmap.put(pair2[i].y, pair2[i].x);
		}
		int ymin = Integer.MAX_VALUE;
		int index1 = -1;
		int index2 = -1;
		while(i <pair1.length)
		{
			int x = deviceCapacity - pair1[i].y;
			int y = tmap.floorEntry(x).getKey();
			if(y < ymin)
			{
				ymin = y;
				
			}
			i++;
		}
		i = 0 ;
		
		
		return null;
	}
	static class Pair implements Comparator<Pair>
	{
		int x, y;
		Pair(int a,int b)
		{
			x = a;
			y = b;
		}
		public int compare(Pair a, Pair b)
		{
			return a.y - b.y; 
		}
	}
	

}
