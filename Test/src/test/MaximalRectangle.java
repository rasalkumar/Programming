package test;
import java.util.*;
public class MaximalRectangle {
static int n,m;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		int a[][] = new int[n][m];
		for(int i = 0 ; i < n ; i++)
		{
			for( int j = 0 ; j < m ; j++ )
			{
				a[i][j] = in.nextInt();
			}
		}
		int ans = maximalRectangle(a);
		System.out.println(ans);

	}
	public static int maximalRectangle(int [][] a)
	{
		int height[][] = new int[n][m];
		for(int i = 0 ; i < n ; i++ )
		{
			for(int j = 0 ; j < m ; j++ )
			{
				if(a[i][j] == 0)
					height[i][j] = 0;
				else
					height[i][j] = i == 0 ? 1 : height[i-1][j] + 1;
			}
		}
		int maxArea = 0;
		for( int i = 0 ; i < n ; i++ )
		{
			int area = largestRectangle(height[i]);
			if(area >maxArea)
				maxArea = area;
		}
		return maxArea;
	}
	public static int largestRectangle(int[] height)
	{
		if(height == null || height.length == 0)
			return 0;
		int i = 0;
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		while( i < height.length )
		{
			if(stack.isEmpty() || height[stack.peek()] <= height[i])
			{
				stack.push(i++);
			}
			else
			{
				int p = stack.pop();
				int h = height[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1 ;
				maxArea = Math.max(maxArea, h*w);
			}
		}
		while(!stack.isEmpty())
		{
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1 ;
			maxArea = Math.max(maxArea, h*w);
		}
		return maxArea;
	}

}
 