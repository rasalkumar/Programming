package p231;
import java.util.*;
public class CountingBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ans = cBits(n);
		for(int i = 1 ; i < ans.length ; i++ )
		{
			System.out.print(ans[i] +" ");
		}
	}
	public static int[] cBits(int n)
	{
		int result[] = new int[n+1];
		int p = 1 ;
		int pow = 1 ;
		for(int i = 1 ;i <= n ; i++ )
		{
			if(i==pow)
			{
				result[i] = 1 ;
				pow <<= 1 ;
				p = 1 ;
			}
			else
			{
				result[i] = result[p] + 1 ;
				p++;
			}
		}
		return result;
	}

}
