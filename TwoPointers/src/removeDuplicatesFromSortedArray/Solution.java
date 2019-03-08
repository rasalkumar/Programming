package removeDuplicatesFromSortedArray;
import java.util.*;
public class Solution {

	public int removeDuplicates(ArrayList<Integer> a) {
	    if(a.size()<2)
	    {
	        return a.size();
	    }
	     ArrayList<Integer> result = new ArrayList<Integer>(new LinkedHashSet<Integer>(a));
	     a.clear();
	     for(int i=0;i<result.size();i++)
	     {
	    	 a.add(result.get(i));
	     }
	    return a.size();
	}
	public static void main(String args[])
	{
		
	}
}
