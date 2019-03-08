package largestRectinHistogram;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			ArrayList<Integer> a = new ArrayList<>(); 
			for( int i = 0 ; i  < n ; i++ )
			{
				a.add(in.nextInt());
			}
			System.out.println(largest(a));
		}

	}
	public static int largest(ArrayList<Integer> heights)
	{
		if(heights == null || heights.size() == 0)
			return 0;
		int i = 0, max = 0;
		Stack<Integer> stack = new Stack<>();
		while(i < heights.size())
		{
			if(stack.isEmpty() || heights.get(stack.peek()) <= heights.get(i) )
			{
				stack.push(i++);
			}
			else
			{
				int p = stack.pop();
				int h = heights.get(p);
				int w = stack.isEmpty() ? i : i - stack.peek() -1 ;
				max = Math.max( max , h * w );
			}
		}
		while(!stack.isEmpty())
		{
			int p = stack.pop();
			int h = heights.get(p);
			int w = stack.isEmpty() ? i : i - stack.peek() -1 ;
			max = Math.max( max , h * w );
		}
		return max;
	}

}
