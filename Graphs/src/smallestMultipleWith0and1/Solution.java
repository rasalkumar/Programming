package smallestMultipleWith0and1;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution obj = new Solution();
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		System.out.println(obj.multiple(A));
		

	}
	public int mod(String t,int A)
	{
		int r = 0;
		for(int i = 0 ; i < t.length(); i++ )
		{
			r = r * 10 + (t.charAt(i)-'0');
			r = r % A;
		}
		return r;
	}
	public String multiple(int A) {
		Queue<String> q = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();
		String t = "1";
		q.add(t);
		while(!q.isEmpty())
		{
			t = q.poll();
			int rem = mod(t,A);
			
			if(rem==0)
			{
				return t;
			}
			else if(!visited.contains(rem))
			{
				visited.add(rem);
				q.add(t+"0");
				q.add(t+"1");
			}
		}
		return "";
    }

}
