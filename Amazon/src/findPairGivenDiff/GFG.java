package findPairGivenDiff;
import java.util.*;
public class GFG {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int l = in.nextInt();
			int n = in.nextInt();
			int a[]= new int[l];
			HashSet<Integer> set = new HashSet<>();
			for(int i = 0 ; i < l ; i++)
			{
				a[i] = in.nextInt();
				set.add(a[i]);
			}
			int flag=-1;
			for(int i = 0;i<l;i++)
			{
				if(set.contains(a[i]+n))
				{
					flag=1;
					break;
				}
			}
			System.out.println(flag);
		}
	}

}
