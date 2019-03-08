package p239;
import java.util.*;
public class CombinationSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int n = in.nextInt();
		ArrayList<Integer> c = new ArrayList<>();
		for(int i = 0  ; i < n ; i++ )
		{
			c.add(in.nextInt());
		}
		ArrayList<ArrayList<Integer>> res = combinationSum(c,t);
		for(ArrayList<Integer>  l : res )
		{
			System.out.println(l);
		}
	}
	public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> c, int t)
	{
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(c.size()==0|| c==null)
		{
			return res;
		}
		Collections.sort(c);
		ArrayList<Integer> temp = new ArrayList<>();
		combinationSum(c,t,temp,res,0);
		HashSet<ArrayList<Integer>> set = new HashSet<>(res);
		res.clear();
		res.addAll(set);
		return res;
	}
	public static void combinationSum(ArrayList<Integer> c, int t, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res,
			int start) {
		if(t==0)
		{
			res.add(new ArrayList<>(temp));
			return;
		}
		
		for(int i  = start ; i < c.size() ; i++ )
		{
			if(t < c.get(i))
			{
				return;
			}
			temp.add(c.get(i));
			combinationSum(c, t - c.get(i), temp, res, i + 1 );
			temp.remove( temp.size() - 1 );
		}
	}

}
