package chefAndServes;
import java.util.*;
public class Chef {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			long p1 = in.nextInt();
			long p2 = in.nextInt();
			long k = in.nextInt();
			long p = p1+p2;
			int x = 1 ; 
			while(p >= k)
			{
				p = p - k;
				x = 1 - x;
			}
			if(x == 1)
			{
				System.out.println("CHEF");
			}
			else
			{
				System.out.println("COOK");
			}
		}
	}

}
