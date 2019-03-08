package sherlockAndAnagrams;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- > 0)
		{
			String s = in.next();
			System.out.println(sherlockAndAnagrams(s));
		}
	}
	static int sherlockAndAnagrams(String s) {
        HashMap<String,ArrayList<Integer>> map =new HashMap<>();
        int count = 0 ;
        int n = s.length();
        ArrayList<String> str =new ArrayList<>();
        for(int i = 0 ;i < n ;i++)
        {
            for(int j = i + 1; j <= n ;j++ )
            {
                String temp = s.substring(i,j);
                str.add(temp);
            }
        }
//        for(int i = 0 ; i < str.size() ; i++ )
//        {
//        	System.out.println(str.get(i));
//        }
        
        for(int i = 0 ; i < str.size() ; i++ )
        {
            String temp = str.get(i);
            char[] c = temp.toCharArray();
            Arrays.sort(c);
            String p = String.valueOf(c);
            System.out.println(p);
            if(!map.containsKey(p))
            {
            	ArrayList<Integer> x = new ArrayList<>();
            	x.add(i+1);
                map.put(p,x);
            }
            else
            {
                map.get(p).add(i+1);
            }
        }
        for(Map.Entry<String, ArrayList<Integer>> entry  : map.entrySet())
        {
        	count += entry.getValue().size();
        }
        return count;
    }

}
