package week2;



import edu.princeton.cs.algs4.Stack;

public class QueueWithTwoStacks{
	
	Stack<Integer> s;
	Stack<Integer> temp ;
	public QueueWithTwoStacks()
	{
		 s = new Stack<Integer>();
		 temp = new Stack<Integer>();
	}
	public void enqueue(int data)
	{
		 if(s.size()==0)
		 {
			 s.push(data);
		 }
		 else
		 {
			 for(int i=0;i<s.size();i++)
			 {
				 temp.push(s.pop());
			 }
			 temp.push(data);
			 for(int i=0;i<s.size();i++)
			 {
				 s.push(temp.pop());
			 }
		 }
	}
	public int dequeue()
	{
		if (s.size()==0)
		{
			throw new NullPointerException();
		}
		else
		{
			 for(int i=0;i<s.size();i++)
			 {
				 temp.push(s.pop());
			 }
			 
			 
		}
		
		return temp.pop();
	}
}
