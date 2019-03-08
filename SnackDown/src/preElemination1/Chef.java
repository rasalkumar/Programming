package preElemination1;

// KEEP IT SIMPLE SILLY @Tm Protino
import java.util.*;
public class Chef {
	static int[] dp;
	public static void main(String agrs[])
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			String s = in.next();
			dp = new int[100005];
			for(int i = 0 ;i < n;i++ )
			{
				if(s.charAt(i) == '.')
				{
					if (s.charAt(i+2)== '.')
					{
						
					}
				}
			}
		}
	}

}
