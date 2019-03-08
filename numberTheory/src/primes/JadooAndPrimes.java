package primes;
import java.util.Arrays;
import java.util.Scanner;
public class JadooAndPrimes {
static boolean primes[];
static long sum[] ;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		seive();
		int t =in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			System.out.println(sum[n]);
		}
				

	}
	public static void seive()
	{
		primes = new boolean[100000001];
		Arrays.fill(primes, true);
		for(int i = 2 ; i * i <= 100000000 ; i++ )
		{
			if(primes[i])
			{
				for(int j = 2 * i ; j <= 100000000 ; j += i )
				{
					primes[j] = false;
				}
			}
		}
		sum = new long[20000001];
		sum[0] = 0;
		int count = 1;
		for(int i = 2 ; i <= 100000000 ; i++ )
		{
			if(primes[i])
			{
				sum[count] = sum[count-1] + i;
				count++;
			}
			if( count == 20000001 )
				break;
		}
	}

}
