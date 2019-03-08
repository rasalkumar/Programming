package combinations2;

import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<>();
		int n = in.nextInt();
		for(int i = 0 ; i < n ; i++ )
		{
			a.add(in.nextInt());
		}
		int sum = in.nextInt();
		ArrayList<ArrayList<Integer>> res= combinations(a,sum);
		Collections.sort(res,new Comparator<ArrayList<Integer>>() {
			public int compare(ArrayList<Integer> a , ArrayList<Integer> b)
			{
				if(a.size()>b.size())
				{
					return 1;
				}
				else if(a.size()<b.size())
				{
					return -1;
				}
				return (a.get(0) - b.get(0));
			}
		});
		for( ArrayList<Integer> l : res )
		{
			System.out.println(l);
		}
	}
	public static ArrayList<ArrayList<Integer>> combinations(ArrayList<Integer> a, int sum)
	{
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		Collections.sort(a);
		combinations(a,0,sum,temp,res);
		HashSet<ArrayList<Integer>> set = new HashSet<>(res);
		res.clear();
		res.addAll(set);
		return res;
	}
	public static void combinations(ArrayList<Integer> a , int start, int sum , ArrayList<Integer> temp , ArrayList<ArrayList<Integer>> res )
	{
		if( sum == 0 )
		{
			res.add(new ArrayList<>(temp));
		}
		for(int i = start ; i < a.size() ; i++ )
		{
			int curr = a.get(i);
			if( curr > sum )
			{
				return;
			}
			temp.add(curr);
			combinations(a, i , sum - curr , temp ,res );
			temp.remove( temp.size() - 1 );
		}
	}
}
