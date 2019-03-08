package p241;
// Given  2 integers n and k return all possible combinations of k out of 1 and n.
import java.util.*;
public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		ArrayList<ArrayList<Integer>> result =new ArrayList<>();
		if(n <= 0 || k>n)
		{
			System.out.println(result);
		}
		else
		{
			ArrayList<Integer> temp = new ArrayList<>();
			dfs(n ,k,1,result,temp);
			for(ArrayList<Integer> l : result)
			{
				System.out.println(l);
			}
		}
	}
	public static void dfs(int n, int k, int start, ArrayList<ArrayList<Integer>> result,ArrayList<Integer> temp)
	{
		
		if(temp.size()==k)
		{
			result.add(new ArrayList<Integer>(temp));
			return;
			
		}
		for(int i = start; i <= n ;i++)
		{
			temp.add(i);
			dfs(n, k, i+1, result, temp);
			//System.out.println( temp );
			temp.remove(temp.size()-1);
		}
	}

}
