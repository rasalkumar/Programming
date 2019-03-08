package bnyMellon;
import java.util.*;
public class SubSeqRecursion {
static ArrayList<Character> temp;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String x = "abc";
		temp = new ArrayList<>();
		helper(x,0);
		
	}
	public static void helper(String s, int start)
	{
		if(start == s.length()+1)
			return;
		System.out.println(temp);
		for( int i = start ; i < s.length() ; i++ )
		{
			temp.add(s.charAt(i));
			helper(s,i+1);
			temp.remove(temp.size()-1);
		}
	}

}
