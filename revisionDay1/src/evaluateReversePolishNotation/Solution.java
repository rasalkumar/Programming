package evaluateReversePolishNotation;
import java.util.*;
public class Solution {
	public int evalRpn(String[] tokens)
	{
		
		String operators="+-*/";
		
		Stack<String> stack= new Stack<String>();
		for(String t :tokens )
		{
			if(!operators.contains(t))
			{
				stack.push(t);
			}
			else{
			int b=(Integer.parseInt(stack.pop()));
			int c=(Integer.parseInt(stack.pop()));
			if(t=="+")
			{
				stack.push(String.valueOf(b+c));
			}
			else if(t=="-")
			{
				stack.push(String.valueOf(b-c));
			}
			else if(t=="*")
			{
				stack.push(String.valueOf(b*c));
			}
			else if(t=="/")
			{
				stack.push(String.valueOf((int)b/c));
			}
			}
		}
		return Integer.valueOf(stack.pop());
	}

}
 