package maxMinSubArray;
import java.util.*;
public class Solution {
public static void main(String args[])
{
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	ArrayList<Integer> a = new ArrayList<>();
	for(int i = 0  ; i < n; i++ )
	{
		a.add(in.nextInt());
	}
	int b = in.nextInt();
	Solution obj = new Solution();
    System.out.println(obj.solve(a,b));
}
public int solve(ArrayList<Integer> a, int b) {
	TreeMap<Integer,Integer> tmap = new TreeMap<>();
	for(int i = 0 ; i < a.size() ;i++)
	{
		tmap.put(a.get(i), i);
	}
	int x = tmap.get(tmap.lastKey());
	int y = tmap.get(tmap.firstKey());
	while( x != y )
	{
		y = a.get(x);  
	}
    return 0;
}
}
