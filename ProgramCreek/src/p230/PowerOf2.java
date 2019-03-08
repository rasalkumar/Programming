package p230;
import java.util.*;
public class PowerOf2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		boolean ans = check(n);
		System.out.println(ans);
	}
	public static boolean check(int n)
	{
		if( n <= 0 )
		{
			return false;
		}
		while( n > 2 )
		{
			int t = n >> 1 ;
			int c = t << 1 ;
			
			if (t != c)
			{
				return false;
			}
			n >>= 1;
		}
		return true;
	}
}
