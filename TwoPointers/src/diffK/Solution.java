package diffK;
import java.util.*;
public class Solution {
	 public  int diffPossible(ArrayList<Integer> a, int b) {
	        int i = 0;
	        int j = 1;
	        while(j < a.size() && i < a.size()){
	            
	            //System.out.println(a.get(j) + " " + a.get(i));
	            
	                int diff = a.get(j) - a.get(i);
	               // System.out.println("diff " + diff);
	                if(diff == b && i != j)
	                    return 1;
	                else if(diff < b)
	                    j++;
	                else 
	                    i++;
	            
	        }
	        return 0;
	        
	 }

}
