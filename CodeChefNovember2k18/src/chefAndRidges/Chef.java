package chefAndRidges;
import java.util.*;
public class Chef {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			long x1 = 1,y1 = 2;
			long x2 = 1,y2 = 4;
			for(int i = 3 ; i <= n ; i++)
			{
				if(i%2 == 1)
				{
					x1 = y1 + x1; 
					y1 = (long)Math.pow(2, i);
				}
				else
				{
					x2 = y2 + x2;
					y2 = (long)Math.pow(2, i);
				}
			}
			if(n % 2 == 1)
			{
				System.out.print(x1 + " " + y1 + " ");
			}
			else
			{
				System.out.print(x2 + " " + y2 + " ");
			}
		}
	}

}
