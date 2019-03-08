package chefLandAndAvgDistance;
import java.util.*;
public class AvgMat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			int m = in.nextInt();
			String s[] = new String[n];
			for( int i = 0 ; i  < n ; i++ )
			{
				s[i] = in.next();
			}
			ArrayList<Point> p = new ArrayList<>();
			for(int i = 0  ; i < n ; i++ )
			{
				for(int j = 0  ; j < m ; j++)
				{
					if(s[i].charAt(j) == '1')
					{
						p.add(new Point(i,j));
					}
				}
			}
//			for(int i = 0 ; i < p.size() ;i++ )
//			{
//				System.out.println(p.get(i).x +" " + p.get(i).y );
//			}
			
			HashMap<Integer,Integer> map = new HashMap<>();
			for(int i = 1 ; i < p.size() ; i++ )
			{
				
			}
			for(int i = 0 ; i < p.size() ;i++ )
			{
				for(int j = i + 1 ; j < p.size() ; j++ )
				{
					{
						Point p1 = p.get(i);
						Point p2 = p.get(j);
						int d = Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
						if(!map.containsKey(d))
						{
							map.put(d, 1);
						}
						else
						{
							map.put(d, map.get(d) + 1);
						}
					}
				}
			}
			for(int i = 1 ; i <= n + m - 2 ; i++)
			{
				if (map.containsKey(i))
				{
					System.out.print(map.get(i)+ " ");
				}
				else
				{
					System.out.print(0 + " ");
				}
			}
			System.out.println();
		}
		
	}
	static class Point
	{
		int x, y ;
		Point(int x , int y )
		{
			this.x = x ;
			this.y = y ;
		}
		
	}
}
