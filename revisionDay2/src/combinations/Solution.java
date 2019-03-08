package combinations;
import java.util.*;
public class Solution {
	static ArrayList<Integer> a;
	static ArrayList<ArrayList<Integer>> result; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- >  0 )
		{
			int n = in.nextInt();
			int k = in.nextInt();
			a = new ArrayList<>();
			for(int i = 1 ; i <= n ; i++ )
			{
				a.add(i);
			}
			
			result = new ArrayList<>();
			combinations(a,k);
			Collections.sort(result, new Comparator<ArrayList<Integer>>()
			{
				public int compare(ArrayList<Integer> a ,ArrayList<Integer> b)
				{
					int an = a.size();
					int bn = b.size();		
					for(int i = 0 ; i < Math.min(an,bn) ;i++)
					{
						int cmp = Integer.compare(a.get(i), b.get(i));
						if(cmp != 0)
							return cmp;
					}
					return Integer.compare(a.size(), b.size());
				}
			});
			for(ArrayList<Integer> l : result)
				System.out.println(l);
		}
	}
	public static void combinations(ArrayList<Integer> a,int k)
	{
		ArrayList<Integer> temp = new ArrayList<>();
		combinations(temp,0,k);
	} 
	public static void combinations(ArrayList<Integer> temp,int start,int k)
	{
		if(temp.size() == k)
		{
			result.add(new ArrayList<>(temp));
		}
		for(int i = start; i < a.size() ; i++)
		{
			temp.add(a.get(i));
			combinations( temp , i + 1, k);
			temp.remove(temp.size()-1);
		}
	}
}
