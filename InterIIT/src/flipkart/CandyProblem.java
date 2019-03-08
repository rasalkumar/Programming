package flipkart;
import java.util.*;
public class CandyProblem {
	static int p[];
	static long s[];
	static long max;
	static int maxRoot;
	static long max1[];
	static long max2[];
	static int MAX = 2000005;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		max1 = new long[MAX];
		max2 = new long[MAX];
		p = new int[MAX];
		s = new long[MAX];
		max = 0 ;
		maxRoot = 0;
		int n = in.nextInt();
		int[] from = new int[n];
		int[] to = new int[n];
		int[] candies = new int[n];
		for(int i = 0 ; i < n ; i++ )
			from[i] = in.nextInt();
		for(int i = 0 ; i < n ; i++ )
			to[i] = in.nextInt();
		for(int i = 0 ; i < n ; i++ )
			candies[i] = in.nextInt();
		for(int i = 0 ; i < n ; i++ )
		{
			union(from[i],to[i],candies[i]);
		}
		System.out.println(max1[maxRoot] * max2[maxRoot]);
		
		
	}
	public static void union(int a ,int b ,int candies)
	{
		int root_a = root(a);
		int root_b = root(b);
		if(candies > max1[root_a])
		{
			max1[root_a] = candies;
		}
		else if(candies > max2[root_a])
		{
			max2[root_a] = candies;
		}
		if(candies > max1[root_b])
		{
			max1[root_b] = candies;
		}
		else if(candies > max2[root_b])
		{
			max2[root_b] = candies;
		}
		if(root_a == root_b )
			return;
		long s1 = s[root_a];
		long s2 = s[root_b];
		if(s1 <= s2)
		{
			p[root_a] = p[root_b];
			s[root_b] += s[root_a];
			s[root_a] = 0;
			if(max1[root_a] > max1[root_b])
			{
				if(max2[root_a] > max1[root_b])
				{
					max2[root_b] = max2[root_a];
				}else
				{
					max2[root_b]  = max1[root_b];
				}
				max1[root_b] = max1[root_a];
			}
			else
			{
				if(max1[root_a] > max2[root_b])
					max2[root_b] = max1[root_b];
			}
			if(s[root_b] > max)
			{
				max = s[root_b];
				maxRoot = root_b;
			}
		}
		else
		{
			p[root_b] = p[root_a];
			s[root_a] += s[root_b];
			s[root_b] = 0;
			if(max1[root_b] > max1[root_a])
			{
				if(max2[root_b] > max1[root_a])
				{
					max2[root_a] = max2[root_b];
				}else
				{
					max2[root_a]  = max1[root_a];
				}
				max1[root_a] = max1[root_b];
			}
			else
			{
				if(max1[root_b] > max2[root_a])
					max2[root_a] = max1[root_a];
			}
			if(s[root_a] > max){
				max = s[root_a];
				maxRoot = root_a;
			}
		}
		
	}
	public static int root(int v)
	{
		if(v != p[v])
		{
			v = p[p[v]]; 
		}
		return v;
	}

} 
