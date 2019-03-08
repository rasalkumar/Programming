package amazon;
import java.util.*;
public class NextGreaterElement {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i = 0 ; i < n ;i++)
		{
			a[i] = in.nextInt();
		}
				
		Stack<Integer> stack = new Stack<>();
		int[] nge = new int[n];
		for(int  i = a.length - 1 ; i >= 0 ; i-- )
		{
			if(!stack.isEmpty())
			{
				while(!stack.isEmpty() && stack.peek() <= a[i])
				{
					stack.pop();
				}
			}
			nge[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(a[i]);
		}
		for(int i = 0 ; i < n ; i++)
		{
			System.out.println(a[i] + " " + nge[i]);
		}

	}

}
