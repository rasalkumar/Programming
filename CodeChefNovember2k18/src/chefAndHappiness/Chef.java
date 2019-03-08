package chefAndHappiness;
import java.util.*;
public class Chef {
	static int[] a;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- > 0)
		{
			a = new int[100005];
			int n = in.nextInt();
			for(int i = 1 ; i <= n ; i++ )
			{
				a[i] = in.nextInt();
			}
			HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
			int flag = 0;
			for(int i = 1 ; i <= n ; i++ )
			{
				if(a[i] > 0 && a[i] <= n && !map.containsKey(a[a[i]]) )
				{
					HashSet<Integer> temp = new HashSet<>();
					temp.add(a[i]);
					map.put(a[a[i]], temp);
				}
				else if(a[i] > 0 && a[i] <= n && map.containsKey(a[a[i]]))
				{
					if(!map.get(a[a[i]]).contains(a[i]))
					{
						flag = 1;
						//System.out.println(a[a[i]] + "   " + a[i]);
						break;
					}
				}
			}
			if(flag == 0)
			{
				System.out.println("Poor Chef");
			}
			else
			{
				System.out.println("Truly Happy");
			}
		}
		
	}

}
