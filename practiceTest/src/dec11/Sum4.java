package dec11;
import java.util.*;
public class Sum4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int target = in.nextInt();
		int a[] = new int[n];
		for(int i = 0 ; i < n ; i++ )
		{
			a[i] = in.nextInt();
		}
		Arrays.sort(a);
		//HashMap<Integer, Pair> map = new HashMap<>();
		for( int i = 0 ; i < n ; i++ )
		{
			for( int j = i + 1 ; j < n ; j++ )
			{
				int k = j + 1;
				int l = a.length - 1;
				while( k < l)
				{
					int sum = a[i] + a[j] + a[k] + a[l];
					if(sum < target)
					{
						k++;
					}
					else if(sum > target)
					{
						l--;
					}
					else
					{
						ArrayList<Integer> temp = new ArrayList<>();
						temp.add(a[i]);
						temp.add(a[i]);
						temp.add(a[i]);
						temp.add(a[i]);
					}
						
				}
			}
		}
		
	}
	static class Pair
	{
		int x,y;
	}

}
