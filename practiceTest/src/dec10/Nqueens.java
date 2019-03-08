package dec10;
import java.util.*;
public class Nqueens {
	static int queens[];
	static int N;
	static ArrayList<ArrayList<String>> result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		queens = new int[N];
		result = new ArrayList<>();
		helper(0);
		System.out.println(result.size());
		for(int i = 0 ; i < result.size(); i++)
		{
			for(int j = 0 ; j < N ; j++ )
			{
				System.out.println(result.get(i).get(j));
			}
			System.out.println();
		}
	}
	public static void helper(int n)
	{
		if(n == N){
			System.out.println("*****");
			queensChess();
		}
		else
		{
			for(int i = 0 ; i < N ; i++ )
			{
				queens[n] = i;
				//System.out.println(i);
				if(isSafe(n))
				{
					//System.out.println(i);
					helper(n+1);
				}
				
			}
		}
	}
	public static boolean isSafe(int n)
	{
		for(int i = 0 ; i < n ; i++ )
		{
			if( queens[i] == queens[n] )
				return false;
			if( queens[n] - queens[i] == (n - i) )
				return false;
			if( queens[i] - queens[n] == (n - i) )
				return false;
		}
		return true;
		
	}
	public static void queensChess()
	{
		ArrayList<String> temp = new ArrayList<String>();
		for(int i =0; i < N; i++){
            String row = "";
            for(int j = 0; j < N; j++){
                if(queens[i] == j)
                    row += "Q";
                else
                    row += ".";
            }
            //System.out.println(temp);
            temp.add(row);
        }
		result.add(temp);
	}
}
