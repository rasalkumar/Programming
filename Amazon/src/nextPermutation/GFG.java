package nextPermutation;

import java.util.*;

public class GFG {
	public static void main(String args[]) 
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- >0 )
		{
			ArrayList<Integer> a = new ArrayList<>();
			int n = in.nextInt();
			for(int i=0 ; i < n;i++)
			{
				a.add(in.nextInt());
			}
			
			int index = -1;
			for(int i = a.size() - 2 ; i >= 0 ; i--)
			{
				if( a.get(i) < a.get(i+1) )
				{
					index = i;
					break;
				}
			}
			if(index == -1 )
			{
				Collections.sort(a);
				System.out.println(a);
			}
			else
			{
				int k = a.get(index);
				for(int j = a.size() - 1; j >=0 ;j--)
				{
					if(a.get(j)>k)
					{
						int y = a.get(j);
					    a.set(j, k);
					    a.set(index,y);
					    break;
					}
				}
				ArrayList<Integer> temp = new ArrayList<>();
				for(int i = index + 1 ; i < a.size();i++)
				{
					temp.add(a.get(i));
				}
				Collections.sort(temp);
				ArrayList<Integer> result = new ArrayList<>();
				for(int i = 0; i <= index ;i++)
				{
					result.add(a.get(i));
				}
				for(int i = 0 ; i < temp.size() ; i++ )
				{
					result.add(temp.get(i));
				}
				System.out.println(result);
			}
		}
	}
}
