package amazon;
import java.util.*;
public class LongestAp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i = 0 ; i < n ; i++)
		{
			a[i] = in.nextInt();
		}
		int dp[] = new int[n];
		Arrays.fill(dp, 2);
		Arrays.sort(a);
		int ans = 2;
		for(int j = n - 2 ; j >= 0 ; j--)
		{
			int i = j - 1;
			int k = j + 1;
			while(i >= 0 && k < n)
			{
				if((a[i] + a[k]) == (2 * a[j]))
				{
					dp[j] = Math.max(dp[j] + 1, dp[j]);
					ans = Math.max(ans, dp[j]);
					i--;
					k++;
				}
				else if( (a[i] + a[k]) < (2 * a[j]))
				{
					k++;
				}
				else
				{
					i--;
				}
				
			}
		}
		System.out.println(ans);

	}

}
