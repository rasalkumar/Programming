package dec11;
import java.util.*;
public class DistinctNumbersInAWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		ArrayList<Integer> a = new ArrayList<>();
		for(int i = 0 ; i < n ;i++)
		{
			a.add(in.nextInt());
		}
		ArrayList<Integer> result = new ArrayList<>();
		HashMap<Integer,Integer> map = new HashMap<>();
		
		int count = 0 ;
		for(int i = 0 ; i < k ; i++)
		{
			if(!map.containsKey(a.get(i)))
			{
				map.put(a.get(i), 1);
				count++;
			}
			else
				map.put( a.get(i) , map.get(a.get(i)) + 1 );
		}
		result.add(count);
		//count = 0;
		HashSet<Integer> set = new HashSet<>();
		
		for( int i = k ; i < a.size() ; i++ )
		{
			if(map.get(a.get(i-k))== 1)
			{
				map.remove(a.get(i-k));
				count--;
			}
			else
			{
				map.put(a.get(i - k), map.get(a.get(i - k)) - 1 );
			}
			if(!map.containsKey(a.get(i)))
			{
				map.put(a.get(i), 1);
				count++;
			}
			else
			{
				map.put(a.get(i), map.get(a.get(i))+1);
			}
			result.add(count);
		}
		System.out.println(result);
	}
}
