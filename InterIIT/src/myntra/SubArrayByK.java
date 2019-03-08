package myntra;
//Count number of subarrays with sum divisible by a given K. 
import java.util.*;
public class SubArrayByK {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int t  = in.nextInt();
		while(t-- > 0)
		{
			int n = in.nextInt();
			int  k = in.nextInt();
			int a[] = new int[n];
			for(int i = 0 ; i <  n ; i++ )
				a[i] = in.nextInt();
			HashMap<Integer,Integer> map = new HashMap<>();
			int sum = 0;
			int count = 0;
			map.put(0,1);
			for( int i = 0 ; i < n ; i++ )
			{
				sum = ((sum + a[i]) % k + k) % k ;
				if(!map.containsKey(sum))
				{
					map.put(sum, 1);
				}
				else
				{
					count += map.get(sum);
					map.put(sum,map.get(sum)+1);
				}
			}
			System.out.println(count);
		}
	}

}
