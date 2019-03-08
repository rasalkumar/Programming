	package freqTest;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		ArrayList<String> str = new ArrayList<>();
		while(st.hasMoreTokens())
		{
			str.add(st.nextToken());
		}
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0 ; i < str.size() ; i++ )
		{
			if(!map.containsKey(str.get(i)))
			{
				map.put(str.get(i), 1);
			}
			else
			{
				map.put(str.get(i), map.get(str.get(i))+1);
			}
		}
		HashSet<String> set = new HashSet<>();
		for(int i = 0 ;i < str.size(); i++)
		{
			set.add(str.get(i));
		}
		ArrayList<String> temp = new ArrayList<>();
		temp.addAll(set);
		Collections.sort(temp);
		for(int i = 0 ;i < temp.size(); i++)
		{
			System.out.println(temp.get(i)+ ":" +map.get(temp.get(i)));
		}
		
	}

}
