package stairs;

public class Solution {
	int fib[]=new int[100];
	public int climbStairs(int a) {
		return fibonacci(a+1);
	}
	 private int fibonacci(int n) {
		if(n<=1)
		{
			return n;
		}
		if(fib[n]!=0)
		{
			return fib[n];
		}
		fib[n]=fibonacci(n-1)+fibonacci(n-2);
		return fib[n];
	}
	public static void main(String[] args){
	     Solution obj=new Solution();   
		 int a = 3;
	        
	        System.out.println("" + obj.climbStairs(a));
	    }

}
