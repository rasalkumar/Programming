package permutations;
import java.lang.reflect.Array;
import java.util.*;
public class Solution {
	static ArrayList<Integer> a;
	static ArrayList<ArrayList<Integer>> result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			a = new ArrayList<>();
			for(int i = 0 ; i < n ; i++)
			{
				a.add(in.nextInt());
			}
			result = new ArrayList<>();
			permutation();
			for(ArrayList<Integer> l : result)
				System.out.println(l);
		}
	}
	public static void permutation()
	{
		int[] b = new int[a.size()];
		for(int i = 0 ; i < b.length ; i++)
			b[i] = a.get(i);
		permutation(0,b);
	}
	public static void permutation(int start,int[] b)
	{
		if(start >= b.length)
		{
			result.add(new ArrayList<>(convertToArray(b)));
			return;
		}
		
		for(int i = start ; i < b.length;i++)
		{
			swap(b,start,i);
			permutation( start + 1 , b);
			swap(b,start,i);
			
		}
	}
	public static ArrayList<Integer> convertToArray(int[] b)
	{
		ArrayList<Integer> temp = new ArrayList<>();
		for(int i = 0 ; i < b.length ; i++)
			temp.add(b[i]);
		return temp;
	}
	public static void swap(int[] b ,int x ,int y)
	{
		int temp = b[x];
		b[x] = b[y];
		b[y] = temp;
	}

}
