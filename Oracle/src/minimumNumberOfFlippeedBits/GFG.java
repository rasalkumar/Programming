package minimumNumberOfFlippeedBits;
import java.util.*;
public class GFG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			String s = in.next();
			int p = s.charAt(0)-48;
			int count1 = 0 ;
			for(int i = 1 ; i < s.length() ; i++ )
			{
				if((s.charAt(i)-48) != 1 - p)
				{
					count1++;
				}
				p = 1- p;
			}
			int r = 1 - (s.charAt(0)-48);
			int count3 = 1 ;
			for(int i = 1 ; i < s.length() ; i++ )
			{
				if((s.charAt(i)-48) != 1 - r)
				{
					count3++;
				}
				r = 1 - r;
			}
			int count2 = 0 ;
			int q = s.charAt(s.length() - 1)-48;
			for(int i = s.length()-2; i >= 0 ; i-- )
			{
				if((s.charAt(i)-48) != 1 - q)
				{
					count2++;
				}
				q = 1 - q;
			}
			int count4 = 1 ;
			int u = 1-(s.charAt(s.length() - 1)-48);
			for(int i = s.length()-2; i >= 0 ; i-- )
			{
				if((s.charAt(i)-48) != 1 - u)
				{
					count4++;
				}
				u = 1 - u;
			}
			int ans1 = Math.min(count1, count2);
			int ans2 = Math.min(count3, count4);
			System.out.println(Math.min(ans1, ans2));
		}
	}

}
