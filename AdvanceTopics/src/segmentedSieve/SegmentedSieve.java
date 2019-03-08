package segmentedSieve;
import java.util.*;
public class SegmentedSieve {
	static ArrayList<Integer> primes;
	static int MAX = 1000006;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		primes = new ArrayList<>();
		sieve(MAX);
//		for(int i =0 ;i <primes.size();i++)
//		{
//			System.out.println(primes.get(i));
//		}
		while( t-- > 0 )
		{
			int l = in.nextInt();
			int r = in.nextInt();
			
			boolean[] isPrime = new boolean[r - l + 1];
			for( int i = 0 ; i <= r - l ; i++ )
			{
				isPrime[i] = true;
			}
			if(l==1)
				isPrime[0] = false;
			for(int i = 0 ; primes.get(i) * primes.get(i) <= r ;  i++ )
			{
				int currPrime = primes.get(i);
				int base = (l /currPrime) * currPrime ;
				if( base < l)
				{
					base = base + currPrime;
				}
				for(int j = base ; j <= r; j+=currPrime)
				{
					isPrime[j-l] = false;
				}
				if(base == currPrime)
					isPrime[base - l] =true;
				
			}
			
			for(int i = 0 ; i <= r - l ; i++ )
			{
				if(isPrime[i] == true)
					System.out.print(i + l + " ");
			}
				
		}
		
	}
	static void sieve(int n)
	{
		boolean prime[] = new boolean[n+1];
		Arrays.fill(prime,true);
		for(int i = 2 ; i * i  <= n ; i++ )
		{
			if(prime[i])
			{
				for(int j = 2 * i ; j <= n ; j +=i)
				{
					prime[j] = false;
				}
			}
		}
		primes.add(2);
		for(int i = 3 ; i <= n ;i+=2 )
		{
			if(prime[i])
				primes.add(i);
		}
	}

}
