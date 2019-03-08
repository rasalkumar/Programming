package oracleFreshersNITWarangal;
import java.util.*;
public class BalancedParenthesis {
	static ArrayList<String> res;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			 res =new ArrayList<>();
			parenthesis(n);
			for(String s : res )
				System.out.println(s);
		}
	}
	public static void parenthesis(int n)
	{
		String s = "";
		
		dfs(s,n,n);
		
	}
	public static void dfs(String s,int left,int right)
	{
		if(left > right)
			return;
		if(left == 0 && right == 0)
		{
			res.add(s);
			return;
		}
		if(left > 0)
			dfs(s + "(" , left - 1 , right );
		if(right > 0)
			dfs(s + ")" , left , right - 1 );
	}
}
