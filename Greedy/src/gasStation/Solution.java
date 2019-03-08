package gasStation;
import java.util.*;
public class Solution {
	
	public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
        if(gas == null || cost == null || gas.size() == 0 || cost.size() == 0 ||
           gas.size() != cost.size())
            return -1;
        int n = gas.size();
        
        int sumRemaining= 0;
        int total = 0;
        int start = 0;
        
        for(int i = 0; i < n; i++){
            int remaining = gas.get(i) - cost.get(i);
            if(sumRemaining >= 0)
                sumRemaining += remaining;
            else{
                sumRemaining = remaining;
                start = i;
            }
            total += remaining;
        }
        
        if(total >= 0)
            return start;
        else return -1;                               
    }
    public static void main(String[] args){
        ArrayList<Integer> gas = new ArrayList<Integer>();
        gas.add(1);
        gas.add(2);
        ArrayList<Integer> cost = new ArrayList<Integer>();
        cost.add(2);
        cost.add(1);
        Solution obj=new Solution();
        System.out.println(obj.canCompleteCircuit(gas,cost));
    }
}
