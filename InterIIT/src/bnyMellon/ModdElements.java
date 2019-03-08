package bnyMellon;
import java.util.*;
public class ModdElements {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] a = new int[n];
		for(int i = 0 ; i < n ; i++)
		{
			a[i] = in.nextInt();
		}
		int ans = mOdd(a,m);
		System.out.println(ans);
		

	}
	public static int mOdd(int[] a, int m)
	{
		int n = a.length;
		int count = 0 ;
		int prefix[] = new int[n];
		int odd = 0;
		for(int i = 0 ; i < n ; i++)
		{
			prefix[odd]++;
			if((a[i]&1) == 1)
				odd++;
			if( odd >= m )
				count += prefix[odd -m];
		}
		return count;
		
	}

}
