package longestValidParenthesis;

import java.util.Stack;

public class Solution {
	public int longestValidParentheses(String s)
	{
		int result=0;
		Stack<int[]> stack=new Stack<int[]>();
		for(int i=0;i<=s.length()-1;i++)
		{
		
			if (s.charAt(i)=='(')
			{
				int a[]={i,0};
				stack.push(a);
			}
			else
			{
				if(stack.isEmpty()||stack.peek()[1]==1)
				{
					int a[]={i,1};
					stack.push(a);
				}
				else
				{
					stack.pop();
					int currentLen=0;
					if(stack.empty())
					{
						currentLen=i+1;
					}
					else
					{
						currentLen=i-stack.peek()[0];
					}
					result=Math.max(result, currentLen);
				}
			}
		}
		return result;
	}
	public static void main(String args[])
	{
		Solution obj=new Solution();
		String s=")()())";
		System.out.println(obj.longestValidParentheses(s));
	}

}
