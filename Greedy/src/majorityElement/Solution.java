package majorityElement;

import java.util.*;

public class Solution {
	public int majorityElement(final List<Integer> a) {
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i : a){
            if(map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
            map.put(i, 1);
        }
		
		Iterator it=map.entrySet().iterator();
		int majorElement=Integer.MIN_VALUE;
		int maxValue=Integer.MIN_VALUE;
		while(it.hasNext())
		{
			Map.Entry pair=(Map.Entry)it.next();
			if((int)pair.getValue()>maxValue)
			{
				maxValue=(int)pair.getValue();
				majorElement=(int)pair.getKey();
			}
		}
		
		return majorElement;
	}
	public static void main(String args[])
	{
		List<Integer> a=new ArrayList<Integer>();
		a.add(2);
		a.add(1);
		a.add(2);
		Solution obj=new Solution();
		System.out.println(obj.majorityElement(a));
	}
}
