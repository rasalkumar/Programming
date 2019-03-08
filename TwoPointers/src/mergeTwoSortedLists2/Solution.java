package mergeTwoSortedLists2;
import java.util.*;
public class Solution {
	public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
	    for(int i=0;i<b.size();i++)
	    {
	        a.add(b.get(i));
	    }
	    Collections.sort(a);
	}

}
