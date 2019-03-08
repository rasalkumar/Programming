package oracleFreshersNITWarangal;
import java.util.*;
public class SubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			int a[] = new int[n];
			for(int i = 0 ; i < n ; i++ )
			{
				a[i] = in.nextInt();
			}
			int x = in.nextInt();
			subArrayPrint(a,x);
		}
	}
	public static void subArrayPrint(int[] a,int x)
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		int start = 0 , end = 0;
		int sum = 0; 
		while( end < a.length )
		{
			if(sum < x)
			{
				sum += a[end];
				end++;
			}
			else
			{
				ArrayList<Integer> temp = func(a , start , end );
				result.add(new ArrayList<>(temp));
				sum -= a[start];
				start++;
			}
		}
		for(ArrayList<Integer> l : result)
			System.out.println(l);
	}
	public static ArrayList<Integer> func(int[] a, int start,int end)
	{
		ArrayList<Integer> temp = new ArrayList<>();
		for(int i= start; i < end ;i++)
		{
			temp.add(a[i]);
		}
		return temp;
	}
	
}
