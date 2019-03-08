package nBy3ReepeatedNum;

import java.util.*;

public class GFG {
	public static void main(String args)
	{
		ArrayList<Integer> a=  (ArrayList<Integer>) Arrays.asList(1,2,3,1,1);
		int n = a.size();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0 ; i < n ; i++)
		{
			if(!map.containsKey(a.get(i)))
			{
				map.put(a.get(i), 1);
			}
			else
			{
				map.put(a.get(i),map.get(a.get(i))+1);
			}
		}
		double check = n / 3.0;
		for (Map.Entry m:map.entrySet()){
	          if( (int)m.getValue() > check)
	          {
	        	  System.out.println((int)m.getKey());
	          }
		}
		
	}

}
