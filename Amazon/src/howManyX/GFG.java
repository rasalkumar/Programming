package howManyX;
import java.util.*;
public class GFG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0)
		{
			int x = in.nextInt();
			int l = in.nextInt();
			int r = in.nextInt();
			HashSet<Integer> set = new HashSet<>();
			set.add(x);
			int c=0;
			for(int i = l+1 ; i < r ; i++)
			{
				
				for(int j = i ; j > 0 ; j = j/10)
				{
					if(set.contains(j%10))
					{
						c++;
					}
				}
			}
			System.out.println(c);
		}
	}

}
