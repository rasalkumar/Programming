package dec3;
import java.util.*;
public class Seive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			boolean prime[] = new boolean[n+1];
			Arrays.fill(prime, true);
			for(int i = 2 ;i * i <= n ; i++ )
			{
				if(prime[i] == true)
				{
					for(int j = 2 *i ; j <= n ;j += i)
					{
						prime[j] = false;
					}
				}
			}
			for(int i = 2 ;i <=n ;i++)
			{
				if(prime[i] == true)
					System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
