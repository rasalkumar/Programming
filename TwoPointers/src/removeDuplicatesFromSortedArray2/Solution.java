package removeDuplicatesFromSortedArray2;
import java.util.*;
public class Solution {
	public int removeDuplicates(ArrayList<Integer> a) {
		
		if(a==null||a.size()==0)
		{
			return 0;
		}
		if(a.size()<=2)
		{
			return a.size();
		}
		ArrayList<Integer> result=new ArrayList<>();
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<a.size();i++)
		{
			if(map.containsKey(a.get(i)))
			{
				if(map.get(a.get(i))==1)
				{
					result.add(a.get(i));
					map.put(a.get(i), 2);
				}
				else
				{
					map.put(a.get(i), map.get(a.get(i))+1);
				}
			}
			else
			{
				map.put(a.get(i), 1);
				result.add(a.get(i));
			}
		}
		a.clear();
		for(int j=0;j<result.size();j++)
		{
			a.add(result.get(j));
			System.out.println(a.get(j));
			
		}
		
		return a.size();
	}
	public static void main(String args[])
	{
		ArrayList<Integer> a= new ArrayList<>();
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(2);
		a.add(2);
		a.add(3);
		a.add(3);
		Solution obj= new Solution();
		System.out.println(obj.removeDuplicates(a));
	}

}
