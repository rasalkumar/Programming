package combinationSum2;
import java.util.*;
public class Solution {
	static ArrayList<ArrayList<Integer>> result ;
	static ArrayList<Integer> c , temp ;
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		while( p-- > 0 )
		{
			n = in.nextInt();
			int t = in.nextInt();
			c = new ArrayList<>();
			for(int i = 0 ; i < n ; i++ )
			{
				c.add(in.nextInt());
			}
			result = new ArrayList<>();
			combinationSum(t);
			Collections.sort(result, new Comparator<ArrayList<Integer>>()
			{
				public int compare(ArrayList<Integer> a, ArrayList<Integer> b)
				{
					int an = a.size();
					int bn = b.size();
					for(int i = 0 ; i < Math.min(an , bn) ; i++ )
					{
						int cmp = Integer.compare(a.get(i), b.get(i));
						if( cmp != 0 )
							return cmp;
					}
					return Integer.compare(a.size(), b.size());
				}
			});
			HashSet<ArrayList<Integer>> set = new HashSet<>();
			set.addAll(result);
			result.clear();
			result.addAll(set);
			for(ArrayList<Integer> l : result)
				System.out.println(l);
		}
	}
	public static void combinationSum(int t)
	{
		temp = new ArrayList<>();
		combinationSum(0,t);
	}
	public static void combinationSum(int start,int target)
	{
		if(target == 0)
		{
			Collections.sort(temp);
			HashSet<ArrayList<Integer>> temp2 = new HashSet<>();
			if(!temp2.contains(temp))
			{
				temp2.add(temp);
				result.add(new ArrayList<>(temp));
			}
			return;
		}
		if(target < 0)
			return ;
		int prev = -1;
		for(int i = start ; i < c.size() ; i++ )
		{
			if(prev != c.get(i)){
			if( c.get(i) > target )
				return;
			temp.add(c.get(i));
			combinationSum(i+1,target - c.get(i));
			temp.remove(temp.size()-1);
			prev= c.get(i);
		}}
	}
}
