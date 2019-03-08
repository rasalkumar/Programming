package amazon;
import java.util.*;
public class ReachableNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		int d1 = in.nextInt();
		int d2 = in.nextInt();
		int n = in.nextInt();
		int a[] = new int[n];
		int ans[] = new int[n];
		for(int i = 0 ; i < n ; i++)
		{
			a[i] = in.nextInt();
		}
		int gcd = gcd(d1,d2);
		for(int i = 0 ; i < n ;i++)
		{
			int p = a[i] - k; 
			if(p % gcd == 0)
			{
				ans[i] = 1;
			}
		}
		for(int  i = 0 ; i < n ;i++)
			System.out.println(ans[i]);
	}
	static int gcd(int a,int b)
	{
		if(b == 0)
		{
			return a;
		}
		return gcd(b, a % b);
	}

}
