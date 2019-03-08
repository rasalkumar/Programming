package yogurt;
import java.util.*;
public class Yogurt {
	static int[] a;
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int m = 1;
		while( t-- > 0 )
		{
			int n = in.nextInt();
			int k = in.nextInt();
			a = new int[n];
			for(int i = 0 ; i < n ; i++ )
				a[i] = in.nextInt();
			Arrays.sort(a);
			int c = 0;
			long sum = 0;
			int max = a[a.length-1];
			for(long i = 0 ; i <max ; i++)
			{
				int sumDaily = 0 ;
				while(c < a.length && i < a[c] && sumDaily < k)
				{
					sumDaily += 1;
					c++;
				}
				
				sum += sumDaily;
				if(sumDaily == k )
					continue;
				
				while(c < a.length && i >= a[c])
					c++;
				if( c > a.length)
					break;
							
			}
			System.out.println("Case #"+ m++ +": " +sum);
			
		}
		
	}
}
