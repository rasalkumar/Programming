package oracle2018;
import java.util.*;
public class ScoreRuns {
	static ArrayList<ArrayList<Integer>> result;
	static ArrayList<ArrayList<Integer>> result2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in. nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			result = new ArrayList<>();
			result2 = new ArrayList<>();
			ArrayList<Integer> temp = new ArrayList<>();
			combinations( n , temp );
			for(int j = 0 ; j < result.size() ; j++ )
			{
				int flag = 0 ;
				ArrayList<Integer> b = result.get(j); 
				for(int i = 1 ; i < b.size() ; i++ )
				{
					if( b.get(i) == 2 && b.get(i-1) == 2 )
					{
						flag = 1;
						break;
					}
				}
				if( flag == 0 )
					result2.add(b);
			}
			for(ArrayList<Integer> b : result2)
			{
				System.out.println(b);
			}
		}
	}
	public static void combinations( int n, ArrayList<Integer> temp )
	{
		if( n == 0 )
		{
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		for( int i = 1 ; i <= 2 ; i++ )
		{
			if( n < 0 )
				return ;
			temp.add(i);
			combinations(n-i,temp);
			temp.remove(temp.size()-1);
		}
	}
}
