package week2;



public class StackWithMax {
	
	private int[] a;
	private int n;
	
	public StackWithMax(int capacity)
	{
		a=new int[capacity];
	}
	public boolean isEmpty()
	{
		return n==0;
	}
	public int size()
	{
		return n;
	}
	public void push(int b)
	{
		a[n++]=b;
	}
	public int pop()
	{
		return a[--n];
	}
	public int max()
	{
		int max=a[0];
		for(int i=1;i<n;i++)
		{
			if(a[i]>max)
			{
				max=a[i];
			}
		}
		return max;
	}

}
