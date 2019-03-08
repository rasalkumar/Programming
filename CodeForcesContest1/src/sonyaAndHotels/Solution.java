package sonyaAndHotels;
import java.util.*;
public class Solution {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long d = in.nextLong();
		long a[] = new long[n+2];
		
		for(int i = 0 ; i < n ;i++)
		{
			a[i] = in.nextLong();
		}
		a[n] = Long.MIN_VALUE;
		a[n+1] = Long.MAX_VALUE;
		Arrays.sort(a);
		HashSet<Long> set = new HashSet<>();
		HashSet<Long> set2 = new HashSet<>();
		for(int i = 0 ; i < n ; i++ )
		{
			set2.add(a[i]);
		}
		for(int i = 1 ; i < n+1 ; i++ )
		{
			if(!set.contains(a[i]+d) && !set2.contains(a[i]+d) && a[i+1] >= a[i]+2*d)
			{
				set.add(a[i]+d);
			}
			if(!set.contains(a[i]-d) && !set2.contains(a[i]-d) && (a[i-1] + (2*d) <= a[i] ))
			{
				set.add(a[i]-d);
			}
		}
//		Iterator<Long> itr = set.iterator();
//		while(itr.hasNext())
//		{
//			long p = (long)itr.next();
//			System.out.println(p);
//		}
		
		System.out.println(set.size());
		
	}

}
