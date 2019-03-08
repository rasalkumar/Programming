package amazon;
import java.util.*;
public class TwoOddNos {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i = 0 ; i  < n ; i ++)
		{
			a[i] = in.nextInt();
		}
		int set_bit = 0 ;
		int xor2 = a[0];
		int x = 0 ; int y = 0 ;
		for( int i = 1 ; i < n ; i++ )
		{
			xor2 ^= a[i];
		}
		set_bit = xor2 & ~(xor2 - 1);
		for(int i = 0 ; i < n ;i++)
		{
			if((a[i]&set_bit) >0)
			{
				x = x ^ a[i];
			}
			else
			{
				y = y ^ a[i];
			}
		}
		System.out.println(x +" " + y);
		

	}

}
