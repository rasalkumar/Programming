package test;
import java.util.*;
public class SegmentedSieve {
static int Max = 1000006;
static ArrayList<Integer> primes;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- > 0)
		{
			int l = in.nextInt();
			int r = in.nextInt();
			boolean isPrime[] = new boolean[r - l + 1];
			for(int i = l ;i<=r ;i++)
			{
				isPrime[r -l] = true;
			}
			if(l == 1)
				isPrime[0] = false;
			for(int i = 0 ; primes.get(i) * primes.get(i) <= r ; i++ )
			{
				int currVal = primes.get(i);
				int baseVal = (l / currVal) * currVal;
				if(baseVal < l)
				{
					baseVal +=currVal;
				}
				for(int j = baseVal ; j <= r ; j+=currVal)
				{
					isPrime[j-l] = false;
				}
				if(baseVal == currVal)
					isPrime[baseVal - l] = true;
				
				
			}
			for(int j = 0 ; j <= r - l ; j++)
				if(isPrime[j])
					System.out.println((j+l) + " ");
		}

	}
	public static void sieve(int n)
	{
		boolean isPrime[] = new boolean[Max];
		Arrays.fill(isPrime, true);
		for( int i = 2 ; i * i <= n ; i++)
		{
			if(isPrime[i])
			{
				for(int j = 2 * i ; j <= n ;j += i)
				{
					isPrime[j] =false;
				}
			}
		}
		primes.add(2);
		for(int i = 3; i <= n ;i += 2)
		{
			if(isPrime[i])
				primes.add(i);
		}
	}

}
