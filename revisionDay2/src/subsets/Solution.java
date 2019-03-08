package subsets;
import java.util.*;
public class Solution {
	static ArrayList<ArrayList<Integer>> result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			ArrayList<Integer> a = new ArrayList<>();
			for( int i = 0 ; i < n ; i++ )
				a.add(in.nextInt());
			result = new ArrayList<>();
			subsets(a);
			Collections.sort(result, new Comparator<ArrayList<Integer>>() 
			{
				public int compare(ArrayList<Integer> a , ArrayList<Integer> b)
				{
					int an = a.size();
					int bn = b.size();
					for(int i = 0 ; i < Math.min( an , bn ) ; i++ )
					{
						int cmp = Integer.compare(a.get(i) , b.get(i));
						if(cmp != 0)
							return cmp;
					}
					return Integer.compare(a.size(), b.size());
				}
			});
			for( ArrayList<Integer> l : result )
				System.out.println(l);
		}
	}
	public static void subsets(ArrayList<Integer> a)
	{
		ArrayList<Integer> temp = new ArrayList<>();
		subsets(a,result,temp,0);
	}
	public static void subsets(ArrayList<Integer> a,ArrayList<ArrayList<Integer>> result,
								ArrayList<Integer> temp,int start)
	{
		result.add(new ArrayList<>(temp));
		for(int i = start  ; i < a.size() ;i++)
		{
			temp.add(a.get(i));
			subsets(a, result, temp, i+1);
			temp.remove(temp.size()-1);
		}
	}
}
