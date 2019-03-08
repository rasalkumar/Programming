package dec10;
import java.util.*;
public class PalindromePartitioning {
	static ArrayList<ArrayList<String>> result;
	static ArrayList<String> temp;
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		String s = in.next();
		temp = new ArrayList<>();
		result= new ArrayList<>();
		helper(0, s);
		for(ArrayList<String> l : result)
		{
			System.out.println(l);
		}
	}
	 
	public static void helper(int start, String s)
	{
		if( start == s.length() )
		{
			ArrayList<String> partition = new ArrayList<>(temp);
			result.add(partition);
			return;
		}
		for(int i = start + 1 ; i <= s.length() ; i++ )
		{
			if( isPalin( s.substring(start, i)) )
			{
				temp.add(s.substring(start, i));
				helper(i , s);
				temp.remove(temp.size()-1);
			}
		}
	}
	public static boolean isPalin(String s)
	{
		int i = 0 ; 
		int j = s.length() - 1 ;
		while( i <= j )
		{
			if(s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
			
		}
		return true;
	}
}
