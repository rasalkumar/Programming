package p237;
import java.util.*;
public class GenerateParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n  = in.nextInt();
		ArrayList<String> res ;
		res = generateParenthesis(n);
		for(String a : res)
		{
			System.out.println(a);
		}
		
	}

	public static ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> res = new ArrayList<>();
		if(n==0)
		{
			return res;
		}
		dfs(res,"",n,n);
		return res;
	}

	private static void dfs( ArrayList<String> res,String s, int left, int right ) 
	{
		if( left > right )
		{
			return;
		}
		if( left == 0 && right == 0 )
		{
			res.add(s);
			return ;
		}
		if( left > 0 )
		{
			dfs(res, s+"(", left-1, right);
		}
		if( right > 0 )
		{
			dfs(res, s+")", left, right-1);
		}
	}

}
