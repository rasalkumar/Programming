package countTriplets;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		List<Long> arr = new ArrayList<>();
		int n = in.nextInt();
		long r = in.nextLong();
		for(int i = 0 ; i < n ;i++)
		{
			arr.add(in.nextLong());
		}
		System.out.println(countTriplets(arr,r));
	}
	 static long countTriplets(List<Long> arr, long r) {
	        HashMap<Long,ArrayList<Integer>> map = new HashMap<>();
	        for(int i = 0; i < arr.size() ;i++)
	        {
	            if(!map.containsKey(arr.get(i)))
	            {
	                ArrayList<Integer> x = new ArrayList<>();
	                x.add(i);
	                map.put(arr.get(i), x);
	            }
	            else
	            {
	                map.get(arr.get(i)).add(i);
	            }
	        }
	        for(ArrayList<Integer> l : map.values())
	        {
	        	System.out.println(l);
	        }
	        long count = 0 ;
	        HashSet<Long> set = new HashSet<>();
	        for(int i = 0 ; i < arr.size(); i++)
	        {
	            set.add(arr.get(i));
	        }
	        ArrayList<Long> temp = new ArrayList<>();
	        temp.addAll(set);
	        for(int i = 0 ; i < temp.size() ; i++ )
	        {
	            if(map.containsKey(temp.get(i)) && temp.get(i) % r == 0 && 
	               map.containsKey(temp.get(i)/r) && map.containsKey(temp.get(i)*r))
	            {
	                count += map.get(temp.get(i)).size() * map.get(temp.get(i)/r).size()
	                    * map.get(temp.get(i)*r).size();
	            }
	        }
	        return count;

	    }

}
