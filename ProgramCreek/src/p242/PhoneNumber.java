package p242;
import java.util.*;
public class PhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String digits = in.next();
		ArrayList<String> res = letterCombinations(digits);
		for(String a : res)
		{
			System.out.println(a);
		}
		
	}

	public static ArrayList<String> letterCombinations(String digits) {
		// TODO Auto-generated method stub
		ArrayList<String> res = new ArrayList<>();
		if(digits==null || digits=="")
		{
			return res;
		}
		HashMap<Integer,String> map = new HashMap<>();
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		map.put(0, "");
		ArrayList<Character> temp = new ArrayList<>();
		dfs(digits,res,map,temp);
		return res;
	}
	public static void dfs( String digits, ArrayList<String> res,HashMap<Integer, String> map,ArrayList<Character> temp)
	{
		if( digits.length() == 0 )
		{
			char[] arr = new char[temp.size()];
			for(int i = 0 ; i < temp.size() ; i++ )
			{
				arr[i] = temp.get(i);
			}
			res.add(String.valueOf(arr));
			return ;
		}
		Integer y = Integer.valueOf(digits.substring(0,1));
		String letters = map.get(y);
		for(int  i = 0 ; i < letters.length() ; i++ )
		{
			temp.add(letters.charAt(i));
			dfs(digits.substring(1), res, map, temp);
			temp.remove(temp.size()-1);
		}
	}

}
